## LeetCode-151-翻转字符串里的单词

### 1. 题目：

给定一个字符串，逐个翻转字符串中的每个单词。 

**示例 1：**

```
输入: "the sky is blue"
输出: "blue is sky the"
```

**示例 2：**

```
输入: "  hello world!  "
输出: "world! hello"
解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
```

**示例 3：**

```
输入: "a good   example"
输出: "example good a"
解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
```

**说明：**

- 无空格字符构成一个单词。
- 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
- 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。

**进阶：**

请选用 C 语言的用户尝试使用 *O*(1) 额外空间复杂度的原地解法。

### 2. 解题：

使用`trim()`将字符串的收尾空格去掉；

使用`split()`将字符串按空格分成`String[]`(注意，空格会被分成"")

使用`StringBuilder`拼接单词。

#### 代码：

```java
class Solution {
    public String reverseWords(String s) {

        String[] strs = s.trim().split(" ");
        if (strs.length == 0)
            return "";

        StringBuilder result = new StringBuilder();
        int len = strs.length;
        result.append(strs[len - 1]);
        for (int i = len - 2; i >= 0; i--) {
            if (!strs[i].equals("")) {
                result.append(" ");
                result.append(strs[i]);
            }
        }
        return result.toString();  
    }
}
```

