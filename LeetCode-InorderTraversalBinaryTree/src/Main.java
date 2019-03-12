/*
中序遍历二叉树

给定一个二叉树，返回它的中序 遍历。

示例:

输入: [1,null,2,3]
   1
    \
     2
    /
   3

输出: [1,3,2]
进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(4);

        root.right = node2;
        node2.left = node3;
        System.out.println(inorderTraversal2(root));

    }

    /*
    * 使用递归方法
    * */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        inoerderFun(list, root);
        return list;
    }
    private void inoerderFun(List<Integer> list, TreeNode root) {
        if (root == null)
            return;

        inoerderFun(list, root.left);
        list.add(root.val);
        inoerderFun(list, root.right);

    }
    /*
    * 使用非递归方式中序遍历二叉树
    * 使用一个栈来存放结点，从根结点开始，对于任意的结点V，先判断V是否为Null，若不为空，则将V入栈并将其左结点L变成当前结点V；若为空则，则
    * 将栈顶弹出并访问该结点，将其右结点R置为V，重复上述结果，直至当前结点为空并且栈为空，遍历结束．
    * */
    public static List<Integer> inorderTraversal2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                list.add(stack.peek().val);
                node = stack.pop().right;
            }
        }
        return list;
    }

}
