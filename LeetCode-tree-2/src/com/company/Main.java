package com.company;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 *  验证二叉搜索树
 *
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 *
 * 假设一个二叉搜索树具有如下特征：
 *
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * 示例 1:
 *
 * 输入:
 *     2
 *    / \
 *   1   3
 * 输出: true
 * 示例 2:
 *
 * 输入:
 *     5
 *    / \
 *   1   4
 *      / \
 *     3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 *      根节点的值为 5 ，但是其右子节点值为 4 。
 * */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class Main {

    public static void main(String[] args) {
	// write your code here
    }

    /**
     * 二叉搜索树的中序遍历的结果是从小到大的排序
     * 根据排序结果来判断是否为二叉搜索树
     * 实际上是，比较当前结点与前一个遍历的结点的大小
     * */
    public boolean isValidBST(TreeNode root) {
        ArrayList<TreeNode> pre = new ArrayList<>();
        pre.add(null);
        return inorder(root, pre);
    }

    private boolean inorder(TreeNode root, ArrayList<TreeNode> pre) {
        if (root == null)
            return true;
        boolean left = inorder(root.left, pre);
        if (pre.get(0) != null && root.val < pre.get(0).val) {
            return false;
        }
        pre.set(0, root);

        return left && inorder(root.right, pre);
    }

    
}
