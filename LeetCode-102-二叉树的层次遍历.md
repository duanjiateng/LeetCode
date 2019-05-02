## LeetCode-102-二叉树的层次遍历

### 1. 题目：

二叉树的层次遍历

给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。

例如:
给定二叉树: `[3,9,20,null,null,15,7]`,

```
    3
   / \
  9  20
    /  \
   15   7
```

返回其层次遍历结果：

```
[
  [3],
  [9,20],
  [15,7]
]
```

### 2. 解题：

使用**队列**进行层次遍历。

需要注意的是，使用`num`和`next`来进行每层的标记。

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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        if (root == null) 
            return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int num = 1;
        int next = 0;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            num--;
            list.add(node.val);
            if (node.left != null) {
                queue.add(node.left);
                next++;
            }
            if (node.right != null) {
                queue.add(node.right);
                next++;
            }
            if (num == 0) {
                num = next;
                next = 0;
                res.add(list);
                list = new ArrayList<>();
            }
        }
        return res;
    }
}
```

