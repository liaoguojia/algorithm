package com.bit.single_number;

import java.util.*;

/**
 * 只出现一次的数字 - 位运算
 * 链接：https://leetcode.cn/problems/single-number/
 * 问题：给你一个 非空 整数数组 nums ，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 *      要求线性时间复杂度，常量级额外空间
 * 分析：
 *      方法一 - 哈希表存储元素：
 *      方法二 - 位运算 ： 两数进行异或运算的三个性质
 *          a^a=0；自己和自己异或等于0
 *          a^0=a；任何数字和0异或还等于他自己
 *          a^b^c=a^c^b；异或运算具有交换律
 *          因此将 所有数 进行异或运算后，得到的就是出现一次的数字
 */
public class SingleNumber1 {
    /**
     * 方法一 ： 哈希表存放 元素
     * @param nums
     * @return
     */
    public int singleNumber1(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i : nums){
            if(!set.add(i)){   // 若元素已存在，返回false，添加失败
                set.remove(i);
            }
        }
        return (int)set.toArray()[0];  // 最终只剩 出现 一次的元素
    }

    /**
     * 方法二 - 位运算
     * @param nums
     * @return
     */
    public int singleNumber2(int nums[]) {
        int result = 0;
        for (int i = 0; i < nums.length; i++)
            result ^= nums[i];   // 异或运算
        return result;
    }

}
