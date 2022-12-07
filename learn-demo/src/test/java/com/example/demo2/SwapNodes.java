package com.example.demo2;

/**
 * @author Wonder7zq
 * @date 2022/3/28 - 16:55
 */

public class SwapNodes {

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    /*    方法一、值交换
                找到倒数第k个节点和第k个节点后进行值交换
    */
    public ListNode swapNodes(ListNode head, int k) {
        ListNode left = head;// 第k个节点
        ListNode right = head;// 倒数第k个节点
        for (int i = 1; i < k; i++) {
            left = left.next;
        }
        ListNode cur = left;
        while (cur.next != null) {
            right = right.next;
            cur = cur.next;
        }
        // 交换左右两个节点的值
        int m = right.val;
        right.val = left.val;
        left.val = m;
        return head;
    }

//    public static void main(String[] args) {
//        ListNode listNode = new ListNode(1);
//
//    }

/*    方法二、节点交换
    需要很多指针，用来进行交换节点的定位
    以及分别考虑两种特殊情况：
            ①、倒数第k个节点刚好在第k个节点的左侧一个节点
            ②、第k个节点刚好在倒数第k个节点的右侧一个节点
*/

            public ListNode swapNodes1(ListNode head, int k) {
                ListNode dummy = new ListNode(0);
                dummy.next = head;// 因为头结点可能会发生交换，所以要构造一个哑结点
                ListNode pre1 = dummy;// pre1指向第k个节点的前一个节点
                ListNode left = dummy.next;// 第k个节点
                ListNode pre2 = dummy;// pre2指向倒数第k个节点的前一个节点
                ListNode right = dummy.next;// 倒数第k个节点
                for (int i = 1; i < k; i++) {
                    pre1 = pre1.next;
                    left = left.next;
                }
                ListNode cur = left;
                ListNode temp = left.next;// 第k个节点的后一个节点
                while (cur.next != null) {
                    pre2 = pre2.next;
                    right = right.next;
                    cur = cur.next;
        }
        if (right == pre1) {// 特殊情况，倒数第k个节点在第k个节点的左侧
            right.next = temp;
            left.next = right;
            pre2.next = left;
        } else {
            left.next = right.next;
            if (pre2 == left) {
                right.next = left;
            }// 特殊情况，第k个节点在倒数第k个节点的左侧
            else {
                pre2.next = left;
                right.next = temp;
            }
            pre1.next = right;
        }
        return dummy.next;
    }

}
