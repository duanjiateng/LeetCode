package com.company;

/**
 *  合并两个有序链表
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 * 示例：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 *
 * */

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
public class Main {

    public static void main(String[] args) {
	// write your code here
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode l3 = new ListNode(-1);
        ListNode head = l3;
        ListNode node1 = l1;
        ListNode node2 = l2;
        while(node1 != null && node2 != null) {
            if(node1.val <= node2.val) {
                l3.next = node1;
                node1 = node1.next;
            } else {
                l3.next = node2;
                node2 = node2.next;
            }
            l3 = l3.next;
        }

        if (node1 == null) {
            l3.next = node2;
        } else {
            l3.next = node1;
        }

        return head.next;

    }
}
