package com.sort.heap.priorityQueue;

import java.util.PriorityQueue;

/**
 *
 * 链接：https://leetcode.cn/problems/maximum-average-pass-ratio/
 * 问题：
 * 分析：
 *      方法一 - 暴力：由于每次用一个学生加入班级后，该班级的大小会变化。因此每次添加完后，都再找一次最大增量的那个班级 O(n^2)
 *      方法二 - 优先队列：每次都找到增量最大的班级都需要O(N)时间，使用增量作为比较器构建堆可换取时间
 *
 */
public class MaxAvgPassRatio {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        double res = 0;
        for(int i = 1 ; i <= extraStudents ; i++){
            // 每次加入一个学生，都要找到增量最大的那个班级
            int idx = 0;
            for(int j = 0 ; j < classes.length ;j++){
                if( (double)classes[j][0]/classes[j][1] >= 1 ){
                    continue;
                }
                if( (((double)classes[j][0]+1)/(classes[j][1]+1)-classes[j][0]/(double)classes[j][1]) > (((double)classes[idx][0]+1)/(classes[idx][1]+1)-(double)classes[idx][0]/classes[idx][1]) ){
                    idx = j;
                }
            }
            classes[idx][0]++;
            classes[idx][1]++;
        }
        for(int i = 0 ; i < classes.length ; i++){
            res += ((double)classes[i][0]/classes[i][1]);
        }
        return res/classes.length;
    }

    public double maxAverageRatio1(int[][] classes, int extraStudents) {
        double res = 0;
        // 指定优先队列的比较器：按照元素的+1增量降序 排列
        PriorityQueue<double[]> priorityQueue = new PriorityQueue<>((a,b)->Double.compare( ((b[0]+1)/(b[1]+1)-b[0]/b[1]) ,((a[0]+1)/(a[1]+1)-a[0]/a[1])));
        for(int[] c:classes){
            priorityQueue.offer(new double[]{c[0],c[1]});
        }
        for(int i = 0 ; i < extraStudents ;i++){
            double[] poll = priorityQueue.poll();
            poll[0]++;
            poll[1]++;
            priorityQueue.offer(poll);
        }
        while (!priorityQueue.isEmpty()){
            double[] poll = priorityQueue.poll();
            res += poll[0]/poll[1];
        }
        return res/classes.length;
    }

    public static void main(String[] args) {
        new MaxAvgPassRatio().maxAverageRatio1(new int[][]{{2,4},{3,9},{4,5},{2,10}},4);
    }

}
