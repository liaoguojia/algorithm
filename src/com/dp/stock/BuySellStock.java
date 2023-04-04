package com.dp.stock;

/**
 * 买卖股票的最佳时机
 * 链接：https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/
 * 问题：给定整数数组 prices ，其中prices[i] 表示某支股票第 i 天的价格。
 *      只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 * 分析：
 *      方法一 - 动态规划：
 *      方法二 - 双指针：
 *      方法三 - 单调栈 （ 在price数组中，对每个元素，找到它前面最小的元素，求最大的差 ）：单调栈中保存最小元素
 *
 */
public class BuySellStock {
    /**
     * 方法一 - 动态规划：
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0)
            return 0;
        int length = prices.length;
        int hold = -prices[0];//持有股票
        int noHold = 0;//不持有股票
        for (int i = 1; i < length; i++) {
            //递推公式
            noHold = Math.max(noHold, hold + prices[i]);
            hold = Math.max(hold, -prices[i]);
        }
        //毋庸置疑，最后肯定是手里没持有股票利润才会最大，
        //也就是卖出去了
        return noHold;
    }

}
