package com.sort.heap.priorityQueue;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 滑动窗口内最大值 - 大顶堆 （优先队列）
 * 链接：https://leetcode.cn/problems/sliding-window-maximum/
 * 问题：给定一个整数数组 nums，有一个大小为k 的滑动窗口从数组的最左侧移动到数组的最右侧。
 *      你只可以看到在滑动窗口内的 k个数字。 滑动窗口每次只向右移动一位。  返回 滑动窗口中的最大值 。
 * 分析：暴力解法 ： 窗口从 最左侧 一直右移 ， 对于每个滑动窗口，可用O（K）时间遍历，找到其中最大值。（由于每次移动只增加一个元素，减少一个元素。可进行优化）
 *      LGJ解法一：移动过程中维护一个窗口最大值的下标。若移动时划出下标，则遍历找最大值
 *      解法二 - 大顶堆（优先队列）：
 */
public class WindowMaximum {
    /**
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow1(int[] nums, int k) {
        if(k==1)    return nums;
        int[] res = new int[nums.length -k +1];
        int maxIdx = -1;
        int max = Integer.MAX_VALUE;
        for(int right = k-1 ; right < nums.length ; right++){
            int left = right-k+1;
            if(nums[right] >= max){  // 新加的值 更大
                maxIdx = right;
                max = nums[maxIdx];
                res[left] = max;
            }else{  // 若新加 的值更小
                if(maxIdx >= left){   //最大值还在，则不变
                    res[left] = max;
                }else{   //最大值被移除，需要重新 遍历窗口
                    max = Integer.MIN_VALUE;
                    for(int i = left ; i <= right ;i++){
                        if(nums[i] >= max){
                            max = nums[i];
                            maxIdx = i;
                        }
                    }
                    res[left] = max;
                }
            }
        }
        return res;
    }

    /**
     * 使用优先队列
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow2(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
            public int compare(int[] pair1, int[] pair2) {
                return pair1[0] != pair2[0] ? pair2[0] - pair1[0] : pair2[1] - pair1[1];
            }
        });
        for (int i = 0; i < k; ++i) {
            pq.offer(new int[]{nums[i], i});
        }
        int[] ans = new int[n - k + 1];
        ans[0] = pq.peek()[0];
        for (int i = k; i < n; ++i) {
            pq.offer(new int[]{nums[i], i});
            while (pq.peek()[1] <= i - k) { // 保证最大值的下标在窗口内
                pq.poll();
            }
            ans[i - k + 1] = pq.peek()[0];
        }
        return ans;
    }


}
