package com.dp.stock;

/**
 * 股票交易的最大利润（有冷冻期） - 动态规划
 * 链接： https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-with-cooldown/
 * 问题： 给定一个整数数组prices，其中第  prices[i] 表示第 i 天的股票价格 。规定条件：卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)
 *       求买卖该股票的最大利润
 * 分析： 每天的状态有： 持有股票（买入，持有） ， 不持有股票（卖出，不持有）
 *       dp_have_buy =   今天买入股票的最大利润，必定是昨天处于不持有状态；
 *       dp_have_own =   今天持有股票的最大利润，必定是昨天买入股票
 *       dp_unhave_sell = 今天卖出股票的最大利润，必定是昨天买入股票 或 昨天持有股票 的最大利润 +今天卖出的收益price
 *       dp_unhave_unown = 今天不持有股票的最大利润，必定是昨天 不持有股票 或 昨天卖出股票
 *       每天的各种状态的最大利润只取决于前一天，只需要几个变量即可。最后一天不持有股票，取不持有 与 卖出的最大值
 */
public class TradeStockWIthCold {
    /**
     *
     * @param prices  整数数组prices，其中第  prices[i] 表示第 i 天的股票价格 。
     * @return
     */
    public int maxProfit(int[] prices) {
        int have_buy = -prices[0], have_own = -prices[0], unhave_sell = 0, unhave_unown = 0;
        System.out.println(have_buy+" "+have_own+" "+unhave_sell+" "+unhave_unown);
        for(int i = 1 ; i < prices.length; i++){
            int price = prices[i];
            int prehave_buy = have_buy, prehave_own = have_own, preunhave_sell = unhave_sell, preunhave_unown = unhave_unown;
            have_buy = preunhave_unown-price;
            have_own = Math.max(prehave_buy,prehave_own);
            unhave_sell = Math.max(prehave_buy,prehave_own)+price;
            unhave_unown = Math.max(preunhave_unown,preunhave_sell);
            // System.out.println(have_buy+" "+have_own+" "+unhave_sell+" "+unhave_unown);
        }
        return Math.max(unhave_unown,unhave_sell);
    }
}
