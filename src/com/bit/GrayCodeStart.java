package com.bit;
import java.util.*;

/**
 * 循环码 - ^位运算
 * 链接：https://leetcode.cn/problems/circular-permutation-in-binary-representation/
 * 问题：给你两个整数n 和 start。你的任务是返回任意 (0,1,2,,...,2^n-1) 的排列 p，并且满足：
 *      p[0] = start
 *      p[i] 和 p[i+1]的二进制表示形式只有一位不同
 *      p[0] 和 p[2^n -1]的二进制表示形式也只有一位不同
 * 分析：若已生成n位格雷码（0-2^n），将所有格雷码异或上同一个值x，相邻数的二进制位依然只有一位不同：
 *      这是因为异或x后也是{0,1,2,...,(1<<n)-1}的一个排列，互不相同；且相邻格雷码只有一位不同，异或任意值x后，相同的位还是相同，不同的位一定是一个0和一个1，异或x后还是一个1一个0，只有一位不同
 *
 *
 */
public class GrayCodeStart {
    /**
     * 公式法生成格雷码，同时将每一位亦或
     * @param n
     * @param start
     * @return
     */
    public List<Integer> circularPermutation(int n, int start) {
        List<Integer> ret = new ArrayList<Integer>();
        for (int i = 0; i < 1 << n; i++) {
            ret.add((i >> 1) ^ i ^ start);
        }
        return ret;
    }

}
