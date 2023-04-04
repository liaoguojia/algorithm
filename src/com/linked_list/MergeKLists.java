package com.linked_list;

/**
 * 合并K个有序链表 - 链表
 * 链接：https://leetcode.cn/problems/merge-k-sorted-lists/
 * 问题：给定一个链表数组，每个链表都已经按升序排列。  将所有链表合并到一个升序链表中，返回合并后的链表
 * 分析： 前置知识 ： 合并两个有序链表
 *      方法一： 顺序合并（两两合并 / 每次从k个节点中找到一个最小的） ，时间O(k*(总nodes数))，空间O(1)
 *      方法二： 分治合并
 *      方法三： 优先队列合并
 */
public class MergeKLists {
    /**
     * 每次从k个链表中 找出一个最小节点，直到所有链表都为空
     * @param lists   链表数组，每个元素存放链表的头节点
     * @return  合并后的链表头
     */
    public ListNode mergeKLists(ListNode[] lists) {
        int nullListNum = 0;  //到达结尾的 链表 数
        ListNode cur = new ListNode();
        ListNode pre = cur;

        while(nullListNum < lists.length){
            int idx = -1;
            ListNode small = new ListNode(Integer.MAX_VALUE);
            for(int i = 0 ; i < lists.length ;i++){
                ListNode node = lists[i];
                if(node!=null && node.val < small.val){  //找到最小的节点
                    small = node;
                    idx = i;
                }
            }
            // 若找到节点
            if(idx>=0){
                cur.next = lists[idx];
                cur = cur.next;
                lists[idx] = lists[idx].next;
                if(lists[idx]==null)    nullListNum++; //节点 往后移到了空
            }else{  // 用于判断，lists中全是空节点的情况
                nullListNum = lists.length;
            }
        }
        return pre.next;
    }

    /**
     * 对所有 链表进行两两合并
     * @param lists
     * @return
     */
    public ListNode mergeKLists1(ListNode[] lists){
        return null;
    }
}
