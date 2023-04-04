package com.tree.bst;

import com.tree.TreeNode;

/**
 * 验证二叉搜索树
 * 链接：https://leetcode.cn/leetbook/read/top-interview-questions-easy/xn08xg/
 * 问题：给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
 *      有效 二叉搜索树定义如下：
 *          节点的左子树只包含 小于 当前节点的数。
 *          节点的右子树只包含 大于 当前节点的数。
 *          所有左子树和右子树自身必须也是二叉搜索树。
 * 分析：
 *      方法一 - 递归：
 *      方法二 - 中序遍历：中序遍历时，判断当前节点是否大于中序遍历的前一个节点，也就是判断是否有序，如果不大于直接返回 false
 *          中序递归
 *          中序非递归
 */
public class ValidBST {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }

    public boolean isValidBST(TreeNode root,long min,long max) {
        if(root==null)  return true;   //若节点为空，则有效二叉树
        //左子树范围的最小值是minVal，最大值是当前节点的值，也就是root的值，因为左子树的值要比当前节点小
        //右子数范围的最大值是maxVal，最小值是当前节点的值，也就是root的值，因为右子树的值要比当前节点大
        return root.val<max&&root.val>min && isValidBST(root.left,min,root.val) && isValidBST(root.right,root.val,max);
    }


}
