## LeetCode-003-LongestSubstringWithoutRepeatingCharacters

### 1.解题：

无重复字符的最长子串

给定一个字符串，请你找出其中不含有重复字符的 **最长子串** 的长度。

**示例 1:**

```
输入: "abcabcbb"
输出: 3 
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
```

**示例 2:**

```
输入: "bbbbb"
输出: 1
解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
```

**示例 3:**

```
输入: "pwwkew"
输出: 3
解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
```

### 2.解题：

​	使用滑动窗口`[start, end)`来记录子字符串的长度。

​	定义两个指针`start`和`end`，用它们来记录最长字串的开始和结束。

​	使用`Set`来记录字串，用来判断是否重复。

​	由于只需要记录最长字串的长度，当遇见非重复的字符时，`end++`，并且将新字符add到`Set`中；遇到重复字串时，`start++`，并且将`Set`中重复字符`remove`．

#### 	代码：

```java
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int start = 0;
        int end = 0;
        int result = 0;
        int len = s.length();
        Set<Character> set = new HashSet<>();
        while (start < len && end < len){
            //字符重复
            if (set.contains(s.charAt(end))) {
                set.remove(s.charAt(start++));
            } else {
                //字符不重复
                set.add(s.charAt(end++));
                //找出最大的
                result = Math.max(result, end - start);
            }
        }
        return result;
    }
}
```
