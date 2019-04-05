## LeetCode-094-中序遍历二叉树

### 1. 题目：

给定一个二叉树，返回它的*中序* 遍历。

**示例:**

```
输入: [1,null,2,3]
   1
    \
     2
    /
   3

输出: [1,3,2]
```

**进阶:** 递归算法很简单，你可以通过迭代算法完成吗？

### 2. 解题：

> 中序遍历：中序遍历（LDR）是二叉树遍历的一种，也叫做中根遍历、中序周游。在二叉树中，中序遍历首先遍历左子树，然后访问根结点，最后遍历右子树。

使用递归算法，对每一个节点，都先遍历其左子树，再遍历其本身，最后遍历其右子树。

注意：解集需要使用一个集合存储。

#### 代码：

```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        inoerderFun(list, root);
        return list;
    }
    private void inoerderFun(List<Integer> list, TreeNode root) {
        if (root == null)
            return;
        inoerderFun(list, root.left);
        list.add(root.val);
        inoerderFun(list, root.right);
    }
}
```

### 3. 进阶：

对于二叉树的遍历，我们也可以使用非递归的形式。

非递归遍历，我们需要使用`Stack`。

从根节点出发，不为空时，将根节点入栈，然后遍历左子树；

当根节点为空时，弹栈（相当与访问根节点），遍历弹出节点的右子树；

若根节点为空，此时栈为空，则遍历完成。

#### 代码：

```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {        
                list.add(stack.peek().val);
                node = stack.pop().right;
            }
        }
        return list;
    }
}
```

