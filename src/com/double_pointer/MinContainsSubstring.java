package com.double_pointer;

/**
 * 最小覆盖字串 - 双指针（滑动窗口）
 * 链接：https://leetcode.cn/problems/minimum-window-substring/
 * 问题：给定字符串s与字符串t。 返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 *      对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
 * 分析：双指针：
 *      在 s 上滑动窗口，通过移动 r 指针不断扩张窗口。当窗口包含 t 全部所需的字符后，如果能收缩，就通过右移l指针 收缩窗口 直到得到最小窗口
 */
public class MinContainsSubstring {
    /**
     *
     * @param s   要查找的字符串
     * @param t   被涵盖的字符串
     * @return
     */
    public String minWindow(String s, String t) {
        int[] countT = new int['z'-'A'+1];
        // 统计t中字符
        for(int i = 0 ; i < t.length() ;i++)    countT[t.charAt(i)-'A']++;

        int[] countS = new int['z'-'A'+1];
        int minLen = Integer.MAX_VALUE;
        int start = 0;
        int left = 0,right = 0;
        while(right < s.length()){
            countS[s.charAt(right)-'A']++;
            int n = 0;
            while( left<=right && (n = s_t(countS,countT)) >= 0){
                while(!t.contains(s.substring(left,left+1))){
                    countS[s.charAt(left)-'A']--;
                    left++;
                }
                if(right-left+1<minLen){
                    minLen = right-left+1;
                    start = left;
                    // System.out.println(start+" "+n+s.substring(start,start+minLen));
                }
                countS[s.charAt(left)-'A']--;
                left++;

            }
            right++;
        }
        return minLen==Integer.MAX_VALUE?"":s.substring(start,start+minLen);
    }

    public static int s_t(int[] countS,int[] countT){
        int res = 0;
        for(int i = 0 ; i < countT.length ;i++){
            if(countT[i] > 0){
                if(countT[i] > countS[i])   return -1;
                else    res += countS[i]-countT[i];
            }
        }
        return res;
    }
}
