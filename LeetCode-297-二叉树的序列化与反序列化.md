## LeetCode-297-二叉树的序列化与反序列化

### 1. 题目：

二叉树的序列化与反序列化

序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。

请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。

**示例:** 

```
你可以将以下二叉树：

    1
   / \
  2   3
     / \
    4   5

序列化为 "[1,2,3,null,null,4,5]"
```

**提示:** 这与 LeetCode 目前使用的方式一致，详情请参阅 [LeetCode 序列化二叉树的格式](https://leetcode-cn.com/faq/#binary-tree)。你并非必须采取这种方式，你也可以采用其他的方法解决这个问题。

**说明:** 不要使用类的成员 / 全局 / 静态变量来存储状态，你的序列化和反序列化算法应该是无状态的。

### 2. 解题：

简单来说，序列化就是将`TreeNode`转化成`String`，反序列化就是将`String`转化成`TreeNode`。

通过题目我们可以知道，序列化是将二叉树通过层序遍历的顺序得到的，同时空树节点用`null`来表示。

反序列化，需要我们通过`String`来将每一个节点找出来，这时候就要分割`String`，然后得到每一个树节点。

对于层序遍历，我们需要用到`Queue`。

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
public class Codec {

   // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null)
            return null;
        StringBuilder result = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                result.append(node.val + ",");
                queue.offer(node.left);
                queue.offer(node.right);
            } else {
                result.append("null,");
            }
        }
        return result.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0)
            return null;
        String[] strs = data.split(",");
        //　判断根节点是否为空
        if (strs[0].equals("null"))
            return null;
        int index = 1;
        TreeNode root = new TreeNode(Integer.valueOf(strs[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            //　不是null，给左侧
            if (!strs[index].equals("null")) {
                node.left = new TreeNode(Integer.valueOf(strs[index]));
                queue.offer(node.left);
            }
            index++;
            //　不是null，给右侧
            if (!strs[index].equals("null")) {
                node.right = new TreeNode(Integer.valueOf(strs[index]));
                queue.offer(node.right);
            }
            index++;
        }
        return root;
    }
}
```

