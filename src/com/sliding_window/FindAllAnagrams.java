package com.sliding_window;
import java.util.*;
/**
 * 在字符串s中找出所有的字符串p的字母异位词 - 滑动窗口
 *
 * 链接：https://leetcode.cn/problems/find-all-anagrams-in-a-string/
 * 问题： 异位词 指由相同字母重排列形成的字符串（包括相同的字符串），
 *      给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引
 * 分析： 在字符串 ss 中构造一个长度为与字符串 p 的长度相同的滑动窗口，并在滑动中维护窗口中每种字母的数量；
 *      当窗口中每种字母的数量与字符串 p 中每种字母的数量相同时，则说明当前窗口为字符串 pp 的异位词
 *
 */
public class FindAllAnagrams {

    public List<Integer> findAnagrams(String s, String p) {
        int sLen = s.length(), pLen = p.length();

        if (sLen < pLen) {
            return new ArrayList<Integer>();
        }

        List<Integer> ans = new ArrayList<Integer>();
        int[] sCount = new int[26];
        int[] pCount = new int[26];
        for (int i = 0; i < pLen; ++i) {
            ++sCount[s.charAt(i) - 'a'];
            ++pCount[p.charAt(i) - 'a'];
        }

        if (Arrays.equals(sCount, pCount)) {
            ans.add(0);
        }

        for (int i = 0; i < sLen - pLen; ++i) {
            --sCount[s.charAt(i) - 'a'];
            ++sCount[s.charAt(i + pLen) - 'a'];

            if (Arrays.equals(sCount, pCount)) {
                ans.add(i + 1);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        new FindAllAnagrams().findAnagrams("cbaebabacd", "abc");
    }

}

