package com.dp.houseRob;

import com.dp.TreeNode;

/**
 * 打家劫舍3 - 动态规划
 * 链接 ： https://leetcode.cn/problems/house-robber-iii/
 * 问题：二叉树中 两个直接相连的 节点 不能同时被打劫
 * 分析 ： 每个节点 是选中 时的最大值， 不选中 时的最大值 （ 其实HouseRobber1也是每个idx选中时的最大值与未选中值的最大值，转化而来的公式）
 *      选中本节点的递推公式 ： select[i] = unselect[i.left]+unselect[i.right]  + i.val
 *      不选本节点的递推公式 ： unselect[i] = max(select[i.left],unselect[i.left]) + max(select[i.right],unselect[i.right])
 */
public class HouseRobber3 {

    public int rob(TreeNode root) {
        int[] res = robNode(root);
        return Math.max(res[0],res[1]);
    }

    // res[0]表示选中该节点的最大值，1不选中
    public int[] robNode(TreeNode root){
        if(root == null)    return new int[]{0,0};
        int[] res = new int[2];
        int[] left = robNode(root.left);
        int[] right = robNode(root.right);
        res[0] = left[1]+right[1]+root.val;
        res[1] = (Math.max(left[0],left[1])+Math.max(right[1],right[0]));
        return res;
    }

    public static void main(String[] args) {

    }
}
