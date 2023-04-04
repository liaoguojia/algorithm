package com.double_pointer;

/**
 * 和为target的最长子数组 - 双指针
 * 链接 ： https://leetcode.cn/problems/minimum-operations-to-reduce-x-to-zero/
 * 问题：给定正整数组nums与整数x。每一次操作时，你应当移除数组 nums最左边或最右边的元素，然后从x中减去该元素的值。
 *      若可以将 x 恰好 减到 0 ，返回 最小操作数 ；否则，返回 -1
 * 分析： 也就是 从nums中找到最长的子数组，使得 和为 target = (nums.sum - x)
 *       可用双指针实现。left指向0.right从0遍历到nums.length-1
 */
public class MaxLengthOfChild {
    /**
     *
     * @param nums   正整数组
     * @param x   前缀与后缀 数组元素 之和
     * @return  返回最短的前后缀长度
     */
    public int minOperations(int[] nums, int x) {
        int target = 0;
        for (int i: nums) {
            target += i;
        }
        target -= x;  //要求的 子数组和
        if(target < 0)  return -1; // 即x>数组和，不可能存在满足条件的结果
        int left = 0 , right = 0 , sum = 0, maxLen = -1;
        for(right = 0 ; right<nums.length ;right++){
            sum += nums[right];
            //
            while(sum >= target && left <= right){
                sum -= nums[left++];
            }
            if(sum == target)   maxLen = Math.max(maxLen,right-left+1);
        }
        return maxLen<0?-1:nums.length - maxLen;  // 若不存在满足条件的子数组，就返回-1
    }

    public static void main(String[] args) {
        int x = 10;
        int[] nums = {15,16,17,18,19,20};//{3,3,1,9,1,5,3};
        int res = new MaxLengthOfChild().minOperations(nums,10);
        System.out.println(res);
    }
}
