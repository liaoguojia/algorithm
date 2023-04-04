package com.test;
import  java.util.*;

public class Test {
    /**
     * 暴力解法，遍历nums中每一位是取+/-，有两种情况，可以使用 长为nums.length的二进制串 来表示一种情况，总共2^n种判断
     *          (1<<i)&kind)==0 判断kind的第i位 是否为0
     *
     * 回溯 ：
     * @param nums
     * @param target
     * @return
     */
    public int findTargetSumWays(int[] nums, int target) {
        int res = 0;
        int kinds = (int) Math.pow(2,nums.length);
        for(int kind = 0 ; kind < kinds ;kind++){
            int sum = 0;
            for(int i = 0 ; i < nums.length ;i++){
                if(((1<<i)&kind)==0){
                    sum += nums[i];
                }else{
                    sum -= nums[i];
                }
            }
            if(sum==target) res++;
        }
        return res;
    }

    public static int find(int[] nums,int target,int start){
        if(start >= nums.length)    return 0;
        int res = 0;
        if(start==nums.length-1){
            if(target==nums[start]) res++;
            if(target==-nums[start])    res++;
            return res;
        }
        return find(nums,target-nums[start],start+1)+find(nums,target+nums[start],start+1);
    }


    public int maxCoins(int[] nums) {
        List<Integer> list = new ArrayList<>();

        for(int i = 0  ; i < nums.length ;i++){
            list.add(i,nums[i]);
        }

        int res = 0;
        while(list.size() >= 3){
            int minIdx = 1;
            for(int i = 2 ; i < list.size()-1 ; i++){
                if(list.get(i) < minIdx){
                    minIdx = i ;
                }
            }
            res += list.get(minIdx)*list.get(minIdx-1)*list.get(minIdx+1);
            System.out.println("移除"+list.get(minIdx)+" 得到"+res);
            list.remove(minIdx);
        }

        return res + list.get(0)*list.get(1)+Math.max(list.get(0),list.get(1));
    }

    public static void main(String[] args) {
//        new T
        int i = new Test().maxCoins(new int[]{3, 1, 5, 8});
        System.out.println(i);
    }
}
