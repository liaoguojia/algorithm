package com.dp;

/**
 * 数组的子集 元素和 为target - 动态规划
 * 链接： https://leetcode.cn/problems/partition-equal-subset-sum/
 * 问题：给你一个 只包含正整数 的 非空 数组 nums 。判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 * 分析： 判断数组中是否存在子集，其元素和为target = nums.sum/2 （ 类似0-1背包问题）
 *      使用二维数组dp，dp[i][j]存放数组nums[0->i]的元素 是否可能组成j
 *      递推公式 ： dp[i][j] = dp[i-1][j] | dp[i-1][ j-nums[i] ]
 *      （对于当前nums[i]，遍历dp[i][0->target]，若不取nums[i]则为dp[i-1][j]，若取nums[j]则为dp[i-1][j-nums[i]]
 *  简化：每一层只与前一层有关，且结果只需要最后一层，因此可使用 一维数组
 */
public class SubsetSum {
    /**
     *
     * @param nums
     * @return
     */
    public boolean canPartition(int[] nums) {
        int sum = 0 ;
        for(int num:nums)   sum+=num;
        if(sum%2==1)    return false;
        int target = sum/2;   //要求的子集之和
        boolean[] dp = new boolean[target+1];
        dp[0] = true;
        for(int i = 0 ; i < nums.length ;i++){
            for(int j = target ; j >= 0 ;j-- ){  //由于后面的值要用到前面的数据，从后往前
                dp[j] = dp[j] | (j-nums[i]<0?false:(dp[j-nums[i]])); // 前一个dp[j] 或 前一个位置的dp[j-target]
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {
        boolean res = new SubsetSum().canPartition(new int[]{1,5,11,5});
        System.out.println(res);
    }
}
