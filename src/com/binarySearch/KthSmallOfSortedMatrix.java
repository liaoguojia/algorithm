package com.binarySearch;

/**
 * 有序矩阵中的 第k小的值
 * 链接：https://leetcode.cn/problems/kth-smallest-element-in-a-sorted-matrix/
 * 问题：给你一个 n x n 矩阵 matrix ，其中每行和每列元素均按升序排序，找到矩阵中第 k 小的元素。
 *      请注意，它是 排序后 的第 k 小元素，而不是第 k 个 不同 的元素。
 *
 * 分析：
 *      方法二 - 二分查找 ： 给定一个数，在有序矩阵 matrix 中找到它是第几小的数 ， 时间复杂度为 O（N）
 */
public class KthSmallOfSortedMatrix {

    /**
     * 方法二 - 二分查找
     * @param matrix
     * @param k
     * @return
     */
    public int kthSmallest(int[][] matrix, int k) {
        int left = matrix[0][0], right = matrix[matrix.length-1][matrix[0].length-1];
        while(left < right){
            int mid = left + ((right-left)>>1);  // mid 更靠左
            int smaller = findSmaller(matrix, mid);
            if(smaller < k){   // 若小于k，则left必不可能是答案
                left = mid+1;
            }else{         // 不能判断 smaller==k时 直接退出，这样没法保证mid在矩阵内
                right = mid;   // 若左边 还有正确答案，则左移
            }
        }
        return right;
    }

    /**
     * 在 有序矩阵中 找出 比 number 小的元素的个数
     * @param matrix
     * @param number
     * @return
     */
    public int findSmaller(int[][] matrix,int number){
        int smaller = 0;
        int idx = matrix[0].length-1 ;
        // 虽然是两层循环，实际上 idx 在逐渐 左移
        for(int i = 0 ; i < matrix.length ;i++){
            for(int j = idx ; j >= 0 ;j--){
                if(matrix[i][j] <= number){   //从后往前 找到该层中第一个 <= number 的数
                    smaller += j+1;     // 则该层 小于 number 的个数 就找到了
                    idx = j;     // 下一层必定从该idx开始往前找，因为后一个必定大于number
                    break;
                }
            }
        }
        return smaller;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,5,9},{10,11,14},{12,14,15}};
        int res = new KthSmallOfSortedMatrix().kthSmallest(matrix,8);
        System.out.print(res);
    }
}
