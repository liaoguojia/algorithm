package com.stack.monotonicStack;
import java.util.*;

/**
 * 单调栈 - 最大宽度坡
 * 链接：https://leetcode.cn/problems/maximum-width-ramp/
 * 问题：给定一个整数数组nums，坡是元组(i, j)，其中i < j 且 nums[i] <= nums[j]。这样的坡的宽度为 j - i。
 *      找出nums中的坡的最大宽度，如果不存在，返回 0 。
 * 分析：对nums中的每一个元素，找到它后面比他大的最远的一个元素下标。（单调栈的场景）
 *      方法一 - 单调递减栈：从头遍历nums，若nums[i]小于栈顶，则入栈
 *              再从后往前遍历，若nums[j]>=栈顶，则出栈，
 *
 */
public class MaxWidthRamp {
    /**
     *
     * @param nums
     * @return
     */
    public int maxWidthRamp(int[] nums) {
        int res = 0 ;
        Deque<Integer> stack = new LinkedList<>();

        for(int i = 0 ; i < nums.length ;i++){
            // 将更小的元素入栈
            if(stack.isEmpty() || nums[stack.peekFirst()]>=nums[i]){
                stack.offerFirst(i);
            }
        }

        for(int j = nums.length-1 ; j > res ; j--){
            while( !stack.isEmpty() && nums[stack.peekFirst()] <= nums[j]){
                res = Math.max(res,j-stack.pollFirst());
            }
        }
        return res;
    }
}
