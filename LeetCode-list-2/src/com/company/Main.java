package com.company;

/**
 * 删除链表的倒数第N个节点
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 *
 * 示例：
 *
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 *
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 *
 * 给定的 n 保证是有效的。
 *
 * */
public class Main {

    public static void main(String[] args) {
	// write your code here
        ListNode head = new ListNode(1);
        ListNode head1 = new ListNode(2);
        ListNode head2 = new ListNode(3);
        ListNode head3 = new ListNode(4);
        ListNode head4 = new ListNode(5);
        head.next = head1;
        head1.next = head2;
        head2.next = head3;
        head3.next = head4;
        removeNthFromEnd(head, 1);

    }

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    /**
     * 第一步:找到目标结点
     * 第二步:删掉目标结点（用后一个覆盖前一个）
     *
     * 倒数第n个　＝　正数　链表－n 个
     * */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        int size = getSize(head);
        ListNode temp = head;

        while (size - n >= 0) {
            if (n == size && n ==1) {
                return null;
            }
            if (size - n == 1 && n == 1) {
                temp.next = null;
                return head;
            }
            if (size - n == 0) {
                temp.val = temp.next.val;
                temp.next = temp.next.next;
                return head;
            }
            size--;
            temp = temp.next;
        }
        return null;
    }

    /**
     * 只需扫描一次，　使用双指针
     * ListNode left, right
     * 先使 right 移动n次
     * 然后同时移动两个指针，知道移动到链表末尾
     *
     * 链表长度L，倒数第n个
     * 相当于删除第L-n个
     * right先移动n，则剩余L-n
     * */
    public static ListNode removeNthFromEnd1(ListNode head, int n) {
        ListNode right = head;
        ListNode left = head;

        //rigth 先移动n次
        for (int i = 0; i < n; i++) {
            right = right.next;
        }

        //判断right是否到达边界
        if (right == null) {
            head = head.next;
            return head;
        }

        //right 和 left同时移动
        while (right.next != null) {
            right = right.next;
            left = left.next;
        }
        left.next = left.next.next;
        return head;
    }


    private static int getSize(ListNode head) {
        ListNode node = head;
        int size = 0;
        while (node != null) {
            size++;
            node = node.next;
        }
        return size;
    }

}
