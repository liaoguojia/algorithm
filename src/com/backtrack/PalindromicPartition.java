package com.backtrack;
import java.util.*;

/**
 * 分割回文子串 - 回溯剪枝（动规优化）
 * 链接：https://leetcode.cn/problems/palindrome-partitioning/
 * 问题：给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案
 * 分析： 由于需要求出字符串 s 的所有分割方案，因此考虑使用 搜索 + 回溯 的方法枚举所有可能的分割方法并进行判断。
 *      LGJ回溯剪枝 ：每个字符都可能被取为当前回文串的最后一个字符。
 *              若为当前子串 的最后一个字符，判断是回文串则继续， 不是回文串则剪枝。
 *              若不是当前子串 的最后一个字符，则 添加该字符，继续往后取。
 *              （停止条件：end已经超过s的长度，若上一个回文串末尾 在s的末尾则加入ans）
 *      官解 - 回溯+动规 ：使用dp数组预先存放每个子串是否回文串。
 *              遍历每个字符时，若能找到当前字符开头的回文串则继续，否则直接剪枝，不需要一个个字符添加进当前子串
 */
public class PalindromicPartition {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> list = new ArrayList<>();
        backtrace(s,0,1,list,res);
        // System.out.println(list+" res"+res);
        return res;
    }

    public void backtrace(String s,int start,int end,List<String> list,List<List<String>> res){
        // end到结尾了
        if(end==s.length()+1){
            if(start == s.length()){
                //  ！！！经常出错，要添加不同的list，而不是一堆相同的地址
                res.add(new ArrayList<>(list));
                // System.out.println(list+" res"+res);
            }
            return ;
        }
        // 若回文串 取当前字符为 end
        if(isPalindromic(s.substring(start,end))){ //该回文串 true
            list.add(s.substring(start,end));
            // System.out.println("list加入 字串"+list);
            backtrace(s,end,end+1,list,res);
            list.remove(list.size()-1);   // 注意顺序！！
            // System.out.println("list删除 字串"+list);
        }else{ //剪枝

        }

        // 回文串 包含当前字符
        backtrace(s,start,end+1,list,res);
    }

    public boolean isPalindromic(String s){
        int right = s.length()/2,  left = s.length()%2==0?right-1:right;
        while(left >= 0){
            if(s.charAt(left) != s.charAt(right)){
                // System.out.println(s+"不是回文串");
                return false;
            }
            left--;
            right++;
        }
        // System.out.println(s+"是回文串");
        return true;
    }

}
