package com.dp.dfs;
import jdk.nashorn.internal.runtime.regexp.joni.ast.StringNode;

import java.util.*;

/**
 * 单词拆分 - 记忆化搜索
 * 链接：https://leetcode.cn/problems/word-break
 * 问题：给定一个非空字符串 s 和一个包含非空单词的列表 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词
 * 分析：
 *      暴力递归（回溯）：遍历s的字符，当字典中存在单词后，递归判断生下来的字符串。由于递归传入的s.substring生成的新字符串对象，不会影响s，回溯后不需要复原。
 *              由于使用大量重复的递归，会超时。因此可以记忆化搜索，
 *      记忆化搜索：记忆之前递归过程中返回false的情况，后续递归若还遇到该情况就提前结束
 *              由于递归时从前往后，因此需要status[i]记录 i到末尾的字符串是否可以拆分，若false，直接结束本次递归
 *      动态规划：dp[i]表示i位之前的字符串是否可以被拆分，因此dp[0] = true表示空串是可以被拆分成功。
 *              递推公式：dp[i] = ( dp[j] && check(s.substring(j,i)) )
 *
 */
public class WordBreak {

    /**
     * 暴力回溯
     * @param s
     * @param set
     * @return
     */
    public boolean backtrack(String s, Set<String> set) {
        if (s.length() == 0) return true;
        for (int i = 0; i < s.length(); i++) {  // 遍历s
            if (set.contains(s.substring(0, i + 1))){   // 若字典包含s的前缀，则递归s的后面子串
                if (backtrack(s.substring(i + 1), set)) return true;
            }
        }
        return false;
    }
    public boolean wordBreak1(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        return backtrack(s, set);
    }

    /**
     * 记忆化回溯
     * @param s
     * @param idx   每次开始判断的起始下标
     * @param set
     * @param status    后面的字符串是否可以拆分成功。
     * @return
     */
    public boolean dfs(String s,int idx,Set<String> set,boolean[] status){
        if(idx == s.length()) return true;
        for(int i = idx ; i < s.length() ;i++){
            if(set.contains(s.substring(idx,i+1)) ){
                if(!status[i+1])  continue; // 若i+1之后的字符串不能拆分，则不向后递归
                // 若递归 成功，直接返回并设置该idx的状态
                if(dfs(s,i+1,set,status)){
                    status[idx] = true;
                    return true;
                }
            }
        }
        // 若该idx后面所有可能拆分的情况都不能成功，则状态为false
        status[idx] = false;
        return false;
    }
    public boolean wordBreak2(String s,List<String> wordDict){
        boolean[] status = new boolean[s.length()+1];
        for (int i = 0; i < status.length; i++) {
            status[i] = true;
        }
        return dfs(s,0,new HashSet<>(wordDict),status);
    }

    /**
     * 方法三 ： 动态规划
     * @param s
     * @param wordDict
     * @return
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[1+s.length()];
        dp[0] = true;  // 空串可以拆分
        for(int i = 0 ;i < s.length() ;i++){
            dp[i+1] = false;
            for(int j = i ; j >= Math.max(0,i-20) ;j-- ){  // 遍历前面的状态
                if(dp[j]){
                    String word = s.substring(j,i+1);  // 子串 [j-i]在字典中
                    if(wordDict.contains(word)){
                        dp[i+1] = true;
                    }
                }
            }
        }
        // System.out.println(Arrays.toString(dp));
        return dp[s.length()];
    }


}
