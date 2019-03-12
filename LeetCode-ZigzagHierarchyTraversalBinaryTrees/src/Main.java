/*
二叉树的锯齿形层次遍历
给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。

例如：
给定二叉树 [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
返回锯齿形层次遍历如下：

[
  [3],
  [20,9],
  [15,7]
]
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
    }

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
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            num--;
            if (node.left != null) {
                queue.offer(node.left);
                next++;
            }
            if (node.right != null) {
                queue.offer(node.right);
                next++;
            }
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
