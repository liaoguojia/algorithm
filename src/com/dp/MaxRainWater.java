package com.dp;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 能存放的最多雨水 - 动态规划
 * 链接：https://leetcode.cn/problems/trapping-rain-water/
 * 问题： 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水
 * 分析： 每个 柱子处 能存放的最多雨水量 = min( 该柱左边最高柱子高度， 右边最高柱子高度 ）
 *      解法1： 动态规划
 *      解法二：双指针
 *      解法三：栈
 */
public class MaxRainWater {
    /**
     *
     * @param height   柱子数组，存放每个柱子的高度
     * @return
     */
    public int trap(int[] height) {
        int[] dp = new int[height.length];
        dp[0] = 0;
        // 左边 最高柱子高度
        for(int i = 1 ; i < height.length ;i++){
            dp[i] = Math.max(dp[i-1],height[i-1]);
        }
        System.out.println(Arrays.toString(dp));

        int rightHeight = 0;  // 右边柱子的 最大高度
        for(int i = dp.length-1 ; i >= 0 ; i--){
            dp[i] = Math.max( Math.min(dp[i],rightHeight) - height[i],0);
            rightHeight = Math.max(rightHeight,height[i]);
        }
        System.out.println(Arrays.toString(dp));

        int res = 0;
        for (int i: dp) res += i;
        return res;
    }

    public static void main(String[] args) {
        int res = new MaxRainWater().trap(new int[]{5,4,1,2});
        System.out.println(res);
    }
}
