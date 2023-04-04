package com.linked_list;

/**
 * 两链表 相加 - 链表
 * 链接： https://leetcode.cn/problems/add-two-numbers/
 * 问题 ：给定 两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 方式存储的，并且每个节点只能存储 1个数字。
 *      如 l1 : 2->4->3 （表示 342 ），l2：5->6->4 （表示 465）
 *      请你将两个数相加，并以相同形式返回一个表示和的链表。  （342+465=807 ， 链表表示为 7->0->8）
 *
 * 分析 ：
 */
public class AddList {
    /**
     * 两链表元素相加
     * @param l1  ： 链表1
     * @param l2  ：链表2
     * @return  返回两链表 相加后的结果
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2){
        ListNode res = new ListNode(0);
        ListNode cur = res;
        int len = Math.max(l1.length(),l2.length());
        fillList(l1,len);
        fillList(l2,len);
        while(l1!=null && l2!=null){
            int sum = (l1.val+l2.val)+cur.val;;
            cur.val = sum%10;
            ListNode next = new ListNode(sum/10);
            cur.next = next;
            cur = cur.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        System.out.println(res);

        // 判断最后一位是否为0
        cur = res;
        while(cur.next.next!=null){
            cur = cur.next;
        }
        if(cur.next.val==0) cur.next=null;
        return res;
    }

    /**
     * 补全 链表  ：将链表 补到指定长度（填0）
     * @param root  要补全的链表 的根节点
     * @param len   要补到的长度
     */
    public static void fillList(ListNode root,int len){
        ListNode cur = root;
        int rootLen = root.length();
        while(cur.next!=null)   cur = cur.next;
        for(int i = 0 ; i < len-rootLen ;i++){
            ListNode node = new ListNode(0);
            cur.next = node;
            cur = cur.next;
        }
    }

    /**
     * 不 显式 的 补0 ，在循环中判断 若某个链表走到头，则其val=0且不在往后指
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        int add = 0;
        ListNode preHead = new ListNode();
        ListNode cur = preHead;
        while(l1!=null||l2!=null){
            int val1 = 0,val2 = 0;
            if(l1!=null){
                val1 = l1.val;
                l1 = l1.next;
            }
            if(l2!=null){
                val2 = l2.val;
                l2 = l2.next;
            }
            // val1 = l1==null?0:l1.val;
            // val2 = l2==null?0:l2.val;
            ListNode node = new ListNode((add+val1+val2)%10);
            add = (add+val1+val2)/10;
            cur.next = node;
            cur = cur.next;
        }
        if(add>0){
            cur.next = new ListNode(add);
        }
        return preHead.next;
    }

    public static void main(String[] args) {
//        new AddList().addTwoNumbers2();
    }
}
