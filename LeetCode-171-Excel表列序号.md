## LeetCode-171-Excel表列序号

### 1. 题目：

Excel表列序号

给定一个Excel表格中的列名称，返回其相应的列序号。

例如，

```
    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28 
    ...
```

**示例 1:**

```
输入: "A"
输出: 1
```

**示例 2:**

```
输入: "AB"
输出: 28
```

**示例 3:**

```
输入: "ZY"
输出: 701
```

### 2. 解题：

这个题类似与“26进制”，每26进一位。有两种思路，首先我们看从高位到低位。

- 以次取除字符串中的字符，判断当前字符串在第几位。
- 使用`pow(26.0, 位数)`求出其当前位置的值，例如十进制中，百位-10^2，个位-10^1。
- 依次相加就可以求解。

#### 代码：

```java
class Solution {
    public int titleToNumber(String s) {
        if (s == null || s.length() == 0)
            return 0;
        int res = 0;
        int len = s.length();
        for (int i = 0; i < len; i++) {
            double num = Math.pow(26.0, (double)len - i - 1);
            res += (s.charAt(i) - 'A' + 1) * num;
        }
        return (int)res;
        
    }
}
```

### 3. 其他解法：

思想不变，但是从低位向高位出发，不使用`pow()`函数，用一个`count`来代替。

#### 代码：

```java
class Solution {
    public int titleToNumber(String s) {
        if (s == null || s.length() == 0)
            return 0;
        int res = 0;
        int count = 1;
        int len = s.length();
        char[] ch = s.toCharArray();
        for (int i = len-1; i >= 0; i--) {
            count *= (i == len -1) ? count : 26;
            res += (ch[i] - 'A' + 1) * count;
        }
        return res;
        
    }
}
```

