package com.company;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树的最大深度
 *
 *
 * 给定一个二叉树，找出其最大深度。
 *
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最大深度 3 。
 * 
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
        TreeNode root = new TreeNode(1);
        TreeNode root1 = new TreeNode(1);
        TreeNode root2 = new TreeNode(1);
        TreeNode root3 = new TreeNode(1);
        TreeNode root4 = new TreeNode(1);
        root.left = root1;
        root.right = root2;
        root1.left = root3;
        root3.right = root4;
        System.out.println(maxDepth1(root));
    }

    /**
     * 使用深度优先遍历
     * 递归的应用
     */
    public static int maxDepth(TreeNode root) {
        return (root == null) ? 0 : 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    /**
     * 进行层遍历，数一共有多少层
     */
    public static int maxDepth1(TreeNode root) {
        int depth = 0;
        if (root == null)
            return depth;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            depth++;
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();
                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
            }
        }
        return depth;
    }
}