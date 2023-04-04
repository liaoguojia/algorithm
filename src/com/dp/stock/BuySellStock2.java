package com.dp.stock;

/**
 * 买卖股票的最佳时机 2 - 动态规划
 * 链接：https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-ii/
 * 问题：给定整数数组 prices ，其中prices[i] 表示某支股票第 i 天的价格。
 *      在每一天，你可以决定是否购买和/或出售股票。你在任何时候最多只能持有 一股 股票。你也可以先购买，然后在 同一天 出售。
 *      返回 你能获得的 最大 利润。
 * 分析：
 *      暴力搜索 - 超时：
 *      动态规划：
 *      贪心：
 */
public class BuySellStock2 {

    /**
     * 动态规划 - 优化空间
     * @param prices   股价数组
     * @return
     */
    public int maxProfit(int[] prices) {
        int have = -prices[0];   // 持有
        int unhave = 0;    // 不持有

        for(int i = 1 ; i < prices.length ;i++) {
            int temp = have;
            have = Math.max(have,unhave-prices[i]);   // i天，持有，必定是i-1天 就持有，或 买入
            unhave = Math.max(prices[i]+temp,unhave);   // 不持有，
        }
        return unhave;
    }
}
