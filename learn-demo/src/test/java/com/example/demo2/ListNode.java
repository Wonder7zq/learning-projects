package com.example.demo2;

/**
 * @author Wonder7zq
 * @date 2022/5/27 - 16:39
 */
public class ListNode {
    int val;	//结点值
    ListNode next;	//用来指向下一个结点的ListNode对象
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

}
