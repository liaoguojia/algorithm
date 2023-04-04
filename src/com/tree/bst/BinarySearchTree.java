package com.tree.bst;

import com.tree.TreeNode;

/**
 * 二叉搜索树
 * 节点的左子树仅包含键 小于 节点键的节点。
 * 节点的右子树仅包含键 大于 节点键的节点。
 * 左右子树也必须是二叉搜索树。
 */
public class BinarySearchTree {
    int sum;

    /**
     * 使每个节点 node 的新值等于原树中大于或等于 node.val 的值之和。
     * @param root
     * @return
     */
    public TreeNode convertBST(TreeNode root) {
        // 使用反中序遍历，
        if(root!=null){
            convertBST(root.right);
            sum += root.val;
            root.val = sum;
            convertBST(root.left);
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = null;
        new BinarySearchTree().convertBST(root);
    }
}
