package com.dp;


import java.util.Arrays;

/**
 * 正则匹配 - 动态规划
 * 链接：https://leetcode.cn/problems/regular-expression-matching/
 * 问题：给你一个字符串s 和一个 字符规律 p，请你来实现一个支持 '.'和'*'的正则表达式匹配。
 *              '.' 匹配任意单个字符
 *              '*' 匹配零个或多个前面的那一个元素
 * 分析： 动态规划：慢慢分析
 *      dp[i][j] 表示 s.substring(0,i)能否由 p.substring(0,j)匹配
 *      慢慢分情况……
 */
public class RegexMatch {

    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        dp[0][0] = true;
        for(int j = 1 ; j < p.length()+1 ;j++){
            if(p.charAt(j-1)=='*'){
                dp[0][j] = dp[0][j-1]|dp[0][j-2];
            }else{
                dp[0][j] = false;
            }
        }
        for(int i = 1 ; i < s.length()+1 ;i++){
            for(int j = 1 ; j < p.length()+1 ; j++){
                if(p.charAt(j-1) == '.'){
                    dp[i][j] = dp[i-1][j-1]?true:false;
                }else if(p.charAt(j-1) == '*'){
                    dp[i][j] = (dp[i][j-1]|dp[i][j-2]);  //*取0或1
                    if(p.charAt(j-2)=='.'){
                        for(int m = i ; m >= 0 ; m--){
                            dp[i][j] |= dp[m][j];
                        }
                    }else{
                        dp[i][j] |= dp[i-1][j]&(s.charAt(i-1)==p.charAt(j-2));
                    }
                }else{
                    dp[i][j] = p.charAt(j-1)==s.charAt(i-1)?dp[i-1][j-1]:false;
                }
            }
        }
        for(boolean[] i:dp){
            System.out.println(Arrays.toString(i));
        }
        return dp[s.length()][p.length()];
    }
}
