## LeetCode-242-有效的字母异位词

### 1. 题目：

有效的字母异位词

给定两个字符串 *s* 和 *t* ，编写一个函数来判断 *t* 是否是 *s* 的一个字母异位词。

**示例 1:**

```
输入: s = "anagram", t = "nagaram"
输出: true
```

**示例 2:**

```
输入: s = "rat", t = "car"
输出: false
```

**说明:**
你可以假设字符串只包含小写字母。

**进阶:**
如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？

### 2. 解题：

利用ASCLL码，将字符串转换成数组进行排序。

然后判断两个数组的每个元素是否相等即可。

#### 代码：

```java
class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;
        
        char[] chS = s.toCharArray();
        char[] chT = t.toCharArray();
        
        Arrays.sort(chS);
        Arrays.sort(chT);
        
        for (int i = 0; i < s.length(); i++) {
            if (chS[i] != chT[i])
                return false;
        }
        
        return true;
    }
}
```

### 3. 优化：

利用一个额外空间`char[26]`，遍历第一个字符串，用数组记录每个字符的次数。

再遍历另一个字符串，对于出现的字符，数组中记录的次数减一。

最后遍历数组每一个元素是否为`0`.

#### 代码：

```java
class Solution {
    public boolean isAnagram(String s, String t) {
        
        if (s.length() != t.length())
            return false;
        
        int[] ch = new int[26];
        
        for (int i = 0; i < s.length(); i++) {
            ch[s.charAt(i) - 'a']++;
        }
        
        for (int i = 0; i < t.length(); i++) {
            ch[t.charAt(i) - 'a']--;
        }
        
        for (int i = 0; i < 26; i++) {
            if (ch[i] != 0)
                return false;
        }
        
        
        return true;
    }
}
```