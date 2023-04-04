package com.linked_list;

public class ListNode {
    int val;
    public ListNode next;

    public ListNode() {}

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public int length(){
        int len = 0;
        ListNode cur = this;
        while(cur!=null){
            len++;
            cur = cur.next;
        }
        return len;
    }

    @Override
    public String toString() {
        ListNode cur =  this ;
        while(cur!=null){
            cur = cur.next;
            System.out.print(cur.val+"->");
        }
        return "ListNode{" ;
    }
}
