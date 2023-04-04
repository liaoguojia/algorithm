package com.tree.bst;

import com.tree.TreeNode;

import java.util.Arrays;

/**
 * 有序数组转为二叉搜索树
 * 链接：https://leetcode.cn/leetbook/read/top-interview-questions-easy/xninbt/
 * 问题：给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。
 *      高度平衡 二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过 1 」的二叉树。
 * 分析：
 *      方法一 - 递归：每次取数组中间的值比如m作为当前节点，m前面的值作为他左子树的结点值，m后面的值作为他右子树的节点值
 *      方法二 - BFS：
 *
 */
public class SortedArrayToBST {
    /**
     * 方法一 - 递归：
     * @param nums
     * @return
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length == 0)    return null;
        TreeNode root = new TreeNode(nums[nums.length/2]); // 中间节点作为根
        root.left = sortedArrayToBST(Arrays.copyOfRange(nums,0,nums.length/2));
        root.right = sortedArrayToBST(Arrays.copyOfRange(nums,nums.length/2+1,nums.length));
        return root;
    }

}
