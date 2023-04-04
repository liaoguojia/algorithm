package com.string;

/**
 * 是字符串平衡的最小删除次数
 * 链接：https://leetcode.cn/problems/minimum-deletions-to-make-string-balanced/
 * 问题：给你一个字符串s，它仅包含字符'a' 和'b'。你可以删除s中任意数目的字符，使得s 平衡。当不存在下标对(i,j)满足i < j ，且s[i] = 'b' 的同时s[j]= 'a' ，此时认为 s 是 平衡 的。
 * 请你返回使 s平衡的 最少删除次数。 （就是使得所有的a都在b前面的最小操作次数）
 *
 * 分析：
 *      方法一 - 遍历分割线： 最后得到的结果必定是在某个分割处，左边全是a，右边全是b。那么其操作次数=左边b个数+右边a个数
 *      方法二 - 动态规划： 递推公式 dp[i] = dp[i-1]   若i处为'b'，不需要删除
 *                              dp[i] = min(dp[i-1]+1,leftB)         若i处为'a'， 若删除a则为dp[i-1]+1，若保留a则删除前面所有的b
 *
 */
public class MinDelToBalance {
    /**
     * 方法一 - 遍历分割线
     * @param s
     * @return
     */
    public int minimumDeletions1(String s) {
        int allB = 0 , allA = 0;
        for (char c : s.toCharArray()){
            if (c=='a') allA++;
            else    allB++;
        }

        int leftB = 0 , rightA = allA;  // 此时分割线在0前面
        int minDel = leftB+rightA;   // 最小删除次数=左边b个数+右边a个数
        for (int i = 0 ; i < s.length() ;i++){   // 对于每一个idx后面的分割线
            if (s.charAt(i)=='a'){
                rightA--;
            }else{
                leftB++;
            }
            minDel = Math.min(minDel,leftB+rightA);
        }
        return minDel;
    }

    /**
     * 动态规划 -
     * @param s
     * @return
     */
    public int minimumDeletions2(String s){
        int dp = 0;
        int leftB = 0;
        for (char c : s.toCharArray()){
            if (c=='b'){
                leftB++;
            }else{
                dp = Math.min(dp+1,leftB);
            }
        }
        return dp;
    }
}
