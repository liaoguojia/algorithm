package com.backtrack.parenthese;
import java.util.*;

/**
 * 删除无效括号 - 回溯+剪枝
 * 链接：https://leetcode.cn/problems/remove-invalid-parentheses/
 * 问题：给你一个由若干括号和字母组成的字符串 s ，删除最小数量的无效括号，使得输入的字符串有效。
 *      返回所有可能的结果。答案可以按 任意顺序 返回
 * 分析：
 *      方法一 - 枚举所有子序列
 *      方法二 - 回溯剪枝
 *
 */
public class RemoveInvalidParentheses {

    /**
     * 判断 括号字符串 有效的 好方法
     * @param str
     * @return
     */
    private boolean isValid(String str) {
        int cnt = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                cnt++;
            } else if (str.charAt(i) == ')') {
                cnt--;
                if (cnt < 0) {
                    return false;
                }
            }
        }
        return cnt == 0;
    }


    /**
     * 删除无效括号
     * @param s
     * @return
     */
    public List<String> removeInvalidParentheses(String s) {
        Set<String> res = new HashSet<>();
        backtrace(s,0,new StringBuilder(),0,res);
        int maxLen = 0;
        for (String i: res) {
            maxLen = Math.max(i.length(),maxLen);
        }
        List<String> res_list = new ArrayList<>();
        for(String i : res){
            if(i.length()==maxLen)  res_list.add(i);
        }
        return res_list;
    }

    /**
     *
     * @param s
     * @param idx
     * @param sb
     * @param right
     * @param res
     */
    public void backtrace(String s,int idx,StringBuilder sb,int right,Set<String> res){
        // 剪枝 ， 不用每个都回溯
        if(right > sb.length()-right)   return ;

        if(idx == s.length()){
            if(isValid(sb.toString()))  res.add(sb.toString());
            return;
        }
        if(s.charAt(idx) == ')'){
            backtrace(s,idx+1,sb,right,res);    // 删除当前的右括号
            backtrace(s,idx+1,sb.append(")"),right+1,res);   //不删除当前右括号
            sb.delete(sb.length()-1,sb.length());
        }else if(s.charAt(idx) == '('){
            backtrace(s,idx+1,sb,right,res);
            backtrace(s,idx+1,sb.append("("),right,res);
            sb.delete(sb.length()-1,sb.length());
        }else{
            backtrace(s,idx+1,sb.append(s.substring(idx,idx+1)),right,res);  //字母位置 不变
            sb.delete(sb.length()-1,sb.length());
        }
    }


    public static void main(String[] args) {
        List<String> strings = new RemoveInvalidParentheses().removeInvalidParentheses("(a)()(()");
        System.out.println(strings);
    }
}
