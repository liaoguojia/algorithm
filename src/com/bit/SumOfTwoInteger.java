package com.bit;

/**
 * 两数求和 - 位运算
 * 链接：https://leetcode.cn/problems/sum-of-two-integers/
 * 问题：给定两整数a,b，求两数之和，不允许使用 + ，-运算符
 * 分析： 整数a与b之和， 可拆分为 a与b不考虑进位的和  与 进位结果  之和
 */
public class SumOfTwoInteger {
    public int getSum(int a, int b) {
        while (b != 0) {
            int carry = (a & b) << 1;
            a = a ^ b;
            b = carry;
        }
        return a;
    }
}
