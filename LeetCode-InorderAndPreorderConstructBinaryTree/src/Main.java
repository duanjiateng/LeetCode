/*
 从前序与中序遍历序列构造二叉树
 根据一棵树的前序遍历与中序遍历构造二叉树。

 注意:
 你可以假设树中没有重复的元素。

 例如，给出

 前序遍历 preorder = [3,9,20,15,7]
 中序遍历 inorder = [9,3,15,20,7]
 返回如下的二叉树：

    3
   / \
  9  20
    /  \
   15   7
 */

/**
 * Definition for a binary tree node.
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class Main {

    public static void main(String[] args) {
	// write your code here
        int[] pre = new int[]{1, 2};
        int[] in = new int[]{2, 1};
        buildTree(pre, in);
    }

    /*
    * 思路：
    * 前序遍历可以确定根结点
    * 中序遍历可以找到该根结点的左右子树
    * 第一步：通过前序遍历找到根结点（pre[0]）
    * 第二步：在中序遍历中找到根结点的索引
    * 第三步：在in[]中，根据根结点索引的左右可以找到左右子树的个数
    * 第四步：在pre[]中找到左右子树的pre[]
    * 第五步：重复上述步骤
    * */
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null)
            return null;
        if (preorder.length * inorder.length == 0)
            return null;
        if (preorder.length != inorder.length)
            return null;
        return inorderAndPreorderBuild(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);

    }
    private static TreeNode inorderAndPreorderBuild(int[] pre, int preBegin, int preEnd, int[] in, int inBegin, int inEnd) {
        if (preBegin > preEnd || inBegin > inEnd)
            return null;
        //根结点就是前序遍历的第一个结点
        TreeNode root = new TreeNode(pre[preBegin]);
        //判断是否为叶子结点
        if (preBegin == preEnd)
            return root;
        //在中序遍历中查找根结点的位置
        int index = -1;
        for (int i = inBegin; i <= inEnd; i++) {
            if (pre[preBegin] == in[i]) {
                index = i;
            }
        }
        //左子数结点个数
        int leftNum = index - inBegin;
        //右子树结点个数
        int rightNum = inEnd - index;
        //根结点的左子数
        root.left = inorderAndPreorderBuild(pre, preBegin+1, preBegin+leftNum, in, inBegin, index-1);
        //根结点的右子树
        root.right = inorderAndPreorderBuild(pre, preEnd-rightNum+1, preEnd, in, index+1, inEnd);
        return root;
    }

}
