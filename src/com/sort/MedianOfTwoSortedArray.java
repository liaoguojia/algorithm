package com.sort;


/**
 * 两个有序数组的中位数 - 二分
 * 链接： https://leetcode.cn/problems/median-of-two-sorted-arrays/
 * 问题： 给定 两个 从小到大排序 的 数组 nums1 和 nums2，长度分别为m ,n 。 找出并返回这两个正序数组的 中位数
 * 分析：方法一：将两个有序数组一次遍历，归并为一个有序数组，然后求中位数
 *      方法二：在归并过程中 只需要找到中位数即可，不用合为一个数组，可省去 o(m+n)的空间   （判断是否为中位数）
 *      方法三：求中位数，其实就是求第 k 小数的一种特殊情况。
 *          一次遍历就相当于去掉不可能是中位数的一个值，也就是一个一个排除。由于数列是有序的，完全可以一半一半的排除
 */
public class MedianOfTwoSortedArray {

    /**
     * 使用归并排序的方法，将两数组 合为 一个有序数组，再求中位数 （时间O(m+n)，空间O(log(m+n))）
     * @param nums1   有序数组1
     * @param nums2   有序数组2
     * @return 返回两数组合并后的中位数
     */
    public double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        int[] nums = new int[nums1.length + nums2.length];
        int idx1 = 0 , idx2 = 0;
        while(idx1<=nums1.length-1 || idx2<=nums2.length-1){
            int val1 = idx1<=nums1.length-1?nums1[idx1]:Integer.MAX_VALUE;
            int val2 = idx2<=nums2.length-1?nums2[idx2]:Integer.MAX_VALUE;
            if(val1 == val2){
                nums[idx1+idx2] = val1;
                nums[idx1+idx2+1] = val2;
                idx1++;
                idx2++;
            }else if(val1 < val2){
                nums[idx2+idx1] = val1;
                idx1++;
            }else{
                nums[idx1+idx2] = val2;
                idx2++;
            }
        }
        return nums.length%2==0?(double)(nums[nums.length/2-1]+nums[nums.length/2])/2:(double)(nums[nums.length/2]);
    }

    /**
     * 遍历两数组过程中，判断 中位数，区分 奇偶 。 时间 o(m+n)，空间O(1)
     * @param nums1   有序数组1
     * @param nums2   有序数组2
     * @return 返回两数组合并后的中位数
     */
    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int idx1 = 0 , idx2 = 0;
        int right = (nums1.length+nums2.length)/2;  // 该数前 已遍历 left个数
        int left = right;  // 奇数时
        if((nums1.length+nums2.length)%2==0){   //偶数时，左中位数 前
            left -= 1;
        }
        double res = 0;
        while(idx1<=nums1.length-1 || idx2<=nums2.length-1){
            int val1 = idx1<=nums1.length-1?nums1[idx1]:Integer.MAX_VALUE;
            int val2 = idx2<=nums2.length-1?nums2[idx2]:Integer.MAX_VALUE;

            if(idx1+idx2 == left)    res += Math.min(val1,val2);
            if(idx2+idx1 == right)    res += Math.min(val1,val2);
            if(val1 <= val2){
                idx1++;
            }else{
                idx2++;
            }

        }
        System.out.println(left+" "+right);
        return (res)/2;
    }

    /**
     * 使用二分
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays3(int[] nums1, int[] nums2) {
        return 0;
    }
}
