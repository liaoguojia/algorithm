package com.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和
 * 链接：https://leetcode.cn/problems/two-sum/
 * 问题：给定一个整数数组 nums和一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那两个整数，并返回它们的数组下标。
 *      你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * 分析：
 *      方法一 - 暴力枚举：对于从头开始的每一个元素i，都找其他位置是否存在target-i。时间n^2
 *      方法二 - 哈希表：在数组中找target-i时，时间复杂度为O(N)，可以使用哈希表存放元素，空间换时间。
 */
public class TwoSum {
    /**
     * 暴力枚举
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum1(int[] nums, int target) {
        // 从头遍历每一个元素
        for (int i = 0 ; i < nums.length ; i++){
            // 只需要从它后面找，如果在前面的话，之前i在找后面元素就已经找出来了
            for (int j = i+1 ; j < nums.length ;j++){
                if (nums[i]+nums[j] == target)  return new int[]{i,j};
            }
        }
        return new int[2];
    }

    /**
     * 使用哈希表存放元素，加快查找。写法可以优化
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum2(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0 ; i < nums.length ;i++){
            map.put(nums[i],i);   // 存放元素 及其下标
        }
        // 从头遍历每一个元素
        for (int i = 0 ; i < nums.length ; i++){
            if (map.containsKey(target-nums[i]) && map.get(target-nums[i])!=i){   // 不能是同一个元素使用两次
                return new int[]{i,map.get(target-nums[i])};
            }
        }
        return new int[2];
    }
}
