## LeetCode-230-二叉搜索树中第K小的元素

### 1. 题目：

二叉搜索树中第K小的元素

给定一个二叉搜索树，编写一个函数 `kthSmallest` 来查找其中第 **k** 个最小的元素。

**说明：**
你可以假设 k 总是有效的，1 ≤ k ≤ 二叉搜索树元素个数。

**示例 1:**

```
输入: root = [3,1,4,null,2], k = 1
   3
  / \
 1   4
  \
   2
输出: 1
```

**示例 2:**

```
输入: root = [5,3,6,2,4,null,null,1], k = 3
       5
      / \
     3   6
    / \
   2   4
  /
 1
输出: 3
```

**进阶：**
如果二叉搜索树经常被修改（插入/删除操作）并且你需要频繁地查找第 k 小的值，你将如何优化 `kthSmallest` 函数？

### 2. 解题：

二叉搜索树的中序遍历的结果就是从小到大的有序顺序。因此我们要找到第k小的元素，那就是中序遍历第k个节点的值。

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
    private int result = 0;
    private int count = 0;
    public int kthSmallest(TreeNode root, int k) {
        inorder(k, root);
        return result;
    }
    
    private void inorder(int k, TreeNode root) {
        if (root == null)
            return;
        if (root.left != null) {
            inorder(k, root.left);
        }
        if (++count == k) {
            result = root.val;
            return;
        }
        if (root.right != null) {
            inorder(k, root.right);
        }
        return;
    }
}
```

