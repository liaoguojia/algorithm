package com.greedy;

import java.util.Arrays;

/**
 * 构造的最大连续整数
 * 链接：https://leetcode.cn/problems/maximum-number-of-consecutive-values-you-can-make/
 * 问题：给定一个整数数组 coins，从中选出一些元素的和为 x ，那么称，你可以构造出 x。返回从 0 开始（包括 0），最多能构造出多少个连续整数
 * 分析：假设已经构造出[0,x]的连续整数区间，继续选择下一个元素y，则必定能构造出 [0,x]和[y,x+y]。若y<=x+1，则能继续构造连续区间[0,x+y]，否则还是[0,x]
 *      方法一 - 贪心： 每次选择的y都应该是最小值，这样若选择y后不能构造更大连续区间，y之后的值更大，更无法连续
 */
public class MaximumConsecutive {
    public int getMaximumConsecutive(int[] coins) {
        Arrays.sort(coins);
        int res = 0;
        for(int coin : coins){
            if(coin <= res+1)   res += coin;  // 新的连续区间
            else    break;
        }
        return res+1;
    }
}
