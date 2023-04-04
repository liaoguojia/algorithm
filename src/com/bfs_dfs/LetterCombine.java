package com.bfs_dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * 回溯 - 电话号码的数字组合
 * 链接：https://leetcode.cn/problems/letter-combinations-of-a-phone-number/
 * 问题：给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合
 *      {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"} 每个电话号码对应的字母
 * 分析：
 *      方法一 - BFS： 类似二叉树的层序遍历，可以使用 递归/迭代解决。
 *      方法二 - DFS：
 */
public class LetterCombine {

    static List<String> res = new ArrayList<>();
    static String[] map = new String[]{"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

    /**
     * 方法一 - BFS ： 层序遍历，递归
     * @param digits
     * @return
     */
    public static List<String> letterCombinations1(String digits) {
        if(digits.length()==0){
            return res;
        }else{
            String s = map[digits.charAt(0)-'0'];
            int n = res.size();
            if(n==0){ // 可以 先在res中添加 ""空串代替
                for(int j = 0 ; j < s.length() ;j++)    res.add(s.substring(j,j+1));
            }
            for(int i = 0 ; i < n ;i++){
                for(int j = 0 ; j < s.length() ; j++){
                    res.add(res.get(0)+s.substring(j,j+1));
                }
                res.remove(0);
            }
            return letterCombinations1(digits.substring(1));
        }
    }

    /**
     * 方法一 - BFS ： 层序遍历 ， 迭代
     * @param digits
     * @return
     */
    public static List<String> letterCombinations2(String digits){
        res.add("");
        for (int idx = 0 ; idx < digits.length() ;idx++){
            String s = map[digits.charAt(idx)-'0']; // 该数字对应的几个字母
            int n = res.size();
            for(int i = 0 ; i < n ;i++){
                for (char c : s.toCharArray()){
                    res.add(res.get(i)+c);
                }
            }
            // 删除 原来 的  前面n个
            for (int i = 0 ; i < n ;i++)    res.remove(0);
        }
        return res;
    }
    public static void main(String[] args) {
        letterCombinations2("23");
        System.out.println(res);
    }
}
