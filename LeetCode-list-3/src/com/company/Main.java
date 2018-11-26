package com.company;

/***
 *   反转链表
 *
 * 反转一个单链表。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 */

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}


public class Main {

    public static void main(String[] args) {
	// write your code here
    }

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */


    /**
     * 每次拿出head的第一个结点temp
     * 删除原链表的第一个结点
     * 将temp插入到新链表的第一个
     * */
    public ListNode reverseList(ListNode head) {
        ListNode rhead = new ListNode(-1);
        ListNode nhead = new ListNode(-1);
        nhead.next = head;
        while (nhead.next != null) {
            //拿出head的第一个结点
            ListNode temp = nhead.next;
            nhead.next = nhead.next.next;

            ListNode temp2 = rhead.next;
            rhead.next = temp;
            temp.next = temp2;
        }
        return rhead.next;
    }
}
