package com.stack.monotonicStack;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 直方图中的最大矩形 - 单调栈
 *
 * 链接：https://leetcode.cn/problems/largest-rectangle-in-histogram/
 *
 * 问题：给定 n 个非负整数，用来表示柱状图中 各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。求在该柱状图中，能够勾勒出来的矩形的最大面积
 *
 * 分析：暴力枚举： 都是O(N^2)
 *          枚举所有可能的宽：固定左起点0到n-1，遍历 可能的终点。遍历过程中维护 最低的高度
 *          枚举所有可能的高（nums[0] -> nums[n-1]）：分别往左右两边找起点，终点（低于本高的位置）
 *
 *      方法一 - 单调栈：枚举高 在向两边扩展找不高于本高度的位置时，使用单调栈存放数组中不大于某个值的位置
 */
public class LargestRectanle {
    /**
     *
     * @param heights
     * @return
     */
    public int largestRectangleArea(int[] heights) {
        Deque<Integer> stack = new LinkedList<>();
        int[] width = new int[heights.length];

        int res = 0;
        for(int i = 0 ; i < heights.length ;i++){
            if(stack.isEmpty()){
                width[i] = 0;
                stack.offerFirst(i);
            }else{
                // 若左边的位置 更高，则 出栈找到更低的位置
                if(heights[stack.peekFirst()] >= heights[i]){
                    // 找到左边 低于本高度的位置
                    while(!stack.isEmpty()){
                        if(heights[stack.peekFirst()] < heights[i]){
                            break;
                        }else{ // 若左边left 的高度高于 i的高度，那么 heights[left]的右终点也找到了
                            int left = stack.pollFirst();
                            res = Math.max((i-width[left])*heights[left],res);
                        }
                    }
                }
                width[i] = stack.isEmpty()?0:stack.peekFirst()+1;
                stack.offerFirst(i);
            }
        }
        // 对于没有找到 右终点 的idx，说明其右边没有 更低的了。
        while (!stack.isEmpty()){
            int idx = stack.pollFirst();
            res = Math.max(res,(heights.length - width[idx])*heights[idx]);
        }
        System.out.println(Arrays.toString(width));
        return res;
    }

    public static void main(String[] args) {
        int res = new LargestRectanle().largestRectangleArea(new int[]{2,1,5,6,2,3});
        System.out.println(res);
    }
}
