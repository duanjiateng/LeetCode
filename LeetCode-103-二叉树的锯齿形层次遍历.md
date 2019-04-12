## LeetCode-103-二叉树的锯齿形层次遍历

### 1. 题目：

给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。

例如：
给定二叉树 `[3,9,20,null,null,15,7]`,

```
    3
   / \
  9  20
    /  \
   15   7
```

返回锯齿形层次遍历如下：

```
[
  [3],
  [20,9],
  [15,7]
]
```

### 2. 解题：

首先是二叉树的层次遍历，我们知道使用**队列**。

但是需要注意的是：

​	ａ）锯齿状，先从左往右，再从右往左进行下一层遍历，因此我们需要知道每一层的遍历方向。使用一个`boolean`变量`leftToRight`。

​	ｂ）每一层元素使用一个`ArrayList`存放。因此我们需要知道何时一层开始，何时一层结束。使用两个变量，当前层数量`num`，下一层数量`next`，`num == 0`时，表示当前层结束。

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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        //结果
        List<List<Integer>> result = new ArrayList<>();
        if (root == null)
            return result;
        //一层的值
        List<Integer> list = new LinkedList<>();
        //用来存放一层结点的队列
        Queue<TreeNode> queue = new LinkedList<>();
        //leftToRight从左到右
        boolean leftToRight = true;
        queue.offer(root);
        //当前层中结点个数
        int num = 1;
        //下一层中结点个数
        int next = 0;
        //队列为空表示结束
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            num--;
            //加入左节点
            if (node.left != null) {
                queue.offer(node.left);
                next++;
            }
            //加入右节点
            if (node.right != null) {
                queue.offer(node.right);
                next++;
            }
            //判断遍历方向
            if (leftToRight) {
                list.add(node.val);
            } else {
                ((LinkedList<Integer>) list).addFirst(node.val);
            }
            //一层结束
            if (num == 0) {
                num = next;
                next = 0;
                leftToRight = !leftToRight;
                result.add(list);
                list = new LinkedList<>();
            }
        }
        return result;
    }
}
```

