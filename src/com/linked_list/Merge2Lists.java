package com.linked_list;

import com.sun.jmx.remote.internal.ClientNotifForwarder;

/**
 * 合并两个有序链表
 * 链接：
 * 问题：
 * 分析：
 *      方法一 - 遍历两个链表：遍历每个链表的头，比较一下哪个小就把哪个链表的头拿出来放到新的链表中，
 *              一直这样循环，直到有一个链表为空，然后我们再把另一个不为空的链表挂到新的链表中
 *      方法二 - 递归：
 */
public class Merge2Lists {
    /**
     * 解法一 - 遍历两个链表
     * @param list1
     * @param list2
     * @return
     */
    public ListNode mergeTwoLists1(ListNode list1, ListNode list2) {
        if(list2==null) return list1;
        if(list1==null) return list2;
        ListNode node = new ListNode(0);
        ListNode preHead = node;
        while( list1 != null && list2 != null){
            if(list1.val <= list2.val){
                node.next = list1;
                node = node.next;
                list1 = list1.next;
            }else{
                node.next = list2;
                node = node.next;
                list2 = list2.next;
            }
        }
        node.next = (list1==null?list2:list1);
        return preHead.next;
    }

    /**
     * 方法二 - 递归
     * @param list1
     * @param list2
     * @return
     */
    public ListNode mergeTwoLists2(ListNode list1, ListNode list2) {
        if(list1==null) return list2;
        if(list2==null) return list1;
        if(list1.val <= list2.val){
            list1.next = mergeTwoLists2(list1.next,list2);
            return list1;
        }else{
            list2.next = mergeTwoLists2(list1,list2.next);
            return list2;
        }
    }
}
