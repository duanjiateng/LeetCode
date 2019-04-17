## LeetCode-217-存在重复

### 1. 题目：

给定一个整数数组，判断是否存在重复元素。

如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。

**示例 1:**

```
输入: [1,2,3,1]
输出: true
```

**示例 2:**

```
输入: [1,2,3,4]
输出: false
```

**示例 3:**

```
输入: [1,1,1,3,3,4,3,2,4,2]
输出: true
```

### 2. 解题：

#### 解法一：

主要就是找有没有重复的元素，因此我们可以使用`HashMap`，将元素作为`key`，用来判断`map`中是否存在该元素，若存在则返回`true`，若不存在则将该元素加入`map`。

#### 代码：

```java
class Solution {
    public boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length == 0)
            return false;
        
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                return true;
            }
            map.put(nums[i], null);
        }
        
        return false;
    }
}
```

#### 解法二：

先排序，然后找相同的。将元素排列好，判断相邻两个元素是否相同。

#### 代码：

```java
class Solution {
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-1; i++) {
            if (nums[i] == nums[i+1])
                return true;
        }
        return false;
    }
}
```

