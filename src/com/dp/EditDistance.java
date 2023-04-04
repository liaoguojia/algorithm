package com.dp;

/**
 * 编辑距离 - 动态规划
 * 链接：https://leetcode.cn/problems/edit-distance/
 * 问题：给定两个字符串word1, word2， 请返回将 word1 转换成 word2 所使用的最少操作数 。
 *      可以对word1进行三种操作 ： 插入一个字符 ； 删除一个字符 ；替换一个字符
 * 分析： 动态规划 ：dp[i][j] 代表 word1 到 i 位置转换成 word2 到 j 位置需要最少步数
 *          当 word1[i] == word2[j]，dp[i][j] = dp[i-1][j-1]；
 *          当 word1[i] != word2[j]，dp[i][j] = min(dp[i-1][j-1], dp[i-1][j], dp[i][j-1]) + 1
 *              其中，dp[i-1][j-1] 表示替换操作，dp[i-1][j] 表示删除操作，dp[i][j-1] 表示插入操作
 *
 */
public class EditDistance {

    /**
     *
     * @param word1
     * @param word2
     * @return   word1 转换成 word2 所需的最少操作数
     */
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length()+1][word2.length()+1];
        for(int i = 0 ; i < dp.length ;i++){
            for(int j = 0 ; j < dp[0].length ;j++){
                if(i==0)    dp[i][j] = j;
                if(j==0)    dp[i][j] = i;
                if(i > 0 && j >0){
                    if(word1.charAt(i-1) == word2.charAt(j-1)){
                        dp[i][j] = dp[i-1][j-1] ;
                    }else{
                        dp[i][j] = 1 + Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]));
                    }
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }
}
