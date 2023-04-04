package com.binarySearch;

/**
 * 二分查找
 * 链接：https://leetcode.cn/problems/maximum-value-at-a-given-index-in-a-bounded-array/
 * 问题 ： 要求构造一个数组，使得指定idx的值最大，且相邻元素之差不超过1，且数组总和不能超过maxSum
 * 分析： 二分搜索所有可能的值：最小 maxSum/n, 最大 maxSum-n+1
 *
 */
public class MaxValueInBoundArray {
    /**
     *
     * @param n  数组长度
     * @param index   指定下标
     * @param maxSum   数组和不能超过的 最大值
     * @return  指定下标的最大值
     */
    public int maxValue(int n, int index, int maxSum) {
        int left = maxSum/n, right = maxSum-n+1;
        while (left < right) {
            int mid = left + (right - left)/2+1 ;
            if (sum(n, index,mid) > maxSum) {
                right = mid-1;
            } else if(sum(n, index,mid) < maxSum){
                left = mid ;
            }else{
                return mid;
            }
        }
        return left;
    }

    /**
     * 求指定下标存放指定数字后，构成的满足条件的 数组和
     * @param n  长度
     * @param idx   指定的下标
     * @param number   指定下标 存放 的数字
     * @return  由于求 阶乘可能造成int越界到 long，转换成long进行运算
     */
    public long sum(int n,int idx,int number){
        long num = (long)number;
        long res = -num;
        if(num>=idx+1){
            res += (num+(num-idx))*(idx+1)/2;
        }else{
            res += (num+1)*num/2 + (idx+1-num) ;
        }
//        System.out.println("left+"+res);
        if(num>=(n-idx)){
            res+=(num+(num-(n-idx)+1))*(n-idx)/2;
        }else{
            res += (num+1)*num/2+ (n-idx-num);
        }
        System.out.println("num="+num+" sum="+(res-num));
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new MaxValueInBoundArray().maxValue(3,0,815094800));
    }
}
