## LeetCode-021-合并两个有序链表

### 1. 题目：

合并两个有序链表

将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 

**示例：**

```
输入：1->2->4, 1->3->4
输出：1->1->2->3->4->4
```

### 2. 解题：

首先，新建一个头节点，遍历`l1`和`l2`。

当`l1`和`l2`的当前节点都不为空时，比较两个节点，将小的放入`head`链表中；

当`l2`为空时，将`l1`剩余的节点放入`head`中；

当`l1`为空时，将`l2`剩余的节点放入`head`中；

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode cur = new ListNode(-1);
        ListNode head = cur;
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        
        while (cur1 != null && cur2 != null) {
            if (cur1.val <= cur2.val) {
                cur.next = cur1;
                cur1 = cur1.next;
            } else {
                cur.next = cur2;
                cur2 = cur2.next;
            }
            cur = cur.next;
        }
        
        cur.next = (cur1 == null) ? cur2 : cur1;
        
        return head.next;
    }
}
```