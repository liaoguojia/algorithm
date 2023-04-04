package com.string.palindrome;

/**
 * 统计字符串中回文子串 的数量 - 字符串
 * 回文字符串（正着读和倒过来读一样的字符串）
 * 链接： https://leetcode.cn/problems/palindromic-substrings/
 * 问题 ：
 * 分析：  判断一个字符串是否为回文串 应用 回文中心扩展 的方法 判断
 */
public class PalindromicSubstring {
    /**
     * @param s  统计并返回s字符串中 回文子串 的数目
     * @return  具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。
     */
    public static int countSubstrings(String s) {
        int ans = 0;
        for (int center = 0; center < s.length(); center++) {
            // 对于每一个字符，有两种中心的情况
            ans += expand(s, center, center) + expand(s, center, center + 1);
        }
        return ans;
    }

    /**
     * 在s字符串中，以left和right为左右中心的所有回文串 的数量
     * @param s
     * @param left
     * @param right
     * @return
     */
    private static int expand(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        System.out.println(left+1+" "+(right-1)+" "+(right-1-(left+1)+1+1)/2);
        return (right-1-(left+1)+1+1)/2; //right-left+1 为最长回文串的长度
    }

    public static void main(String[] args) {
        System.out.println(countSubstrings("aaa"));
    }
}
