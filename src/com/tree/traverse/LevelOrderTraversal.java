package com.tree.traverse;
import com.tree.TreeNode;
import java.util.*;

/**
 * 层序遍历 二叉树
 * 链接：https://leetcode.cn/leetbook/read/top-interview-questions-easy/xnldjj/
 * 问题：给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）
 * 分析：
 *      方法一 - BFS：使用队列
 *      方法二 - DFS
 */
public class LevelOrderTraversal {

    /**
     * 方法一 - BFS ： 使用队列存放
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder1(TreeNode root) {
        if(root==null)  return new ArrayList<>();  // 边界判断

        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        queue.offer(root);
        while( !queue.isEmpty() ){
            int n = queue.size();  // 当前层的节点数
            List<Integer> list = new ArrayList<>();
            for(int i = 0 ; i < n ;i++){     //取出当前层的所有节点放入list，并将所有子节点入队
                TreeNode node = queue.poll();
                if(node.left!=null) queue.offer(node.left);
                if(node.right!=null)    queue.offer(node.right);
                list.add(node.val);
            }
            res.add(list);
        }
        return res;
    }
}
