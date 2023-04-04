package com.sort;

import javax.sound.midi.Soundbank;
import java.util.*;

/**
 *
 */
public class Paixu {
    /**
     * 链接：https://leetcode.cn/problems/queue-reconstruction-by-height
     * 假设有打乱顺序的一群人站成一个队列，数组 people 表示队列中一些人的属性（不一定按顺序）。
     * 每个 people[i] = [hi, ki] 表示第 i 个人的身高为 hi ，前面 正好 有 ki 个身高大于或等于 hi 的人。
     *
     * @param people
     * @return  重新构造并返回 按照输入数组people所表示的队列。返回的队列应该格式化为数组 queue
     * 其中 queue[j] = [hj, kj] 是队列中第 j 个人的属性（queue[0] 是排在队列前面的人）。
     */
    public static int[][] reconstructQueue(int[][] people) {
        // 指定comparator排序，使用匿名内部类
        Arrays.sort(people,(o1, o2)->{
            if(o1[0]==o2[0]){  //相同身高时，按照 更高个数从小到大
                return o1[1]-o2[1];
            }else{
                return o2[0]-o1[0]; //身高从大到小
            }
        });
        // 从高到低，排序后的people中每一个p依次放入queue，此时queue中元素均比p高，只需按其p[1]位置插入
        List<int[]> queue = new ArrayList<>();
        for(int[] p:people){
            queue.add(p[1],p);
        }
        // 使用流显示结果
        queue.stream().forEach(i-> System.out.print(Arrays.toString(i)+", "));
        queue.toArray(people); // 将list<int>收集到int[]数组中
        return people;
    }

    /**
     * 方法二：按身高从低到高依次 放入
     * @param people
     * @return
     */
    public static int[][] reconstructQueue2(int[][] people){
        // 按身高从低到高 依次放入
        Arrays.sort(people,(o1,o2)->{
            if(o1[0]==o2[0]){   //身高相同，按 更高数从小到大
                return o1[1]-o2[1];
            }else{
                return o1[0]-o2[0];
            }
        });

        for(int i = 0 ; i < people.length-1 ;i++){
            if(people[i+1][0]==people[i][0]){
                people[i+1][1]--;
            }
        }
        int[][] queue = new int[people.length][];
        for(int[] p : people){
            int space = p[1];
            for(int i = 0 ; i < queue.length;i++){
                if(queue[i]==null){
                    if(space==0){
                        queue[i] = p;
                        break;
                    }else{
                        space--;
                    }
                }else{
                    p[1] = queue[i][0] >= p[0] ? p[1] + 1 : p[1];
                }
            }
        }
        return queue;
    }

    public static void main(String[] args) {
        int[][] people = {{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
        reconstructQueue(people);

        System.out.print("\n方法二");
        for(int[] p:reconstructQueue2(people)){
            System.out.print(Arrays.toString(p)+"- ");
        }
    }
}
