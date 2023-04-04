package com.sort;

import java.util.Arrays;

/**
 * 归并排序
 *
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] nums = new int[]{2,5,8,1,5,6,9,0};
//        mergeSort(nums,0,nums.length-1);
        nums = mergeSort(Arrays.copyOfRange(nums,0,nums.length/2),Arrays.copyOfRange(nums,nums.length/2,nums.length));
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 对一个数组的 左右 两个部分进行 归并
     * @param nums
     * @param left
     * @param right
     */
    public static void mergeSort(int[] nums,int left,int right){
        if (left==right)    return;
        int mid = left+ ((right-left)/2);

        mergeSort(nums,left,mid);  // [left,mid]
        mergeSort(nums,mid+1,right);  //[mid+1,right

        int idx = left;
        int[] temp = Arrays.copyOfRange(nums, left, right+1);
        int ileft = 0,iright = mid-left+1;
        while (idx <= right){
            if( iright == temp.length ){
                nums[idx++]=temp[ileft++];
                continue;
            }
            if (ileft == mid-left+1)   {
                nums[idx++] = temp[iright++];
                continue;
            }
            nums[idx++] = temp[iright]<temp[ileft]?temp[iright++]:temp[ileft++];
        }
    }

    /**
     * 将两个数组 归并 为一个数组
     * @param left
     * @param right
     * @return
     */
    public static int[] mergeSort(int[] left,int[] right){
        if (left.length > 1)    left = mergeSort(Arrays.copyOfRange(left,0,left.length/2),Arrays.copyOfRange(left,left.length/2,left.length));
        if (right.length > 1)    right = mergeSort(Arrays.copyOfRange(right,0,right.length/2),Arrays.copyOfRange(right,right.length/2,right.length));

        int[] res = new int[left.length+right.length];
        int ileft = 0, iright = 0;
        for (int idx = 0 ; idx < res.length ;idx++){
            if (ileft == left.length){
                res[idx] = right[iright++];
                continue;
            }
            if (iright == right.length){
                res[idx] = left[ileft++];
                continue;
            }
            res[idx] = left[ileft]<right[iright]?left[ileft++]:right[iright++];
        }
        return res;
    }
}
