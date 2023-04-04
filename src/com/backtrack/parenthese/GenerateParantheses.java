package com.backtrack.parenthese;
import java.util.*;

/**
 * 括号生成 - 回溯 剪枝
 * 链接：https://leetcode.cn/problems/generate-parentheses/
 * 问题：数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合字符串
 * 分析：字符串长为2*n，要返回所有有效的括号字符串
 *      方法一 - 暴力枚举： 遍历2*n长的二进制数（0至2^(2*n)-1），0表示 (，1表示 )，对每个字符串判断isValid
 *      方法二 - 回溯剪枝：
 */
public class GenerateParantheses {
    /**
     * 使用栈 判断 一个 括号字符串是否有效
     * @param s
     * @return
     */
    public boolean isValid(String s){
        Deque<Character> stack = new LinkedList<>();
        for(int i = 0 ; i < s.length() ;i++){
            if(s.charAt(i) == ')'){
                if(!stack.isEmpty())    stack.pollFirst();
                else    return false;
            }else{
                stack.offerFirst('(');
            }
        }
        return stack.isEmpty();
    }

    /**
     * 括号生成解法一 - 枚举 判断
     * @param n
     * @return
     */
    public List<String> generateParenthesis1(int n) {
        List<String> res = new ArrayList<>();
        for(int i = 0 ; i < (int)(Math.pow(2,n*2)) ;i++){
            StringBuilder sb = new StringBuilder();
            for(int j = 0 ; j < n*2 ;j++){
                if( (i&(1<<j)) == 0)    sb.append("(");
                else    sb.append(")");
            }
            if(isValid(sb.toString())){
                res.add(sb.toString());
            }
        }
        return res;
    }

    /**
     *
     * @param n
     * @return
     */
    public List<String> generateParenthesis2(int n) {
        List<String> res = new ArrayList<>();
        backtrace(n,new StringBuilder(),0,res);
        return res;

    }

    /**
     *
     * @param n   括号对数
     * @param sb   已组成的字符串
     * @param right    右括号数
     * @param res      存放有效括号串
     */
    public void backtrace(int n,StringBuilder sb,int right,List<String> res){
        // 两种剪枝
        if(right > sb.length()-right)   return ;  // 若右括号 数大于左，不可能有效
        if(sb.length()-right > n )  return ;  // 单边括号数 已大于n，不可能有效

        if(sb.length()==2*n){   // 长度达到
//            if(isValid(sb.toString())){  // 有效
//                res.add(sb.toString());
//                return ;
//            }else{   //最终的2n字符串无效
//                return ;
//            }
            res.add(sb.toString());  //不用判断有效，前面的每一步都能确保有效
        }else {    //长度不足
            backtrace(n, sb.append("("), right, res);
            // System.out.println(sb);
            sb.delete(sb.length()-1,sb.length());
            backtrace(n,sb.append(")"), right + 1, res);
            sb.delete(sb.length()-1,sb.length());
        }
    }

    public static void main(String[] args) {
        List<String> strings = new GenerateParantheses().generateParenthesis2(3);
        System.out.println(strings);
    }

}
