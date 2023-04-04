package com.bit;

import java.util.Arrays;

/**
 * 从数组中找到重复的数 - 位运算
 * 链接：https://leetcode.cn/problems/find-the-duplicate-number/
 * 问题：给定一个包含 n + 1 个整数的数组 nums ，其数字都在[1, n]内，可知至少存在一个重复的整数。
 *      假设 nums 只有 一个重复的整数 ，返回这个重复的数 。
 * 分析：方法1 - 位运算： 统计 1-n 每个数的二进制形式 的每一位的1的个数之和 count1[]
 *          对数组nums也统计出 各位置1个数之和 count2[]， 若 count2 某位置的1的个数 比count1大 ，则多出的数x的该位置 必定为1
 *          若x出现3次及以上，则 原本多出1的位置 只会更大
 *      方法二 - 二分搜索：
 */
public class DuplicateNumber {
    /**
     *
     * @param nums  含有某个重复数字的数字
     * @return  返回 那个重复的 数字
     */
    public int findDuplicate(int[] nums) {
        int n = nums.length-1;  //最大的数
        int binaryLen = (int)(Math.log(n)/Math.log(2))+1;  //log_2(n)+1
        System.out.println(binaryLen);
        int[] count1 = new int[binaryLen];
        for (int i = 1; i <= n ; i++) {
            for(int j = 0 ; j < binaryLen ;j++){
                count1[j] = (i&(1<<j)) == 0 ? count1[j]:count1[j]+1;
            }
        }

        int[] count2 = new int[binaryLen];
        for (int i : nums) {
            for(int j = 0 ; j < binaryLen ;j++){
                count2[j] = (i&(1<<j)) == 0 ? count2[j]:count2[j]+1;
            }
        }
        System.out.println(Arrays.toString(count1) +" "+Arrays.toString(count2));

        int res = 0;
        for(int i = 0 ; i < binaryLen ;i++){
            if(count2[i]>count1[i]){
                res += 1<<i ;
            }
        }
        return res;

    }

    public static void main(String[] args) {
        int duplicate = new DuplicateNumber().findDuplicate(new int[]{1, 2, 3, 4, 2});
        System.out.println(duplicate);
    }

}
