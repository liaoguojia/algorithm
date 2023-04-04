package com.string.palindrome;

/**
 * 分割两个字符串得到回文串 - 双指针+中心扩展
 * 链接：https://leetcode.cn/problems/split-two-strings-to-make-palindrome/
 * 问题：字符串a，b长度相同，判断a/b的prefix  +  b/a的suffix 能否组成 回文串
 * 分析：
 *      双指针 - ：idxa从头遍历a，idxb从尾遍历b，一直移动到 两指针的字符 不相同的位置
 *      中心扩展判断回文串 ： 对于两指针中间的部分，对a,b分别使用中心扩展判断
 *
 */
public class MakePalindrome {
    /**
     *
     * @param a
     * @param b
     * @return
     */
    public boolean checkPalindromeFormation(String a, String b) {
        return preAsufBPalindrome(a,b)|preAsufBPalindrome(b,a);
    }

    /**
     * a的前缀 + b的后缀 能否组成回文串
     * @param a
     * @param b
     * @return
     */
    public static boolean preAsufBPalindrome(String a, String b){
        int idxa = 0,idxb = b.length()-1;
        while(idxa < idxb){
            if(a.charAt(idxa) == b.charAt(idxb)){
                idxa++;
                idxb--;
            }else{
                break;
            }
        }
        if(idxa >= idxb)    return true;
        return isPalindrome(a.substring(idxa,idxb+1)) || isPalindrome(b.substring(idxa,idxb+1));
    }

    /**
     * 判断一个字符串是否是回文串
     * @param a
     * @return
     */
    public static boolean isPalindrome(String a){
        for(int i = 0 ; i < a.length()/2 ; i++){
            if(a.charAt(i) != a.charAt(a.length()-i-1)) return false;
        }
        return true;
    }
}
