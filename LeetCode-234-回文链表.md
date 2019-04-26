## LeetCode-234-回文链表

### 1. 题目：

回文链表

请判断一个链表是否为回文链表。

**示例 1:**

```
输入: 1->2
输出: false
```

**示例 2:**

```
输入: 1->2->2->1
输出: true
```

**进阶：**
你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？

### 2.  解题：

利用快慢指针找到中点；

然后将链表的后半部分进行翻转；

判断两个部分的链表每个节点值是否相同。

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
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) 
            return true;
        ListNode slow = head;
        ListNode fast = head;
        
        //找中点
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        //翻转链表
        slow = reverseList(slow.next);
        //判断是否回文
        while (slow != null) {
            if (slow.val != head.val)
                return false;
            slow = slow.next;
            head = head.next;
        }
        return true;
    }
    //翻转函数
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

