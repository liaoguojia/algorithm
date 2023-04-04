package com.dp.houseRob;


/**
 * 打家劫舍1 - 动态规划
 * 链接 ： https://leetcode.cn/problems/house-robber/
 * 问题 ： nums是每个房屋存放金额的非负整数数组，要求两相邻房屋不能同时被偷，返回 能偷的最高金额
 * 解析：
 *      解法一 - 动态规划：若已知 i 之前的金额，则第i个的金额只取决于前两个最大金额
 *      令dp[i]表示到i为止的最大值 ， 则 递推公式：dp[i] = max(dp[i-1],dp[i-2]+nums[i])
 *      解法二 - 动态规划： 对每个i 都有选中时的最大值select 和未选中时的最大值unselect
 *              递推公式 select[i]=unselect[i-1]+nums[i] ; unselect[i]=max(select[i-1],unselect[i-1]) 就是dp[i-1]的含义
 *          而dp[i] = max(select[i],unselect[i]) = max((unselect[i-1]+nums[i]),unselect[i]) = ，就得到第一个公式了
 */
public class HouseRobber1 {
    /**
     * 最后的结果就是 dp[]的最后一个元素，且求dp[i]只需要前两个元素，所以 只用O(1)的空间，不需要定义dp数组
     * @param nums   每个房屋存放金额的非负整数数组 1 <= nums.length <= 100
     * @return  要求两相邻房屋不能同时被偷，返回 能偷的最高金额
     */
    public int rob(int[] nums) {
        int pre=0,cur=nums[0];
        // 只有一个数，直接返回
        if(nums.length==1)  return nums[0];

        for(int i = 1 ; i < nums.length ;i++){
            int temp = cur;
            cur = Math.max(cur,pre+nums[i]);
            pre = temp;
        }
        return cur;
    }

    /**
     *
     * @param nums
     * @return
     */
    public int rob2(int[] nums) {
        int select = nums[0],unselect = 0;
        for(int i = 1 ; i < nums.length ;i++){
            int temp = select;
            select = unselect+nums[i];
            unselect = Math.max(unselect,temp);
        }
        return Math.max(unselect,select);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,7,9,3,1};
        int res = new HouseRobber1().rob(nums);
        System.out.println(res);
    }
}
