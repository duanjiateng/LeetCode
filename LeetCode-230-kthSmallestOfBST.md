## LeetCode-230-kthSmallestOfBST

### １．题目

二叉搜索树中第K小的元素

给定一个二叉搜索树，编写一个函数 `kthSmallest` 来查找其中第 **k** 个最小的元素．

**说明：**
你可以假设 k 总是有效的，1 ≤ k ≤ 二叉搜索树元素个数．

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

### ２．解答：

​	我们需要找到二叉搜索树的第k个小的数，说明这是需要找到一个从小到大的顺序，但是二叉搜索树实际上已经是一个排序．

> 二叉搜索树的性质：若它的左子树不空，则左子树上所有结点的值均小于它的根结点的值； 若它的右子树不空，则右子树上所有结点的值均大于它的根结点的值； 它的左、右子树也分别为二叉搜索树．

​	所以我们对二叉搜索树进行中序遍历，就可以得到一个从小到大的顺序，这样就能直接找到第k个小的值．

​	代码：

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
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        inorder(list, root);
        return list.get(k-1);
    }
    /**
    * 二叉树的中序遍历
    */
    private void inorder(List<Integer> list, TreeNode root) {
        if (root.left != null) {
            inorder(list, root.left);
        }
        list.add(root.val);
        if (root.right != null) {
            inorder(list, root.right);
        }
        return;
    }
}
```

### ３．优化

​	对于上边的方法，我们发现一个问题：我们只需要第K小的元素，但是我们使用了`List`是保存所有元素的值，造成了空间上的浪费．如果只用一个变量来保存第k小的值．就可以节省空间．

​	我们需要一个计数器`count`用来记录元素的个数，当`count == k`时，说明找到第k小的元素；

​	

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
        }
        if (root.right != null) {
            inorder(k, root.right);
        }
        return;
    }
}
```

