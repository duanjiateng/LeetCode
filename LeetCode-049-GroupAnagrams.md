## LeetCode-049-GroupAnagrams

### １．题目：

字谜分组

给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。

**示例:**

```
输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
输出:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]
```

**说明：**

- 所有输入均为小写字母。
- 不考虑答案输出的顺序。

### ２．解题：

​	这个题是要我们将有相同字母组成的单词分组，分组我们需要用到集合类，相同字母组成是分组的标准，也就是每一组的`key`．因此我们选择`Map`集合．

​	接下来我们需要找到每组唯一的`key`，因为是相同字母组成，如果我们给定一个字母排列顺序，这里选择ASCII码大小作为字母排列的顺序．

​	所以关键两步：

​	将String转化成char[]，利用数组的排序．

​	使用map(key,value)来存放排序后的字符串和List．

#### 	代码：

```java
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0)
            return new ArrayList<>();

        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String keyStr = String.valueOf(chars);
            if (!map.containsKey(keyStr)) {
                map.put(keyStr, new ArrayList<>());
            }
            map.get(keyStr).add(str);
        }
        return new ArrayList<List<String>>(map.values());       
    }
}
```

​	