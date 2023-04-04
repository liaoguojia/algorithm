package com.dp;
import java.util.Arrays;

/**
 * 动态规划 - 零钱兑换问题  （）
 */
public class CoinsAmount {
    /**
     * 链接：https://leetcode.cn/problems/coin-change
     * 状态转移方程 dp[i] = min(dp[i-coin]+1, dp[i])
     * @param coins  整数数组 coins ，表示不同面额的硬币
     * @param amount  整数 amount ，表示总金额
     * @return  计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1
     * 每种硬币的数量是无限的
     */
    public static int coinChange(int[] coins, int amount) {
        int max = amount+1;
        int[] dp = new int[amount+1];
        Arrays.fill(dp,max);
        dp[0] = 0;

        for(int i = 1 ; i <= amount ;i++){
            for(int coin : coins){
                if(coin <= i){
                    if(dp[i-coin]==-1){ // 若前一个数值不能组成
                        continue;
                    }
                    dp[i] = Math.min(dp[i-coin]+1,dp[i]);
                }
            }
            if(dp[i]==max){ //若没有硬币面值能组成，赋值-1
                dp[i] = -1;
            }
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        int amount = 6249;
        int[] coins = {186,419,83,408};

        coinChange(coins,amount);
    }

}