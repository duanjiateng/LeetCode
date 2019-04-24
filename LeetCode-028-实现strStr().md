## LeetCode-028-实现strStr()

### 1. 题目：

实现strStr()

实现 [strStr()](https://baike.baidu.com/item/strstr/811469) 函数。

给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  **-1**。

**示例 1:**

```
输入: haystack = "hello", needle = "ll"
输出: 2
```

**示例 2:**

```
输入: haystack = "aaaaa", needle = "bba"
输出: -1
```

**说明:**

当 `needle` 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。

对于本题而言，当 `needle` 是空字符串时我们应当返回 0 。这与C语言的 [strstr()](https://baike.baidu.com/item/strstr/811469) 以及 Java的 [indexOf()](https://docs.oracle.com/javase/7/docs/api/java/lang/String.html#indexOf(java.lang.String)) 定义相符。

### 2. 解题：

利用`substring()`和`equals()`来实现。截取字符串并且用来比较。

#### 代码：

```java
class Solution {
    public int strStr(String haystack, String needle) {
        if (needle == null || needle.length() == 0) 
            return 0;
        
        if (haystack == null || haystack.length() == 0) 
            return -1;
        
        int lenHay = haystack.length();
        int lenNeed = needle.length();
        
        for (int i = 0; i < lenHay; i++) {
            if (lenHay - i < lenNeed)
                return -1;
            
            if (haystack.substring(i, i+lenNeed).equals(needle))
                return i;
        }
        
        return -1;
    }
}
```

