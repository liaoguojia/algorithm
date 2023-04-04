package com.binarySearch;


/**
 * 计算x的n次幂 -
 * 链接：https://leetcode.cn/problems/powx-n/
 * 问题：实现 pow(x, n) ，即计算 x 的整数 n 次幂函数（即，xn ）。
 * 分析： 若 循环 乘以n次x，会超时。可以二分加速，
 */
public class Pow_x_n {

    /**
     * 计算x 的n次幂
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x, int n) {
        long N = n;
        return N >= 0 ? quickMul(x, N) : 1.0 / quickMul(x, -N);
    }

    public double quickMul(double x, long N) {
        if (N == 0) {
            return 1.0;
        }
        double y = quickMul(x, N / 2);
        return N % 2 == 0 ? y*y : y*y*x;  //若n为奇数，还需要乘x
    }

    public static void main(String[] args) {
        new Pow_x_n().myPow(2,10);
    }

}
