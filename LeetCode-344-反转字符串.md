## LeetCode-344-反转字符串

### 1. 题目：

反转字符串

编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 `char[]` 的形式给出。

不要给另外的数组分配额外的空间，你必须**原地修改输入数组**、使用 O(1) 的额外空间解决这一问题。

你可以假设数组中的所有字符都是 [ASCII](https://baike.baidu.com/item/ASCII) 码表中的可打印字符。

**示例 1：**

```
输入：["h","e","l","l","o"]
输出：["o","l","l","e","h"]
```

**示例 2：**

```
输入：["H","a","n","n","a","h"]
输出：["h","a","n","n","a","H"]
```

### 2. 解题：

原地翻转，就是使用交换即可。

#### 代码：

```java
class Solution {
    public void reverseString(char[] s) {
        if (s == null || s.length <= 1)
            return;
        int len = s.length;
        for (int i = 0; i < len/2; i++) {
            char temp = s[i];
            s[i] = s[len-1-i];
            s[len-i-1] = temp;
        }
    }
}
```

