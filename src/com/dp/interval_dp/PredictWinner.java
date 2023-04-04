package com.dp.interval_dp;

/**
 * 预测赢家 - 区间dp
 * 链接：https://leetcode.cn/problems/predict-the-winner
 * 问题：
 * 分析：
 *      方法一 - 递归：
 *      方法二 - 动态规划：使用dp[i][j]保存从区间i-j取数的先手玩家的最佳得分（本玩家-对手得分）。
 *              递推公式：dp[i][j] = max(nums[i]-dp[i+1][j],nums[j]-dp[i][j-1]) 当前玩家选首/尾，都要减去剩下区间的dp，即减去对手比自己多的得分
 */
public class PredictWinner {

    public boolean predictTheWinner2(int[] nums) {
        int[][] dp = new int[nums.length][nums.length];

        for(int i = 0 ; i < nums.length ;i++)   dp[i][i] = nums[i];
        for(int j = 1 ; j < nums.length ;j++){
            for(int i = j-1 ; i >= 0 ;i--){
                dp[i][j] = Math.max(nums[i]-dp[i+1][j],nums[j]-dp[i][j-1]);
            }
        }
        // for(int[] i :dp){
        //     System.out.println(Arrays.toString(i));
        // }
        return dp[0][nums.length-1]>=0;
    }

    public static void main(String[] args) {
        boolean b = new PredictWinner().predictTheWinner2(new int[]{1, 5, 2});
        System.out.println(b);
    }
}
