package com.company;

import java.util.HashSet;
import java.util.Set;

/**
 *  环形链表
 * 给定一个链表，判断链表中是否有环。
 *
 * 进阶：
 * 你能否不使用额外空间解决此题？
 * */

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}
public class Main {

    public static void main(String[] args) {
	// write your code here
    }

    /**
     * 使用set容器
     * 遍历链表，判断是否在容器中，若存在则出现回环
     * */
    public boolean hasCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head))
                return true;
            set.add(head);
            head = head.next;
        }
        return false;
    }

    /**
     * 使用双链表
     * 自行车和汽车速度不同，他们从不同起点出发，如果没有回环，则他们永远不会相遇
     * 定义两个指针　fast slow
     * fast 每次走两步
     * slow 每次走一步
     * 如果存在环，那么fast和slow总会相遇
     * 
     * */
    public boolean hasCycle1(ListNode head) {
        if ( head == null || head.next == null )
            return false;
        ListNode slow = head;
        ListNode fast = head.next;

        while ( fast != slow ) {
            if (fast == null || fast.next == null)
                return false;
            slow = slow.next;
            fast = fast.next.next;
        }

        return true;
        
    }
}
