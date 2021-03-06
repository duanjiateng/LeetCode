## LeetCode-160-相交链表

### 1. 题目：

相交链表

编写一个程序，找到两个单链表相交的起始节点。

如下面的两个链表**：**

[![img](https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/12/14/160_statement.png)](https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/12/14/160_statement.png)

在节点 c1 开始相交。

 

**示例 1：**

[![img](https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/12/14/160_example_1.png)](https://assets.leetcode.com/uploads/2018/12/13/160_example_1.png)

```
输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
输出：Reference of the node with value = 8
输入解释：相交节点的值为 8 （注意，如果两个列表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
```

 

**示例 2：**

[![img](https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/12/14/160_example_2.png)](https://assets.leetcode.com/uploads/2018/12/13/160_example_2.png)

```
输入：intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
输出：Reference of the node with value = 2
输入解释：相交节点的值为 2 （注意，如果两个列表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [0,9,1,2,4]，链表 B 为 [3,2,4]。在 A 中，相交节点前有 3 个节点；在 B 中，相交节点前有 1 个节点。
```

 

**示例 3：**

[![img](https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/12/14/160_example_3.png)](https://assets.leetcode.com/uploads/2018/12/13/160_example_3.png)

```
输入：intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
输出：null
输入解释：从各自的表头开始算起，链表 A 为 [2,6,4]，链表 B 为 [1,5]。由于这两个链表不相交，所以 intersectVal 必须为 0，而 skipA 和 skipB 可以是任意值。
解释：这两个链表不相交，因此返回 null。
```

**注意：**

- 如果两个链表没有交点，返回 `null`.
- 在返回结果后，两个链表仍须保持原有的结构。
- 可假定整个链表结构中没有循环。
- 程序尽量满足 O(*n*) 时间复杂度，且仅用 O(*1*) 内存。

### 2. 解题：

​	如果两个链表有交点，则两个链表在交点后是共享所有结点。

​	假设链表`l1`的长度为`x`，链表`l2`的长度为`y`，`(x>y)`，
​	则可以肯定`l1`的前`(x-y)`一定没有交点；此时从`l1`的第`x-y`节点开始，两链表有相同的长度，同时遍历两个链表，找出交点。

#### 	代码：

```java
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
```

### 3. 优化：

​	我们会发现上边的代码很冗长，需要计算链表长度，还要截掉多余的节点。但是实际上我们最主要的目的是可以“同步”遍历两个链表，也就是让两个链表长度相等。

​	我们知道`l1_length + l2_length == l2_length + l1_length`。所以，我们可以两轮遍历，来得到`l1+l2`。

​	两个链表`l1`、` l2`，通过两轮遍历，第一轮`l1`到达结尾时，从`l2`的头结点出发，同样的`l2`到达结尾时，从`l1`的头结点出发。这样就抹除了长度差；第二轮用来找交点。

#### 	代码：

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
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
```

