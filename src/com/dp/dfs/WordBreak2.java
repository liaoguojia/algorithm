package com.dp.dfs;
import  java.util.*;

/**
 * 单词拆分1 -
 * 链接：https://leetcode.cn/problems/word-break-ii/
 * 问题：给定一个字符串 s 和一个字符串字典wordDict，在字符串s中增加空格来构建一个句子，使得句子中所有的单词都在词典中。以任意顺序 返回所有这些可能的句子
 * 分析： 不仅要判断，还要在判断的过程中，保存符合条件的结果
 *      方法一 - 动态规划：使用list保存i之前的拆分结果，若list长度为0，表示无法拆分
 *      方法二 - 记忆化搜索：
 */
public class WordBreak2 {
    /**
     *
     * @param s
     * @param wordDict
     * @return
     */
    public List<String> wordBreak1(String s, List<String> wordDict) {
        List<List<String>> dp = new ArrayList<>();
        List<String> list = new ArrayList<>();
        list.add(" ");
        dp.add(list);  // 空字符串满足条件
        for(int i = 0 ; i < s.length() ;i++){
            List<String> listi = new ArrayList<>();
            for(int j = i ; j >= Math.max(0,i-10) ;j--){
                if(dp.get(j).size()>0 && wordDict.contains(s.substring(j,i+1))){ // 若当前子串j-i在字典中，且 j之前能拆分
                    for(String pre : dp.get(j)){
                        listi.add(pre+s.substring(j,i+1)+" ");
                    }
                }
            }
            dp.add(listi);
        }
        list = dp.get(dp.size()-1);
        for(int i = 0 ; i < list.size() ;i++){
            list.set(i,list.get(i).trim()); // 去除前后的" "
        }
        // System.out.println(dp);
        return list;
    }
}
