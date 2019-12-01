## LeetCode-014-最长公共前缀

### 1. 题目：

最长公共前缀

编写一个函数来查找字符串数组中的最长公共前缀。

如果不存在公共前缀，返回空字符串 `""`。

**示例 1:**

```
输入: ["flower","flow","flight"]
输出: "fl"
```

**示例 2:**

```
输入: ["dog","racecar","car"]
输出: ""
解释: 输入不存在公共前缀。
```

**说明:**

所有输入只包含小写字母 `a-z` 。

### 2. 解题：

利用两次循环。

以第一个字符串开始，判断其第`i`字符与数组中其他字符串的第`i`字符是否相等。

#### 代码：

```java
class Solution {
    public String longestCommonPrefix(String[] strs) {
        
        if (strs == null || strs.length == 0)
            return "";
        
        StringBuilder strb = new StringBuilder();
        for (int i = 0; i < strs[0].length(); i++) {
            char ch = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i < strs[j].length() && ch == strs[j].charAt(i)){
                    continue;
                }
                return strb.toString();
            }
            strb.append(ch);
        }
        return strb.toString();
    }
}
```

