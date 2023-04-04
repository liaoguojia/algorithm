package com.union_find;
import java.util.*;

/**
 * 除法求值 - 并查集
 * 链接  ：https://leetcode.cn/problems/evaluate-division/
 * 问题：给定一个变量对数组 equations 和一个实数值数组 values 作为已知条件
 *      equations[i] = [Ai, Bi] 和 values[i] 共同表示等式 Ai / Bi = values[i] （Ai,Bi是变量，用字符串表示）
 *      queries数组表示要求解的问题，若问题找不到答案，返回-1.0
 * 分析 ： 使用带权的并查集，每个变量都是一个节点，节点 = n*父节点，n表示节点与父结点之间 的权重
 *
 */
public class DivisionResult {
    Map<String,String> fatherMaps = new HashMap<>();
    Map<String,Double> valueMaps = new HashMap<>();
    String root = " ";
    /**
     *
     * @param equations  存放变量对的 数组 ，
     * @param values   存放变量除法结果 的数组 ，
     * @param queries   要求的 除法式子
     * @return
     */
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

        for(int i = 0 ;i < values.length ;i++){
            String s1 = equations.get(i).get(0), s2 = equations.get(i).get(1);
            if(!fatherMaps.containsKey(s1)){
                fatherMaps.put(s1,s1);
                valueMaps.put(s1,1.0);
            }
            if(!fatherMaps.containsKey(s2)){
                fatherMaps.put(s2,s2);
                valueMaps.put(s2,1.0);
            }
            double value1 = find(s1);
            String father1 = root;
            double value2 = find(s2);
            String father2 = root;
            if(father1.equals(father2)){
                // 即 再次出现关系，
            }else{
                fatherMaps.put(father1,father2);
                valueMaps.put(father1,value2/value1*values[i]);
            }
        }
        System.out.println(fatherMaps+"\n"+valueMaps);
        double[] res = new double[queries.size()];
        for (int i =  0 ; i < queries.size() ;i++){
            String s1 = queries.get(i).get(0),s2 = queries.get(i).get(1);

            double value1 = find(s1);
            String father1 = root;
            double value2 = find(s2);
            String father2 = root;
            System.out.println(s1+"="+value1+father1+" "+s2+"="+value2+father2);
            if(!fatherMaps.containsKey(s1)||!fatherMaps.containsKey(s2)||!father1.equals(father2)){
                res[i] = -1.0;
                continue;
            }
            res[i] = value1/value2;
        }
        return  res;
    }

    /**
     * 找到 某变量的根 变量
     * @param s  变量
     * @return
     */
    public double find(String s){
        double value = 1.0;
        if(!fatherMaps.containsKey(s))   return value;
        while(!fatherMaps.get(s).equals(s)){
            value *= valueMaps.get(s);
            s = fatherMaps.get(s);
        }
        root = new String(s);
        return value;
    }

    public static void main(String[] args) {
        double[] values = {2.0,3.0};
        List<List<String>> equations = new ArrayList<>();
//        equations.add(List)
//        [["a","b"],["b","c"]]
    }
}
