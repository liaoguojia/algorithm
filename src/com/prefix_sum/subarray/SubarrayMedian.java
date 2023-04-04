package com.prefix_sum.subarray;

import java.util.HashMap;
import java.util.Map;

/**
 * 统计中位数为K的子数组个数
 * 链接：https://leetcode.cn/problems/count-subarrays-with-median-k/
 * 问题：
 * 分析： 要找的条件是 子数组内 大于k的个数 - 小于k的个数 = 0/1 的子数组 的 个数
 *       因此 前缀和 preSum = 大于k的个数 - 小于k的个数
 */
public class SubarrayMedian {

    public int countSubarrays(int[] nums, int k) {
        int Kidx = -1;
        int res = 0;

        for(int i = 0 ; i < nums.length ;i++){
            if(nums[i] == k)    Kidx=i;
        }
        if(Kidx == -1)   return res;

        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);

        int preSum = 0;
        for(int i = 0 ; i < nums.length ;i++){
            // 计算前缀和
            preSum = i==Kidx?preSum:(nums[i]>k?preSum+1:preSum-1);
            if(i >= Kidx){
                res += map.getOrDefault(preSum,0)+map.getOrDefault(preSum-1,0);
            }else{
                map.put(preSum,map.getOrDefault(preSum,0)+1);
            }
        }

        return res;
    }
}
