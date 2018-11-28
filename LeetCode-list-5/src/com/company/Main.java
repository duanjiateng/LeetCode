package com.company;

import java.util.Stack;

/**
 * 回文链表
 *
 * 请判断一个链表是否为回文链表。
 *
 * 示例 1:
 *
 * 输入: 1->2
 * 输出: false
 * 示例 2:
 *
 * 输入: 1->2->2->1
 * 输出: true
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 * */

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class Main {

    public static void main(String[] args) {
	// write your code here
        ListNode head = new ListNode(1);
        ListNode head1 = new ListNode(1);
        ListNode head2 = new ListNode(2);
        ListNode head3 = new ListNode(1);
        //ListNode head4 = new ListNode(5);
        head.next = head1;
        head1.next = head2;
        head2.next = head3;
        //head3.next = head4;
        System.out.println(isPalindrome(head));
    }

    /**
     * 判断是否为回文，就是第１个和倒数第一个是否相等，以此类推
     * 所以　将一个链表反转，与原链表比较
     * */
    public static boolean isPalindrome(ListNode head) {
        ListNode head1 = head;
        ListNode rhead = reverseList(head);
        while (rhead != null && head1 != null) {
            if (rhead.val != head1.val) {
                return false;
            }
            rhead = rhead.next;
            head1 = head1.next;
        }
        return true;
    }

    private static ListNode reverseList(ListNode head) {
        ListNode rhead = new ListNode(-1);
        ListNode nhead = new ListNode(-1);
        nhead.next = head;
        while (nhead.next != null) {
            //拿出head的第一个结点
            ListNode temp = new ListNode(nhead.next.val);
            nhead.next = nhead.next.next;

            ListNode temp2 = rhead.next;
            rhead.next = temp;
            temp.next = temp2;
        }
        return rhead.next;
    }

    /**
     * 使用stack来倒转链表
     * */
    public static boolean isPalindrome1(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode cur = head;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }

        while (head != null) {
            if (head.val != stack.pop().val)
                return false;
            head = head.next;
        }

        return true;
    }
}
