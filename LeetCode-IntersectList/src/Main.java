/*
相交链表
编写一个程序，找到两个单链表相交的起始节点。

例如，下面的两个链表：

A:          a1 → a2
                   ↘
                     c1 → c2 → c3
                   ↗
B:     b1 → b2 → b3
在节点 c1 开始相交。



示例 1：

输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
输出：Reference of the node with value = 8
输入解释：相交节点的值为 8 （注意，如果两个列表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。


示例 2：

输入：intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
输出：Reference of the node with value = 2
输入解释：相交节点的值为 2 （注意，如果两个列表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [0,9,1,2,4]，链表 B 为 [3,2,4]。在 A 中，相交节点前有 3 个节点；在 B 中，相交节点前有 1 个节点。


示例 3：

输入：intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
输出：null
输入解释：从各自的表头开始算起，链表 A 为 [2,6,4]，链表 B 为 [1,5]。由于这两个链表不相交，所以 intersectVal 必须为 0，而 skipA 和 skipB 可以是任意值。
解释：这两个链表不相交，因此返回 null。


注意：
如果两个链表没有交点，返回 null.
在返回结果后，两个链表仍须保持原有的结构。
可假定整个链表结构中没有循环。
程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。

*/

/**
 * Definition for singly-linked list.
 */

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

    /*
    思路：
    如果两个链表有交点，则两个链表在交点后是共享所有结点
    假设链表 l1 的长度为 x，链表 l2 的长度为 y，x>y
    则可以肯定 l1 的前（x-y）一定没有交点
    之后同时遍历两个链表，找出交点
     */
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode aHead = headA;
        ListNode bHead = headB;
        //链表a的长度
        int lengthA = getLength(aHead);
        //链表b的长度
        int lengthB = getLength(bHead);
        //截去多余的结点
        while (lengthA > lengthB) {
            aHead = aHead.next;
            lengthA--;
        }
        while (lengthB > lengthA) {
            bHead = bHead.next;
            lengthB--;
        }
        //查找交点
        while (aHead != null && bHead != null) {
            if (aHead == bHead)
                return aHead;
            aHead = aHead.next;
            bHead = bHead.next;
        }
        return null;
    }
    /*
    求链表的长度
     */
    private static int getLength(ListNode head) {
        ListNode headA = head;
        int length = 0;
        while (headA != null) {
            length++;
            headA = headA.next;
        }
        return length;
    }
    /*
    优化：
    主要思想还是通过同时遍历两个长度相同的链表，来找到结点
    两个链表l1 l2,但是通过两轮遍历来解决，第一轮p1到达结尾时，从p2的头结点出发，这样就抹除了长度差
    第二轮用来找交点
     */
    public static ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        if (headA == null || headB == null)
            return null;
        ListNode aHead = headA, bHead = headB;
        while (aHead != bHead) {
            aHead = (aHead == null) ? headB : aHead.next;
            bHead = (bHead == null) ? headA : bHead.next;
        }
        return aHead;
    }
}
