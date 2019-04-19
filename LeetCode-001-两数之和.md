## LeetCode-001-两数之和

### 1. 题目：

两数之和

给定一个整数数组 `nums` 和一个目标值 `target`，请你在该数组中找出和为目标值的那 **两个** 整数，并返回他们的数组下标。

你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。

**示例:**

```
给定 nums = [2, 7, 11, 15], target = 9

因为 nums[0] + nums[1] = 2 + 7 = 9
所以返回 [0, 1]
```

### 2. 解题：

求两数之和`a + b = target`，实际上就是查找`a = target - b`，转换成找一个数的思想。

使用`HashMap`来解决查找问题，`key`用来存**数组中的元素**，`value`来存**元素的索引**。

我们使用**边插入边查找**：

遍历数组，检查`target - nums[i]`是否在`map`中，

如果在则返回结果；

如果不在则将该元素插入`map`中。

#### 代码：

```java
class Solution {
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length <= 1) {
            return null;
        }
        
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{i, map.get(target - nums[i])};
            } else {
                map.put(nums[i], i);
            }
        }
        
        return null;
        
    }
}
```

