## LeetCode-22-GenerateParenthesis

### １．题目

生成括号

给出 *n* 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且**有效的**括号组合。

例如，给出 *n* = 3，生成结果为：

```
[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]
```

### ２．解题：

​	需要找出所有解，所以我们可以使用**回溯法**，使用递归找出所有合适的解．

> #### 回溯（Backtracking）算法思路：
>
> 在当前局面下，你有若干种选择。逐一尝试每一种选择。 
> 如果发现某种选择行不通（违反了某些限定条件）就返回； 
> 如果某种选择试到最后发现是正确解，就将其加入解集。
>
> 使用递归解决问题需要明确以下三点： **选择 (Options)** 、 **限制 (Restraints)** 和 **结束条件 (Termination)** 。即“ORT原则”。

​	来回到本题：

​	**选择**：两个选择：加左括号，加右括号．

​	**限制**：１．如果左括号用完，则不能添加左括号．

​		　２．始终保证左括号＜＝右括号，这样才能保证括号匹配．因此当左右括号一样多	时，不能添加右括号．

​	**结束条件**：当左右括号都为零时，则表示找到一个解．

#### 	代码：

```java
class Solution {
    public List<String> generateParenthesis(int n) {
        //解集
        List<String> result = new ArrayList<>();
        if(n <= 0) {
            return result;
        }
        genParenthesis(result, "", n, n);
        return result;
    }

	/**
     * @param list 解集
     * @param s 当前解
     * @param leftNum 左括号数
     * @param rightNum 右括号数
     */
    private void genParenthesis(List<String> list, String s, int leftNum, int rightNum) {
        //如果左右括号同时为0时，说明找到一个解并加入解集
        if (leftNum == 0 && rightNum == 0) {
            list.add(s);
            return;
        }
		//如果左括号＞零，则加一个左括号，继续递归
        if (leftNum > 0) {
            genParenthesis(list, s+"(", leftNum-1, rightNum);
        }
        //如果左括号＜右括号，则加一个右括号，继续递归
        if (leftNum < rightNum) {
            genParenthesis(list, s+")", leftNum, rightNum-1);
        }

    }
}
```

