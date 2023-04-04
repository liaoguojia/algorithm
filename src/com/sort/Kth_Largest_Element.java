package com.sort;


import java.util.Arrays;

/**
 * 快速排序 - 找数组中排序后第k个元素
 * 链接：https://leetcode.cn/problems/kth-largest-element-in-an-array
 * 问题： 需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。 也就是Arrays.sort(nums,降序)后的nums[k-1]
 * 分析：
 *      基于快排 - 一次快排能找出一个pivot的正确位置：
 *              快排每次 选一个 pivot，将>=pivot的换到左边，<=pivot的换到右边，一次快排后pivot的下标为idx，即nums中第idx个元素必定为pivot
 *              每次快排返回pivot的下标，若下标>k，则对pivot左边继续快排；若<k，则对右边快排
 *      基于堆排序：
 */
public class Kth_Largest_Element {

    /**
     * 要求时间复杂度 O(n)
     * @param nums  数组
     * @param k
     * @return 数组从大到小排序后的第 k 个元素，
     */
    public int findKthLargest(int[] nums, int k) {
        int l = 0 , r = nums.length-1;
        int idx = 0;
        while((idx = quickSort(nums,l,r))!=k-1){
            System.out.println(Arrays.toString(nums)+" "+nums[idx]+"l="+l+"r="+r);
            if(idx < k-1){
                l = idx+1;
            }else{
                r = idx-1;
            }
        }
        System.out.println(Arrays.toString(nums)+" "+nums[idx]+"l="+l+"r="+r);
        return nums[idx];
    }

    /**
     * 使用左右指针进行快排，最后的i==j就是pivot的位置
     * @param nums
     * @param l
     * @param r
     * @return
     */
    public int quickSort(int[] nums, int l,int r){
        int idx = middleInThree(nums,l,r,l+(r-l)/2);
        swap(nums,idx,l);
        idx = l;
        int i = l, j = r;
        while(i < j){
            // 从右向左，找到大于pivot的数
            while(i < j && nums[idx] >= nums[j]){
                j--;
            }
            // 从左向右，找到小于pivot的数
            while(i < j && nums[idx] <= nums[i]){
                i++;
            }
            // 将两个数交换位置
            swap(nums,i,j);
        }
        swap(nums,i,idx);
        return i;
    }

    /**
     * 三数取中
     * @param nums
     * @param idx1
     * @param idx2
     * @param idx3
     * @return
     */
    public int middleInThree(int[] nums,int idx1,int idx2,int idx3){
        if(nums[idx1]>nums[idx2]){
            if(nums[idx3]>nums[idx1]) return idx1;
            else{
                if(nums[idx2]>nums[idx3])   return idx2;
                else    return idx3;
            }
        }else{
            if(nums[idx3]>nums[idx2])   return idx2;
            else{
                if(nums[idx3]>nums[idx1])   return idx3;
                else    return idx1;
            }
        }
    }

    public void swap(int[] nums, int idx1, int idx2){
        int temp = nums[idx1];
        nums[idx1] = nums[idx2];
        nums[idx2] = temp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,5,4,2,3,6,7,8,9,10,0};
        int k = new Kth_Largest_Element().findKthLargest(nums,3);
        System.out.println(Arrays.toString(nums));
        System.out.println(k);
    }

}
