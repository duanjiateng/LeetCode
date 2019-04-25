## LeetCode-019-删除链表的倒数第N个节点

### 1. 题目：

删除链表的倒数第N个节点

给定一个链表，删除链表的倒数第 *n* 个节点，并且返回链表的头结点。

**示例：**

```
给定一个链表: 1->2->3->4->5, 和 n = 2.

当删除了倒数第二个节点后，链表变为 1->2->3->5.
```

**说明：**

给定的 *n* 保证是有效的。

**进阶：**

你能尝试使用一趟扫描实现吗？

### 2. 解题：

使用双指针`right`,`left`，进行一次遍历。

先让`right`指针走`n`步，然后让`right`和`left`同时出发，当`right`到达结尾时，`left`的下一个节点就是要删除节点。

需要注意，当删除的是头结点情况。

#### 代码：

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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        ListNode right = head;
        ListNode left = head;
        //right先走n步
        while (n-- > 0) {
            right = right.next;
        }
        
        //删除头节点
        if (right == null)
            return head.next;
        
        //找到需要删除节点的前一个节点
        while (right.next != null) {
            right = right.next;
            left = left.next;
        }
		//删除节点       
        left.next = left.next.next;
        
        return head;
    }
}
```

