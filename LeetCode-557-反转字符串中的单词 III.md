## LeetCode-557-反转字符串中的单词 III

### 1. 题目：

反转字符串中的单词 III

给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。

**示例 1:**

```
输入: "Let's take LeetCode contest"
输出: "s'teL ekat edoCteeL tsetnoc" 
```

**注意：**在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。

### 2 . 解题：

- 将字符串按照`" "`分割成`String[]`；
- 对`String[]`中的每一个`String`进行反转；
- 拼接成一个`String`;

### 代码：

```java
class Solution {
    public String reverseWords(String s) {
        String[] results = s.split(" ");
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < results.length; i++) {
            res.append(reverseWord(results[i]) + " ");
        }
        return res.toString().trim();
    }
    
    /* 将一个单词翻转 */ 
    private static String reverseWord(String s) {
        StringBuilder str = new StringBuilder();
        int len = s.length();
        for(int i = len-1; i >= 0; i--) {
            str.append(s.charAt(i));
        }
        return str.toString();
    }
}
```

