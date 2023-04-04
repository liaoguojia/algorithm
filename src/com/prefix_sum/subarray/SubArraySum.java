package com.prefix_sum.subarray;


import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/**
 * 和为k的子数组 - 前缀和
 * 链接 ： https://leetcode.cn/problems/subarray-sum-equals-k/
 * 问题 ： 统计整数数组nums中，和为k的子数组的个数
 * 分析 ： 考虑子数组 以下标 right 结尾，统计符合条件的 子数组 起始下标 left
 *      方法1：枚举（遍历子数组），对每一个结尾下标 right :0->nums.length-1， 起始下标left: i->0。 时间复杂度为O（N^2）
 *      方法2：前缀和 + 哈希表：只使用前缀和依然是O（N^2），哈希表能加快查询
 *          回顾两数之和，遍历end结尾的子串时，对于每一个prefix[end]，就是要在prefix[0->end]中找到一个元素，满足prefix[end]-prefix[i]=k，
 *          如果遍历0->end，就会是O(N)的查找效率，如果将所有prefix放入哈希表，就是在哈希表中找是否存在 prefix[end]-k 这个值
 *
 */
public class SubArraySum {
    /**
     * 方法一：枚举
     * @param nums 数组
     * @param k  和
     * @return
     */
    public int subarraySum1(int[] nums, int k) {
        int res = 0;
        for(int end = 0 ; end < nums.length ;end++){
            int sum = 0;
            for(int start = end ; start>=0 ;start--){
                sum += nums[start];
                if(sum==k)  res++;
            }
        }
        return res;
    }

    /**
     * 只使用前缀和 prefix[nums.length+1]，所有前缀和两两相减 就是所有字串和，依然是N^2
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum_(int[] nums, int k) {
        int res = 0;
        // 统计前缀和
        int[] prefix = new int[nums.length+1];
        for (int i = 0 ; i < nums.length+1 ;i++){
            prefix[i] = i > 0?prefix[i-1]+nums[i-1]:0;
        }
        // 所有 以end结尾的子串 和 就是 prefix[end]-prefix[0->end]
        for(int end = 1 ; end < nums.length+1 ;end++){
//            int sum = 0;
            for(int start = end-1 ; start>=0 ;start--){
//                sum += nums[start];
                if(prefix[end] - prefix[start] == k)  res++;
            }
        }
        return res;
    }

    /**
     * 前缀和 + 哈希表
     *
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum2(int[] nums, int k) {
        int res = 0;
        // 统计前缀和
        int[] prefix = new int[nums.length+1];
        for (int i = 0 ; i < nums.length+1 ;i++){
            prefix[i] = i > 0?prefix[i-1]+nums[i-1]:0;
        }

        // key应该存放前缀和的值，value
        Map<Integer,Integer> map = new HashMap<>();

        // 就是要从prefix[0->end-1]这些前缀中找 是否有 prefix[end]-k这个值
        for(int end = 0 ; end < nums.length+1 ;end++){
            if (map.containsKey(prefix[end] - k)){
                res+=map.get(prefix[end]-k);// 找到所有的满足条件的个数
            }
            map.put(prefix[end],map.getOrDefault(prefix[end],0)+1);   // 因为是从前面找，所以一次一次添加进去
        }
        return res;
    }

    public static void main(String[] args) {
        new SubArraySum().subarraySum2(new int[]{-1,-1,2,-2},0);
    }

}
