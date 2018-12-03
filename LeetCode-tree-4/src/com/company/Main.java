package com.company;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *  二叉树的层次遍历
 *
 * 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
 *
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其层次遍历结果：
 *
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
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
     * 按层遍历
     * 将每一层数据存放在一个List中
     * */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists = new LinkedList<>();
        if (root == null) {
            return lists;
        }
        List<Integer> list = new LinkedList<>();
        list.add(root.val);
        lists.add(list);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while ( !queue.isEmpty() ) {
            int n = queue.size();
            List<Integer> list1 = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();
                if ( node.left != null ) {
                    queue.offer(node.left);
                    list1.add(node.left.val);
                }
                if ( node.right != null ) {
                    queue.offer(node.right);
                    list1.add(node.right.val);
                }
            }
            if (list1.size() != 0)
                lists.add(list1);
        }
        return lists;
    }
    
    /**
     * 使用递归
     * */
    public List<List<Integer>> levelOrder1(TreeNode root) {
        List<List<Integer>> lists = new LinkedList<>();
        if (root == null)
            return lists;
        fun(lists, 0, root);
        return lists;
    }

    private void fun(List<List<Integer>> lists, int level, TreeNode root) {
        if (root == null)
            return;
        if (lists.size() == level) {
            List<Integer> list = new LinkedList<>();
            list.add(root.val);
            lists.add(list);
        } else {
            lists.get(level).add(root.val);
        }

        fun(lists, level+1, root.left);
        fun(lists, level+1, root.right);

    }


}
