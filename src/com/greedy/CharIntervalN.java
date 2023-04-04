package com.greedy;

import java.util.Arrays;

/**
 * 任务调度 - 贪心
 * 链接 ： https://leetcode.cn/problems/task-scheduler/
 * 问题：即要求 相同字母之间至少间隔n的位置，可以使用空字符填充。求最小长度
 * 分析： 统计所有字符的个数，并进行排序。找到出现次数最多的字符
 *      假设最多的 A出现3次，n = 2，至少形成AXX AXX A序列 （最小长度）
 *      后面也出现3次的，如b，则 ABXABXAB （最小长度+1）
 *          对于小于3次的，填入X空隙；      若X空隙足够使用，则返回 序列长度
 *          若X空隙不够，则在序列两字符之间中插入，能够实现 每个字符插入后至少间隔n ，最终的序列 没有X，直接返回所有字符数
 */
public class CharIntervalN {
    /**
     *
     * @param tasks   所有任务表示的字母
     * @param n   相同任务（字母）之间必须间隔的时间
     * @return   完成所有任务所需的最少时间 （构造字符串的最小长度）
     */
    public int leastInterval(char[] tasks, int n) {
        int[] counts = new int['Z' - 'A' + 1];
        for (char i : tasks) {
            counts[i - 'A']++;
        }
        Arrays.sort(counts);   //int是基本类型，不能传入comparator进行比较
        int min = (counts[counts.length - 1] - 1) * (n + 1);
        for (int i : counts) {
            if (i == counts[counts.length - 1]) {
                min++;
            }
        }
        return Math.max(min, tasks.length);
    }

    public static void main(String[] args) {
        int res = new CharIntervalN().leastInterval(new char[]{'A','A','A','B','B','C','C'},2);
    }
}
