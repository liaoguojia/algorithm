package com.prefix_sum.subarray;

/**
 * 移除子数组，使得余下元素和能被p整除
 * 链接：https://leetcode.cn/problems/make-sum-divisible-by-p/
 * 问题：给你一个正整数数组nums，请你移除 最短 子数组（可以为 空），使得剩余元素的 和能被 p整除。 不允许将整个数组都移除。
 *      请你返回你需要移除的最短子数组的长度，如果无法满足题目要求，返回 -1
 * 分析：
 *      方法一 - 枚举子数组：时间复杂度为N^2
 *      方法二 - 前缀和+哈希表： 参照子数组和
 *
 */
public class RemoveSubArray {
    /**
     * 方法一 - 遍历
     * @param nums
     * @param p
     * @return
     */
    public int minSubarray1(int[] nums, int p) {
        long sum = 0;
        for (int i : nums)  sum+=i;
        if (sum%p==0)   return 0;

        int res = nums.length;
        for (int right = 0 ; right < nums.length ; right++){
            int subsum = 0;
            // 以right结尾的所有子数组
            for (int left = right ; left >= 0 ;left--){
                subsum += nums[left];
                if ((sum-subsum)%p==0){  // 移除子数组后的元素和
                    res = Math.min(res,right-left+1);
                }
            }
        }
        return res==nums.length?-1:res;
    }

    /**
     *
     * @param nums
     * @param p
     * @return
     */
    public int minSubarray2(int[] nums, int p) {
        long sum = 0;
        int[] prefix = new int[nums.length+1];
        // 统计前缀和
        for (int i = 0 ; i < nums.length ;i++){
            nums[i] = nums[i]%p;
            sum += nums[i];
            prefix[i] = i==0?0:prefix[i-1]+nums[i-1];
        }
        if (sum%p==0)   return 0;

        int res = nums.length;
        for (int right = 0 ; right < nums.length+1 ; right++){
            // 要从prefix[0->right] 中找到 (sum-(prefix[right]-prefix[i]))%p==0，遍历的时间O(N^2)
            // 使用哈希表存放prefix[i]就可以使用空间换取时间，如何计算出prefix的值呢？
            // 如果sum%p=b，那么(prefix[right]-prefix[i])%p=b，等价于 (prefix[right]-b)%p=prefix[i]%p
            int right_residue = prefix[right]%p;

        }
        return res==nums.length?-1:res;
    }
}
