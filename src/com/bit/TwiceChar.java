package com.bit;

/**
 * 位运算
 *      左移位运算 <<
 *      与运算 &
 *      或运算 |
 */
public class TwiceChar {
    /**
     * 链接 ： https://leetcode.cn/problems/first-letter-to-appear-twice/
     * 给你一个由小写英文字母组成的字符串 s ，请你找出并返回第一个出现 两次 的字母。
     * @param s  :由小写英文字母组成的字符串 ,至少一个出现两次的字母
     * @return  "abccbaacz"则返回c
     */
    public static char repeatedCharacter(String s) {
        //除了用哈希表/数组存储 外，
        // 还可以使用 int数 来记录，共有32位，使用其中低26位记录是否已出现过
        int appears = 0;
        for(int i = 0 ; i < s.length() ;i++){
            int idx = s.charAt(i)-'a';
            if( (appears&(1<<idx)) != 0){   // 将 该位 与1进行 与运算，若为0表示未出现，为1表示出现过
                return s.charAt(i);
            }
            appears |= (1<<idx);   // 将该位 与 1进行 或运算，表示该位字母已出现
        }
        return ' ';
    }

    public static void main(String[] args) {
        System.out.println(repeatedCharacter("abccbaacz"));
    }
}
