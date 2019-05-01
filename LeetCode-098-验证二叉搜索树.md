## LeetCode-098-验证二叉搜索树

### 1. 题目：

验证二叉搜索树

给定一个二叉树，判断其是否是一个有效的二叉搜索树。

假设一个二叉搜索树具有如下特征：

- 节点的左子树只包含**小于**当前节点的数。
- 节点的右子树只包含**大于**当前节点的数。
- 所有左子树和右子树自身必须也是二叉搜索树。

**示例 1:**

```
输入:
    2
   / \
  1   3
输出: true
```

**示例 2:**

```
输入:
    5
   / \
  1   4
     / \
    3   6
输出: false
解释: 输入为: [5,1,4,null,null,3,6]。
     根节点的值为 5 ，但是其右子节点值为 4 。
```

### 2. 解题：

使用中序遍历的思想，二叉搜索树的中序遍历是从小到大的有序序列。因此我们按照中序遍历的顺序，判断前一个是否小于下一个即可。

要注意`int`越界问题。

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
    //最小值
    private long last = Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        if (root == null)
            return true;
        //判断左子树是否为BST    
        if (isValidBST(root.left)) {
            //判断中序是否有序
            if (last < root.val) {
                last = root.val;
                //判断右子树是否为BST
                return isValidBST(root.right);
            }
        }
        return false;
    }
}
```

