package com.dp;

/**
 * 最大子数组和
 * 链接：https://leetcode.cn/problems/maximum-subarray/
 * 问题：给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和
 * 分析：
 *      方法一 - 动态规划：每个元素都有包含和不包含两种状态
 *      方法二 - 动态规划：dp[i] = nums[i]+Math.max(dp[i-1],0)
 */
public class SubArraySum {
    /**
     *
     * @param nums
     * @return
     */
    public int maxSubArray1(int[] nums) {
        int have = nums[0], unhave = nums[0];
        for(int i = 1 ; i < nums.length ;i++){
            unhave = Math.max(have,unhave);
            have = Math.max(nums[i],have+nums[i]);
        }
        return Math.max(have,unhave);
    }

    public int maxSubArray2(int[] nums) {
        int pre = 0, maxAns = nums[0];
        for (int x : nums) {
            pre = Math.max(pre + x, x);
            maxAns = Math.max(maxAns, pre);
        }
        return maxAns;
    }

}
