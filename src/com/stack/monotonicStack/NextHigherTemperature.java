package com.stack.monotonicStack;
import java.util.*;

/**
 * 每日温度 - 单调栈
 * 链接：https://leetcode.cn/problems/daily-temperatures/
 * 问题：给定一个整数数组temperatures，表示每天的温度， 返回一个数组answer，其中answer[i]是指对于第 i 天，下一个更高温度出现在几天后。
 *      如果气温在这之后都不会升高，请在该位置用0 来代替
 * 分析：
 *      方法一：单调栈，栈中存放还没有找到下一个更高温度的下标，因此从栈底到栈顶 递减。
 *              遍历每日温度时，若 该温<=栈顶，入栈 ； 否则出栈直至 栈空 / 温度<=栈顶
 */
public class NextHigherTemperature {

    /**
     * @param temperatures  表示每天的温度 {73,74,75,71,69,72,76,73}
     * @return  返回一个数组 answer ，其中 answer[i] 是指对于第 i 天，下一个更高温度出现在几天后。
     *          如果气温在这之后都不会升高，请在该位置用 0 来代替
     */
    public static int[] dailyTemperatures(int[] temperatures) {
        // 栈中存放 还没有找到 下一个更高温度 的下标，因此从栈底至栈顶 是递减的
        Deque<Integer> stack = new LinkedList<>();
        int[] res = new int[temperatures.length];
        for(int i = 0 ; i < temperatures.length ; i++){
            int temperature = temperatures[i];
            // 若栈非空，且栈顶 温度 小于当前温度 ，则 将温度更低的下标出栈，其下一个更高温度 即当前
            while(!stack.isEmpty() && temperatures[stack.peekFirst()]<temperature){
                int idx = stack.pollFirst();
                res[idx] = i - idx;
            }
            stack.offerFirst(i); //若栈为空/或栈里温度都更高，则入栈
        }
        return res;
    }

    public static void main(String[] args) {
        int[] temperatures = new int[]{73,74,75,71,69,72,76,73};
        int[] res = dailyTemperatures(temperatures);
        System.out.println(Arrays.toString(res));
    }
}
