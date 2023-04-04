package com.sort.heap.priorityQueue;

import java.util.PriorityQueue;

/**
 * Java的优先队列
 * 通过完全二叉树的堆 实现，即可通过数组实现
 *
 */
public class JavaPriorityQueue {
    public static void main(String[] args) {
        // 指定 优先顺序 ， 指定比较器 初始化 优先队列
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((o1,o2)-> o2-o1);
        priorityQueue.offer(2);
        priorityQueue.offer(7);
        priorityQueue.offer(1);
        priorityQueue.offer(3);
        System.out.println(priorityQueue);  // 实现 堆结构的数组
//        priorityQueue.remove()
    }
}
