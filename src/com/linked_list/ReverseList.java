package com.linked_list;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 反转链表
 * 链接：
 * 问题：给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 * 分析：
 *      方法一 - 递归反转：
 *      方法二 - 使用栈：
 *      方法三 - 头插法构建链表：
 */
public class ReverseList {
    /**
     *
     * @param head
     * @return
     */
    public ListNode reverseList1(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode newHead = reverseList1(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    /**
     * 解法二 - 栈
     * @param head
     * @return
     */
    public ListNode reverseList2(ListNode head){
        if(head == null || head.next == null)   return head;
        Deque<ListNode> stack = new LinkedList<>();
        while( head != null){
            stack.offerFirst(head);
            head = head.next;
        }
        head = stack.peekFirst();
        ListNode node = new ListNode(0);
        while (!stack.isEmpty()){
            node.next = stack.pollFirst();
            node = node.next;
            node.next = null;
        }
        return head;
    }

    /**
     * 解法三 - 头插法构建新链表
     * @param head
     * @return
     */
    public ListNode reverseList3(ListNode head){
        ListNode newHead = null;
        while (head  != null){
            ListNode temp = head.next;
            head.next = newHead;
            newHead = head;
            head = temp;
        }
        return newHead;
    }
}
