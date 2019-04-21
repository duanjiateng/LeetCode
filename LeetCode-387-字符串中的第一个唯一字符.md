## LeetCode-387-字符串中的第一个唯一字符

### 1. 题目：

字符串中的第一个唯一字符

给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。

**案例:**

```
s = "leetcode"
返回 0.

s = "loveleetcode",
返回 2.
```

**注意事项：**您可以假定该字符串只包含小写字母。

### 2. 解题：

使用一个大小为`26`的数组来存字符第一次出现的索引。

如果重复出现则将数组对应的值置为`-２`．

然后将数组排序，找出最小的非`-1`和`-2`，就为结果。

#### 代码：

```java
class Solution {
    public int firstUniqChar(String s) {
        int[] chars = new int[26];
        Arrays.fill(chars, -1);
        
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (chars[ch - 'a'] == -1 && chars[ch - 'a'] != -2) {
                chars[ch - 'a'] = i;
            } else {
                chars[ch - 'a'] = -2;
            }
        }
        
        Arrays.sort(chars);
        for (int i = 0; i < 26; i++) {
            if (chars[i] != -2 && chars[i] != -1)
                return chars[i];
        }
        
        return -1;
    }
}
```

### 3. 优化：

利用`indexOf`和`lastIndexOf`.

#### 代码：

```java

class Solution {
    public int firstUniqChar(String s) {
        int result = -1;
        
        for(char c = 'a'; c <= 'z'; c++ ){
            // indexOf 返回此字符串中第一次出现处的索引
            // lastIndexOf 返回指定字符在此字符串中最后一次出现处的索引
            int idx = s.indexOf(c);
            
            // 第一次出现的索引id与最后一次出现的值相同，则满足题目要求
            if(idx != -1 && idx == s.lastIndexOf(c)){
                result = (result == -1) ? idx : Math.min(result , idx);
            }
        }
        return result;
    }
}

```

