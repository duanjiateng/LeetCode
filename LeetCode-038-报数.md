## LeetCode-038-报数

### 1. 题目：

 报数

报数序列是一个整数序列，按照其中的整数的顺序进行报数，得到下一个数。其前五项如下：

```
1.     1
2.     11
3.     21
4.     1211
5.     111221
```

`1` 被读作  `"one 1"`  (`"一个一"`) , 即 `11`。
`11` 被读作 `"two 1s"` (`"两个一"`）, 即 `21`。
`21` 被读作 `"one 2"`,  "`one 1"` （`"一个二"` ,  `"一个一"`) , 即 `1211`。

给定一个正整数 *n*（1 ≤ *n* ≤ 30），输出报数序列的第 *n* 项。

注意：整数顺序将表示为一个字符串。

**示例 1:**

```
输入: 1
输出: "1"
```

**示例 2:**

```
输入: 4
输出: "1211"
```

### 2. 解题：

首先，需要读懂题意：

报数：指的是　把当前字符串中，每个数字个个数报出

```
n = 1: 1       : 1个1             11
n = 2: 11      : 2个1             21
n = 3: 21      : 1个2,1个1        1211
n = 4: 1211    : 1个1,1个2,2个1    111221
```

`n`的值与`n-1`有关

所以每次都是从`１`开始

两个关键：当前数字，当前数字的个数

#### 代码：

```java
class Solution {
    public String countAndSay(int n) {
        //初始化第一个
        String str = "1";
        //从１开始，计算到n
        for (int i = 1; i < n; i++) {
            //用来判断当前计算完成
            int k = 0;
            //记录每一次计算的结果
            StringBuilder strB = new StringBuilder();
            while (k < str.length()) {
                //当前数字
                char ch = str.charAt(k);
                //记录当前字符的个数
                int count = 0;
                while (k < str.length() && ch == str.charAt(k)) {
                    count++;
                    k++;
                }
                strB.append(count);
                strB.append(ch);
            }
            str = strB.toString();
        }
        
        return str;
    }
}
```

