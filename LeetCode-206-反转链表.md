## LeetCode-206-反转链表

### 1. 题目：

反转链表

反转一个单链表。

**示例:**

```
输入: 1->2->3->4->5->NULL
输出: 5->4->3->2->1->NULL
```

**进阶:**
你可以迭代或递归地反转链表。你能否用两种方法解决这道题？

### 2. 解题：

#### 迭代解法：

主要思路就是，遍历原链表，将链表的每一个节点取出，放入新链表的头结点之前，作为新的头结点。

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
    public ListNode reverseList(ListNode head) {
        ListNode res = null;
        ListNode cur = head;
        
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = res;
            res = cur;
            cur = temp;
        }
        
        return res;
    }
}
```

#### 递归解法：

递归版本稍微复杂一些，其关键在于反向工作。假设列表的其余部分已经被反转，现在我该如何反转它前面的部分？假设列表为：n(1) → … → n(k-1) → n(k) → n(k+1) → … → n(m) → null

若从节点 n(k+1) 到 n(m) 已经被反转，而我们正处于 n(k)。

n(1) → … → n(k-1) → **n(k)** → n(k+1) ← … ← n(m)

我们希望 n(k+1) 的下一个节点指向 n(k)。

所以，

n(k).next.next = n(k);

要小心的是 n(1) 的下一个必须指向 null。如果你忽略了这一点，你的链表中可能会产生循环。如果使用大小为 2 的链表测试代码，则可能会捕获此错误。

#### 代码：

```java
public ListNode reverseList(ListNode head) {
    if (head == null || head.next == null) 
        return head;
    ListNode p = reverseList(head.next);
    head.next.next = head;
    head.next = null;
    return p;
}
```

