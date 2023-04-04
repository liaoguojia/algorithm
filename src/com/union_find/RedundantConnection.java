package com.union_find;

import java.util.Arrays;

/**
 * 树 的冗余连接  - 并查集
 * 链接 ： https://leetcode.cn/problems/redundant-connection/
 * 问题： 给定往一棵 n 个节点 (节点值 1～n) 的树中添加一条边后的图
 *      添加的边的两个顶点包含在 1 到 n 中间，且这条附加的边不属于树中已存在的边。
 *      请找出一条可以删去的边，删除后可使得剩余部分是一个有着 n 个节点的树
 * 分析： 最初每个节点分开。 遍历边：  找边的两点 的 根节点（父节点的父节点的……直到 某节点的父节点=自己）
 *       若 两点的根相同，说明之前两点已经连通， 本条边形成环
 *       若 根不相同，则将其连通，使根1的父节点为根2。
 */
public class RedundantConnection {

    /**
     *
     * @param edges  二维数组 记录图的信息，edges[i] = [ai, bi] 表示图中在 ai 和 bi 之间存在一条边
     * @return  返回多余的边，使得删除该边后的部分是有n个节点的树。若存在多条边，返回最后出现的边
     */
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length; //节点数
        int[] fathers = new int[n+1];
        // 每个节点最初 自连
        for(int i = 1 ; i <= n ;i++){
            fathers[i] = i;
        }
        int[] res = new int[2];
        // 遍历边
        for(int i = 0 ; i < edges.length ;i++){
            int node1 = edges[i][0], node2 = edges[i][1];
            // 若两节点的根节点相同，说明 已经连接在一起，再添加该边会形成环
            int father1 = find(fathers,node1) , father2 = find(fathers,node2);
            if(father2==father1){
                res = edges[i];
            }else{
                fathers[father1] = father2;
            }
        }
        return res;
    }

    /**
     * 找到 某节点的 根节点
     * @param fathers  存放父节点关系的数组
     * @param node  节点
     * @return
     */
    public int find(int[] fathers,int node){
        while(fathers[node]!=node){
            node = find(fathers,fathers[node]);
        }
        return node;
    }

    public static void main(String[] args) {
        int[] res = new int[2];
        int[][] edges = {{1,2},{2,3},{3,4},{1,4},{1,5}};
        res = new RedundantConnection().findRedundantConnection(edges);
        System.out.println(Arrays.toString(res));
    }
}
