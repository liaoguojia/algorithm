package com.dp.houseRob;

/**
 * 打家劫舍2 - 动态规划
 * 链接 ： https://leetcode.cn/problems/house-robber-ii/
 *  思路 ： 由于数组成环，若取第一个则不能取最后一个，若不取第一个则可以取最后一个
 *      假设数组 的长度为 n。如果不偷窃最后一间房屋，则偷窃房屋的下标范围是 [0, n-2]；
 *      如果不偷窃第一间房屋，则偷窃房屋的下标范围是 [1, n-1]
 */
public class HouseRobber2 {
    /**
     * 在HouseRobber1的前提下，整个数组是一个环，即第一个元素与最后一个元素相邻
     * @param nums  每个房屋存放金额的非负整数数组,1 <= nums.length <= 100
     * @return
     */
    public int rob(int[] nums) {
        if(nums.length == 1)    return nums[0];
        return Math.max(robRange(nums,0,nums.length-2),robRange(nums,1,nums.length-1));
    }

    /**
     * 在数组的指定范围 能 抢到的最大金额 (闭区间)
     * @param nums
     * @param start
     * @param end
     * @return
     */
    public int robRange(int[] nums,int start,int end){
        if(end - start == 0)    return nums[start];
        int pre = 0, cur = nums[start];
        for(int i = start+1 ; i <= end ;i++){
            int temp = cur;
            cur = Math.max(pre+nums[i],cur);
            pre = temp;
        }
        return cur;
    }

    public static void main(String[] args) {
//        int[] nums = new int[]{2,7,9,3,1};
        int[] nums = {1,2,3};
        int res = new HouseRobber2().rob(nums);
        System.out.println(res);
    }
}
