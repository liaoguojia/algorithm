package com.tree;
import java.util.*;

/**
 * 二叉树的序列化与反序列化 - DFS
 * 链接：https://leetcode.cn/problems/serialize-and-deserialize-binary-tree/
 * 问题：保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构
 * 分析：要遍历二叉树得到一个序列化并不难，想到广度优先BFS（层序遍历），深度优先DFS（先/中/后 序 遍历）
 *      关键在于通过该字符串能还原树
 *      LGJ方法 - 层序遍历：层序中可直接计算 父子节点的位置关系，但是要将所有节点包括null也放入，遍历超时
 *      方法一 - 先序遍历：
 */
public class SerializeAndDeserializeBinaryTree {

    /**
     * Encodes a tree to a single string. 序列化二叉树
     * @param root  二叉树根节点
     * @return  将二叉树序列化成一个字符串 （反序列化时可通过该字符串还原出该树）
     */
    public String serialize(TreeNode root) {
        if(root==null)  return "null,";
        // 先序遍历
        return String.valueOf(root.val+",") + serialize(root.left) + serialize(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] dataArray = data.split(",");
        List<String> dataList = new LinkedList<String>(Arrays.asList(dataArray));
        return rdeserialize(dataList);
    }

    public TreeNode rdeserialize(List<String> dataList) {
        if (dataList.get(0).equals("null")) {
            dataList.remove(0);
            return null;
        }

        TreeNode root = new TreeNode(Integer.valueOf(dataList.get(0)));
        dataList.remove(0);
        root.left = rdeserialize(dataList);
        root.right = rdeserialize(dataList);

        return root;
    }
}
