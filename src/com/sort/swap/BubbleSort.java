package com.sort.swap;

import java.util.Arrays;

/**
 * 冒泡排序 - 属于交换排序
 *  每轮从第一个元素开始，与下一个元素比较，更大的换到后面。 每轮可以选出一个最大的，放在最后（最后一个元素的idx = length-轮数）
 *  稳定
 *
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] nums = {0,5,2,4};
        bubbleSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void bubbleSort(int[] nums){
        for(int i = 0 ; i < nums.length-1 ;i++){
            // 每一轮从第一个开始，冒泡，将较大的移到后面，移到最后一个是最大的
            for(int j = 0 ; j < nums.length-1-i ;j++){
                if(nums[j]>nums[j+1]){
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                }
            }
        }
    }
}
