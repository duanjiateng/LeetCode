## LeetCode-328-奇偶链表

### 1. 题目：

奇偶链表

给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。

请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。

**示例 1:**

```
输入: 1->2->3->4->5->NULL
输出: 1->3->5->2->4->NULL
```

**示例 2:**

```
输入: 2->1->3->5->6->4->7->NULL 
输出: 2->3->6->7->1->5->4->NULL
```

**说明:**

- 应当保持奇数节点和偶数节点的相对顺序。
- 链表的第一个节点视为奇数节点，第二个节点视为偶数节点，以此类推。

### 2. 解题：

- 使用一个计数器`count`用来记录奇偶。
- 使用两个指针`oddHead`，`evenHead`来记录奇偶节点。
- 将所有奇数位上的节点依次连接，将偶数上的节点依次连接。
- 最后将奇数的最后一个结点和偶数的第一个结点相连。

```java
    public static ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null )
            return head;
        //奇数的头结点
        ListNode oddHead = null;
        //奇数的当前结点
        ListNode oddCur = null;
        //偶数的头结点
        ListNode evenHead = null;
        //偶数的当前结点
        ListNode evenCur = null;
        //计数器
        int count = 0;
        while (head != null) {
            count++;
            //奇数结点
            if ((count % 2) != 0) {
                if (oddCur == null) {
                    oddCur = head;
                    oddHead = oddCur;
                } else {
                    oddCur.next = head;
                    oddCur = oddCur.next;
                }
            } else {    //偶数节点
                if (evenCur == null) {
                    evenCur = head;
                    evenHead = evenCur;
                } else {
                    evenCur.next = head;
                    evenCur = evenCur.next;
                }
            }
            head = head.next;
        }
        evenCur.next = null;
        oddCur.next = evenHead;
        return oddHead;
    }

```

### 3. 优化：

​	奇偶结点不需要使用计数器．使用`node.next`和`node.next.next`。

```java
	public static ListNode oddEvenList1(ListNode head) {
        if (head == null)
            return null;
        //当前奇数结点，当前偶数结点，偶数头结点
        ListNode odd = head, even = head.next, evenHead = even;
        while (even != null && even.next != null) {
            odd.next = odd.next.next;
            odd = odd.next;
            even.next = even.next.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
```

