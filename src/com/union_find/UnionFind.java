package com.union_find;

/**
 * 并查集
 *      常用来解决连通性的问题，即 将一个图中连通的部分划分出来。 就可以根据两点是否在同一连通区域，判断两个点之间是否存在路径
 * 并查集的思想就是
 *      同一个连通区域内的所有点的根节点是同一个。将每个点映射成一个数字。
 *      先假设每个点的根节点就是他们自己，然后我们以此输入连通的点对，然后将其中一个点的根节点赋成另一个节点的根节点，这样这两个点所在连通区域又相互连通了
 *
 */
public class UnionFind {
    int[] parents;

    public UnionFind(int totalNodes) {
        parents = new int[totalNodes];
        for (int i = 0; i < totalNodes; i++) {
            parents[i] = i;
        }
    }

    /**
     * 合并两个点的连通区域
     * 合并连通区域是通过find来操作的, 即看这两个节点是不是在一个连通区域内.
     * @param node1
     * @param node2
     */
    void union(int node1, int node2) {
        int root1 = find(node1);
        int root2 = find(node2);
        if (root1 != root2) {
            parents[root2] = root1;
        }
    }

    /**
     * 查找node的根节点
     * @param node
     * @return
     */
    int find(int node) {
        while (parents[node] != node) {
            // 当前节点的父节点 指向父节点的父节点.
            // 保证一个连通区域最终的parents只有一个.
            parents[node] = parents[parents[node]];
            node = parents[node];
        }

        return node;
    }

    /**
     * 判断两节点是否在同一连通区域
     * @param node1
     * @param node2
     * @return
     */
    boolean isConnected(int node1, int node2) {
        return find(node1) == find(node2);
    }
}
