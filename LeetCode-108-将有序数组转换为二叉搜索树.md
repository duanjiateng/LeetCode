## LeetCode-108-将有序数组转换为二叉搜索树

### 1. 题目：

将有序数组转换为二叉搜索树

将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。

本题中，一个高度平衡二叉树是指一个二叉树*每个节点* 的左右两个子树的高度差的绝对值不超过 1。

**示例:**

```
给定有序数组: [-10,-3,0,5,9],

一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：

      0
     / \
   -3   9
   /   /
 -10  5
```

### 2. 解题：

二叉搜索树的中序遍历就是一个有序的数组。因此这个题就是中序遍历的逆过程。

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
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0)
            return null;
        
        return inverseInorder(nums, 0, nums.length-1);
    }
    
    public TreeNode inverseInorder(int[] nums, int left, int right) {
        if (left > right)
            return null;
        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = inverseInorder(nums, left, mid-1);
        root.right = inverseInorder(nums, mid+1, right);
        return root;
    }
    
}
```

