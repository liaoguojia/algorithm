package com.sort.swap;

import java.util.Arrays;

/**
 * 快速排序 - 属于交换排序
 * 思想：分治法
 * 1．先从数组中取出一个数作为基准数。
 * 2．分区过程：将比这个数大的数全放到它的右边，小于或等于它的数全放到它的左边。
 *      ( 分区过程有不同的具体实现方法，最终都要保证pivot左边的数 <= pivot，右边的数 >= pivot)
 * 3．再对左右区间重复第二步，直到各区间只有一个数。
 */
public class QuickSort {

    /**
     * 左右指针法：两边一起遍历
     * 1、选出一个key，一般是最左边或是最右边的。
     * 2、定义一个begin和一个end，begin从左向右走，end从右向左走。（需要注意的是：若选择最左边的数据作为key，则需要end先走；若选择最右边的数据作为key，则需要bengin先走）。
     * 3、在走的过程中，若end遇到小于key的数，则停下，begin开始走，直到begin遇到一个大于key的数时，将begin和right的内容交换，end再次开始走，如此进行下去，直到begin和end最终相遇，此时将相遇点的内容与key交换即可。（选取最左边的值作为key）
     * 4.此时key的左边都是小于key的数，key的右边都是大于key的数
     * 5.将key的左序列和右序列再次进行这种单趟排序，如此反复操作下去，直到左右序列只有一个数据，或是左右序列不存在时，便停止操作，此时此部分已有序
     * @param nums
     * @param l
     * @param r
     */
    public static void quickSort(int[] nums,int l,int r){
        // 只有一个数 或 区间不存在时，退出递归
        if(l>=r)    return;

        int i = l, j = r;
        int pivot = l;  //取 最左边nums[l] 为 分界值
        while(i < j){
            // 从右向左找到 小于pivot的值
            while(i < j && nums[j] >= nums[pivot]){
                j--;
            }
            // 从左向右找到 大于pivot的值
            while(i < j && nums[i] <= nums[pivot]){
                i++;
            }
            // 将 大数i，与 小数j 互换
            swap(nums,i,j);
        }
        // i,j相向移动。 到最后必有 i==j（此时需要交换pivot与i）
        // （若是j移到i，由于上一次交换将小数换到了前面，nums[i]<pivot；若是i移到j，则在i移动前，j已动过,nums[j]<pivot
        swap(nums,pivot,i);
        pivot = i;
        System.out.println("快排一次后： "+Arrays.toString(nums)+nums[pivot]);
        // 第pivot的位置已经确定好，对两边分别快排
        quickSort(nums,l,pivot-1);
        quickSort(nums,pivot+1,r);
    }

    /**
     * 单边遍历 ： 从前往后
     * @param nums
     * @param l
     * @param r
     */
    public static void quickSort2(int[] nums,int l,int r){

    }

    /**
     * 挖坑法 ：
     * @param nums
     * @param l
     * @param r
     */
    public static void quickSort3(int[] nums,int l,int r){
        if(l >= r)  return;
        int i = l, j = r;
        int pivot = nums[l]; //取最左数为划分
        while(i < j){
            // 从右往左，找到小于pivot的数
            while (i < j && nums[j]>=pivot){
                j--;
            }
            nums[i] = nums[j]; // 将坑移到右边j处
            // 从左往右，找到大于pivot的数
            while(i < j && nums[i] <= pivot){
                i++;
            }
            nums[j] = nums[i]; // 将右边的坑填充，左边的i成为坑
        }
        nums[i] = pivot;
        quickSort3(nums,l,i-1);
        quickSort3(nums,i+1,r);
    }

    /**
     * 在数组中交换两个下标对应的值
     * @param nums
     * @param i
     * @param j
     */
    public static void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,5,4,2,3,6,7,8,9,10,0};
//        quickSort(nums,0,nums.length-1);
        quickSort3(nums,0,nums.length-1);
        System.out.println(Arrays.toString(nums));
    }
}
