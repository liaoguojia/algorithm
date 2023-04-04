package com.sort;

/**
 * 合并两个有序数组
 * 链接：https://leetcode.cn/leetbook/read/top-interview-questions-easy/xnumcr/
 * 问题：给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
 *      将 nums2 合并到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
 *      合并后数组不应由函数返回，而是存储在数组 nums1 中。
 *      为了应对这种情况，nums1 的初始长度为 m + n，其中前 m 个元素表示应合并的元素，后 n 个元素为 0
 *
 * 分析： 有序数组合并需要 在各自遍历的同时比较大小，时间复杂度o(m+n)
 *      方法一 - 归并：为了不使用额外空间，可以 从大到小归并，在nums1中从后往前放入元素即可
 */
public class Merge2SortedArrays {

    /**
     * 归并
     * @param nums1   长度为m+n
     * @param m
     * @param nums2    长度为n
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums2.length == 0) return;
        int idx1 = m - 1, idx2 = n - 1;
        while (idx1 >= 0 && idx2 >= 0) {
            if (nums1[idx1] > nums2[idx2]) {
                nums1[idx1 + idx2 + 1] = nums1[idx1--];
            } else {
                nums1[idx1 + idx2 + 1] = nums2[idx2--];
            }
        }
        if (idx1 < 0) {
            for (int i = 0; i <= idx2; i++) nums1[i] = nums2[i];
        }
    }
}
