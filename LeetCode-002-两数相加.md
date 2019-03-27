## LeetCode-002-两数相加

### １．题目：

两数相加

给出两个 **非空** 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 **逆序** 的方式存储的，并且它们的每个节点只能存储 **一位** 数字。

如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。

您可以假设除了数字 0 之外，这两个数都不会以 0 开头。

**示例：**

```
输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
输出：7 -> 0 -> 8
原因：342 + 465 = 807
```

### ２．解题：

​	这个题大致思路很简单，就是将两个链表每个节点取出来相加作为一个新的节点，同时需要考虑进位的问题。节点相加大致有这三种情况：

- `l1`和`l2`都有节点；

- `l1`有节点，`l2`为`null`；或者`l1`有节点，`l2`为`null`。

- `l1`和`l2`都没有节点，但是有进位。

  因此我们为了方便处理，如果一个链表没有节点时，就给该链表一个`0`节点。

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
                  //第一次相加
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
  ```

  