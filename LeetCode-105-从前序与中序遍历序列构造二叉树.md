## LeetCode-105-从前序与中序遍历序列构造二叉树

### 1. 题目：

从前序与中序遍历序列构造二叉树

根据一棵树的前序遍历与中序遍历构造二叉树。

**注意:**
你可以假设树中没有重复的元素。

例如，给出

```
前序遍历 preorder = [3,9,20,15,7]
中序遍历 inorder = [9,3,15,20,7]
```

返回如下的二叉树：

```
    3
   / \
  9  20
    /  \
   15   7
```

### 2. 解题：

我们知道，前序遍历是先遍历根节点，再遍历左子树，最后遍历右子树，因此我们知道前序遍历的顺序中第一个一定是根节点；

而中序遍历是先遍历左子树，再遍历根节点，最后遍历右子树，因此在中序遍历的顺序中找到根节点，则根节点前方就是左子树的中序遍历顺序，根节点后方就是右子树的遍历顺序。

简单来说：

前序遍历顺序　＝　根节点　＋　左子树的前序遍历　＋　右子树的前序遍历；

中序遍历顺序　＝　左子树的中序遍历　＋　根节点　＋　右子树的中序遍历；

那么前序遍历用来找“根节点”，中序遍历用来找左子树的个数和右子树的个数。

```
过程：
第一步：通过前序遍历找到根结点（pre[0]）
第二步：在中序遍历中找到根结点的索引
第三步：在in[]中，根据根结点索引的左右可以找到左右子树的个数
第四步：在pre[]中找到左右子树的pre[]
第五步：重复上述步骤
```



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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null)
            return null;
        if (preorder.length * inorder.length == 0)
            return null;
        if (preorder.length != inorder.length)
            return null;

        return inorderAndPreorderBuild(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);

    }
    private TreeNode inorderAndPreorderBuild(int[] pre, int preBegin, int preEnd, int[] in, int inBegin, int inEnd) {
        if (preBegin > preEnd || inBegin > inEnd)
            return null;
        //根结点就是前序遍历的第一个结点
        TreeNode root = new TreeNode(pre[preBegin]);
		//只有一个节点
        if (preBegin == preEnd)
            return root;
        //在中序遍历中查找根结点的位置
        int index = -1;
        for (int i = inBegin; i <= inEnd; i++) {
            if (pre[preBegin] == in[i]) {
                index = i;
                break;
            }
        }
        //左子数结点个数
        int leftNum = index - inBegin;
        //右子树结点个数
        int rightNum = inEnd - index;
		//找根节点的左子树
        root.left = inorderAndPreorderBuild(pre, preBegin+1, preBegin+leftNum, in, inBegin, index-1);
		//找根节点的右子树
        root.right = inorderAndPreorderBuild(pre, preEnd-rightNum+1, preEnd, in, index+1, inEnd);
        return root;
    } 
    
}
```

