## LeetCode-005-最长回文子串

### １．题目：

最长回文子串

给定一个字符串 `s`，找到 `s` 中最长的回文子串。你可以假设 `s` 的最大长度为 1000。

**示例 1：**

```
输入: "babad"
输出: "bab"
注意: "aba" 也是一个有效答案。
```

**示例 2：**

```
输入: "cbbd"
输出: "bb"
```

### ２，解题：

​	我们寻找回文子串使用中心扩展法。从每一个字符出发，判断两边是否为回文。但是我们需要考虑奇数还是偶数问题，奇数时，当前字符串是中心字符串；偶数时中心字符是中间字符对(相当于当前字符为中心字符对的左边)。

```java
class Solution {
    public String longestPalindrome(String s) {
        int len = s.length();
        if (len <= 1)
            return s;
        //结果
        String result = "";
        //临时字符串
        String str;
        for(int i = 0; i < len; i++) {
            //奇数
            str = findPalindrome(s, i, i);
            if (str.length() > result.length())
                result = str;
            //偶数
            str = findPalindrome(s, i, i+1);
            if (str.length() > result.length())
                result = str;
        }
        return result;
    }
    
    private String findPalindrome(String s, int left, int right) {
        int len = s.length();
        int l = left;
        int r = right;
        while (l >= 0 && r < len && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return s.substring(l+1, r);
    }
}
```

