package com.tree.traverse;
import com.tree.TreeNode;

import java.util.*;

/**
 * 二叉树的中序遍历 - 递归 / 迭代
 * 链接：https://leetcode.cn/problems/binary-tree-inorder-traversal/
 * 问题：给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。
 * 分析：
 *      方法一 - 递归：
 *      方法二 - 借助栈的迭代方法：
 */
public class InorderTraversal {

    /**
     * 方法一 - 递归实现 中序遍历
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        inorder(root, res);
        return res;
    }
    /**
     * 对二叉树进行中序遍历，结果放在res
     * @param root   二叉树根节点
     * @param res   存放结果的数组
     */
    public void inorder(TreeNode root, List<Integer> res) {
        if (root == null)   return;

        inorder(root.left, res);  //左
        res.add(root.val);   //中
        inorder(root.right, res);   //右
    }

    /**
     * 方法二 - 迭代
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        Deque<TreeNode> stk = new LinkedList<TreeNode>();
        while (root != null || !stk.isEmpty()) {
            while (root != null) {  //左
                stk.push(root);
                root = root.left;
            }
            root = stk.pop();
            res.add(root.val);
            root = root.right;
        }
        return res;
    }



}
