package com.backtrack;

/**
 * 数组的目标和 - 回溯
 * 链接： https://leetcode.cn/problems/target-sum/
 * 问题 ： 向整数数组中的每个整数前添加 '+' 或 '-'，构成一个表达式，求运算结果等于 target 的不同 表达式 的数目
 * 分析 ： nums 的每个元素都可以添加符号 + 或 -，因此每个元素有 2种添加符号的方法，n 个数共有 2^n种添加符号的方法，对应 2^n种不同的表达式
 *      1. 暴力破解：遍历nums中每一位取+/-，可以使用 长为nums.length的二进制串 来表示一种情况，总共2^n种情况，判断每一种情况下，和是否为target
 *                tips：(1<<i)&kind)==0 判断kind的第i位 是否为0 ，时间复杂度 O(n*2^n)
 *      2. 回溯：
 *      3. 动态规划
 */
public class TargetSum {

    /**
     *
     * @param nums
     * @param target
     * @param start
     * @return
     */
    public static int backtrack(int[] nums,int target,int start){
        int res = 0;
        if(start==nums.length-1){
            if(target==nums[start]) res++;
            if(target==-nums[start])    res++;
            return res;
        }
        return backtrack(nums,target-nums[start],start+1) + backtrack(nums,target+nums[start],start+1);
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,1,1};
        int res = backtrack(nums,3,0);
        System.out.println(res);
    }
}
