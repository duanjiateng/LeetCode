## LeetCode-125-验证回文串

### 1. 题目：

验证回文字符串

给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。

**说明：**本题中，我们将空字符串定义为有效的回文串。

**示例 1:**

```
输入: "A man, a plan, a canal: Panama"
输出: true
```

**示例 2:**

```
输入: "race a car"
输出: false
```

### 2. 解题：

首先要对字符串进行处理：

1. 大小写统一
2. 除去多余字符，只保留数字和字母。

使用双指针，进行判断是否回文。

#### 代码：

```java
class Solution {
    public boolean isPalindrome(String s) {
        if (s == null)
            return true;
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if ( (ch >= '0' && ch <= '9') || (ch >= 'a' && ch <= 'z')) {
                str.append(ch);
            } else if (ch >= 'A' && ch <= 'Z') {
                ch = (char)(ch + 32);
                str.append(ch);
            }

        }
        
        char[] ch = str.toString().toCharArray();
        int left = 0;
        int right = ch.length-1;

        while (left < right) {
            if (ch[left] != ch[right])
                return false;
            left++;
            right--;
        }
        return true;
    }
}
```

