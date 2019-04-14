## LeetCode-116-填充每个节点的下一个右侧节点指针

### 1. 题目：

填充每个节点的下一个右侧节点指针

给定一个**完美二叉树**，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：

```
struct Node {
  int val;
  Node *left;
  Node *right;
  Node *next;
}
```

填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 `NULL`。

初始状态下，所有 next 指针都被设置为 `NULL`。

 

**示例：**

![img](https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2019/02/15/116_sample.png)

```
输入：{"$id":"1","left":{"$id":"2","left":{"$id":"3","left":null,"next":null,"right":null,"val":4},"next":null,"right":{"$id":"4","left":null,"next":null,"right":null,"val":5},"val":2},"next":null,"right":{"$id":"5","left":{"$id":"6","left":null,"next":null,"right":null,"val":6},"next":null,"right":{"$id":"7","left":null,"next":null,"right":null,"val":7},"val":3},"val":1}

输出：{"$id":"1","left":{"$id":"2","left":{"$id":"3","left":null,"next":{"$id":"4","left":null,"next":{"$id":"5","left":null,"next":{"$id":"6","left":null,"next":null,"right":null,"val":7},"right":null,"val":6},"right":null,"val":5},"right":null,"val":4},"next":{"$id":"7","left":{"$ref":"5"},"next":null,"right":{"$ref":"6"},"val":3},"right":{"$ref":"4"},"val":2},"next":null,"right":{"$ref":"7"},"val":1}

解释：给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点，如图 B 所示。
```

 

**提示：**

- 你只能使用常量级额外空间。
- 使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。

### 2. 解题：

其实这个题的核心依旧是**层次遍历**。对于每一层从左到右依次连接，最右节点链接`NUll`.

用`Queue`来存节点，用`num`和`next`来记录每层节点数。

对于每层的节点处理分两种情况：最有一个节点和非最后一个节点。

#### 代码：

```java
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;
    public Node() {}
    public Node(int _val,Node _left,Node _right,Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/
class Solution {
    public Node connect(Node root) {
        if (root == null)
            return null;
        //用来存放节点
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        // 当前层节点数，初始化为第一层
        int num = 1;
        // 下一层节点数
        int next = 0;
        // 开始层序遍历
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            num--;
            //添加左节点
            if (node.left != null) {
                queue.offer(node.left);
                next++;
            }
            //添加右节点
            if (node.right != null) {
                queue.offer(node.right);
                next++:
            }
            //不是当前层最后一个，指向queue的第一个
            if (num != 0 && !queue.isEmpty()) {
                node.next = queue.peek();
            }
            //当前层最后一个指向null
            if (num == 0) {
                node.next = null;
                num = next;
                next = 0;
            }
        }
        return root;
    }
}
```

