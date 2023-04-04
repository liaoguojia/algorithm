package com.double_pointer.fast_slow_pointer;

import com.linked_list.ListNode;

/**
 * 删除链表倒数第N个节点
 * 链接：https://leetcode.cn/leetbook/read/top-interview-questions-easy/xn2925/
 * 问题：给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。 - 要求一趟扫描实现
 * 分析：
 *      方法一 - 求链表长度：
 *      方法二 - 双指针：fast指针先移动n次，然后slow和fast一起移动直到fast==null，此时slow移动了 (len-n)次
 *      方法三 - 递归：递归求链表长度是从后往前移动的，移动过程中的长度 就是倒数值
 *
 *
 */
public class RemoveNthFromEnd {
    /**
     * 解法二 - 双指针
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode fast = head,slow = head;
        for (int i = 0; i < n; i++) fast = fast.next;
        // 若 快指针为空，则说明 移动了n = len次，要删除头节点
        if(fast==null)  return head.next;
        while(fast.next != null){  // slow需要移到删除节点的前一个节点
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }

    /**
     * 解法三 - 递归
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd3(ListNode head, int n) {
        if(lengthOfLinkedList(head,n) == n){
            return head.next;
        }
        return head;
    }

    /**
     * 解法三 - 递归求长度过程中，找出倒数第n个节点
     * @param head
     * @param n
     * @return
     */
    public int lengthOfLinkedList(ListNode head, int n) {
        if(head == null)    return 0;
        int nextLen = lengthOfLinkedList(head.next,n);

        if(nextLen == n){   // head 后面还有n个节点，则此时head节点就是倒数第n个节点之前
            head.next = head.next.next;
        }
        return nextLen+1;
    }

    /**
     * 解法三 - 递归求 链表长度
     * @param head
     * @return
     */
    public int lengthOfLinkedList(ListNode head){
        if(head==null)  return 0;
        return lengthOfLinkedList(head.next)+1;
    }
}
