## LeetCode-150-逆波兰表达式求值

### 1. 题目：

逆波兰表达式求值

根据[逆波兰表示法](https://baike.baidu.com/item/%E9%80%86%E6%B3%A2%E5%85%B0%E5%BC%8F/128437)，求表达式的值。

有效的运算符包括 `+`, `-`, `*`, `/` 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。

**说明：**

- 整数除法只保留整数部分。
- 给定逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。

**示例 1：**

```
输入: ["2", "1", "+", "3", "*"]
输出: 9
解释: ((2 + 1) * 3) = 9
```

**示例 2：**

```
输入: ["4", "13", "5", "/", "+"]
输出: 6
解释: (4 + (13 / 5)) = 6
```

**示例 3：**

```
输入: ["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"]
输出: 22
解释: 
  ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
= ((10 * (6 / (12 * -11))) + 17) + 5
= ((10 * (6 / -132)) + 17) + 5
= ((10 * 0) + 17) + 5
= (0 + 17) + 5
= 17 + 5
= 22
```

### 2. 解题：

主要使用`Stack`来存数字，遇到运算符时，则将栈顶的两个元素弹出，进行相应的运算。

**注意：**要注意两个数字的顺序，尤其是减法和除法。

使用一个`HashMap`来存放运算符，便于判断当前字符串是数字还是运算符。

#### 代码：

```java
class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        Map<String, Character> map = new HashMap<>();
        map.put("+",'+');
        map.put("-",'-');
        map.put("/",'/');
        map.put("*",'*');
        for (int i = 0; i < tokens.length; i++) {
            if (!map.containsKey(tokens[i])) {
                 stack.push(Integer.valueOf(tokens[i]));
                 continue;
            }
            int num2 = stack.pop();
            int num1 = stack.pop();
            switch(tokens[i]){
                case "+" : {
                    stack.push(num1 + num2);
                    break;
                }
                case "-" : {
                    stack.push(num1 - num2);
                    break;
                }
                case "*" : {
                    stack.push(num1 * num2);
                    break;
                }
                case "/" : {
                    stack.push(num1 / num2);
                    break;
                }
            }
            
            /*if (tokens[i].equals("+")) {
                stack.push(num1 + num2);
            } else if (tokens[i].equals("-")) {
                stack.push(num1 - num2);
            } else if (tokens[i].equals("*")) {
                stack.push(num1 * num2);
            } else {
                stack.push(num1 / num2);
            }*/
        }
        return stack.pop();
    }
}
```

