package com.bit;
import java.util.*;

/**
 * 格雷编码 - 位运算
 * 链接：https://leetcode.cn/problems/gray-code
 * 问题：n 位格雷码序列 是一个由 2n 个整数组成的序列，其中：
 *      每个整数都在范围 [0, 2n - 1] 内（含 0 和 2n - 1）
 *      第一个整数是 0
 *      一个整数在序列中出现 不超过一次
 *      每对 相邻 整数的二进制表示 恰好一位不同 ，且
 *      第一个 和 最后一个 整数的二进制表示 恰好一位不同
 *      给你一个整数 n ，返回任一有效的 n 位格雷码序列 。
 *
 * 分析：
 *      方法一 - 镜像反射/对称法：
 *      方法二 - 公式法：Gi = i ^ (i/2)
 *
 */
public class GrayCode {
    /**
     * 方法一 - 对称编码：
     * @param n
     * @return
     */
    public List<Integer> grayCode1(int n) {
        List<Integer> res = new ArrayList<>();
        res.add(0);
        int head = 1;
        for (int i = 0; i < n; i++) {
            int len = res.size();
            for (int j = len-1; j >= 0 ; j--) {
                res.add(head+res.get(j));
            }
            head = (head<<1);
        }
        return  res;
    }

    public List<Integer> grayCode2(int n) {
        List<Integer> ret = new ArrayList<Integer>();
        for (int i = 0; i < 1 << n; i++) {
            ret.add((i >> 1) ^ i);
        }
        return ret;

    }
}
