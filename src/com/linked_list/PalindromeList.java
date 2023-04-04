package com.linked_list;

/**
 * 回文链表
 * 链接：
 * 问题：给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。
 * 分析：
 *      方法一 - 反转后半部分链表：
 *      方法二 - 递归 从后往前遍历 链表：
 */
public class PalindromeList {
    ListNode temp;

    /**
     * 方法二 - 递归
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        temp = head;
        return check(head);
    }

    private boolean check(ListNode head) {
        if (head == null)
            return true;
        // check到尾，再往前。（往前时temp往后）
        boolean res = check(head.next) && (temp.val == head.val);
        temp = temp.next;
        return res;
    }

}
