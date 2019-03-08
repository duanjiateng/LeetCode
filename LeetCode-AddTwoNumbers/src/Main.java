/*
两数相加

给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。

如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。

您可以假设除了数字 0 之外，这两个数都不会以 0 开头。

示例：

输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
输出：7 -> 0 -> 8
原因：342 + 465 = 807
 */

import java.util.List;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class Main {

    public static void main(String[] args) {
	// write your code here
    }

    /*
    整体思想就是，遍历两个链表，将两个结点相加
    但是，需要注意满１０进１和两链表长度不一致时的问题；
    考虑较长链表和进位的和，以及最后一位如果有进位则需要增加一个结点．
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //进位
        int carry = 0;

        //head头结点
        ListNode head = null;

        //tmp临时结点
        ListNode tmp = null;

        //两链表长度不一致时，将短链表用０结点补全
        while (l1 != null || l2 != null || carry != 0) {
            int num = carry + (l1 == null ? 0 : l1.val) + ( l2 == null ? 0 : l2.val);
            ListNode node  = new ListNode(num % 10);
            carry = num / 10;

            if (tmp == null) {
                tmp = node;
                head = tmp;
            } else {
                tmp.next = node;
                tmp = tmp.next;
            }

            l1 = (l1 == null ? null : l1.next);
            l2 = (l2 == null ? null : l2.next);
        }

        return head;
        
    }
}
