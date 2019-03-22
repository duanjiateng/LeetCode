## LeetCode-041-FirstMissingPositive

### １．题目：

缺失的第一个正数

给定一个未排序的整数数组，找出其中没有出现的最小的正整数。

**示例 1:**

```
输入: [1,2,0]
输出: 3
```

**示例 2:**

```
输入: [3,4,-1,1]
输出: 2
```

**示例 3:**

```
输入: [7,8,9,11,12]
输出: 1
```

**说明:**

你的算法的时间复杂度应为O(*n*)，并且只能使用常数级别的空间。

### ２．解题：

​	本题是要未出现的最小正数，要知道最小，就需要涉及到排序问题．

​	首先将数组排序，然后我们假设最小缺失正数为`result = 1`．

​	判断数组的最大值是否为正数，然后遍历数组，如果有`result == nums[i]`则`result++;`如果`result < nums[i]`则直接返回`result`．

#### 	代码：

```java
class Solution {
    public int firstMissingPositive(int[] nums) {
        int result = 1;
        if (nums == null && nums.length == 0)
            return result;
        Arrays.sort(nums);
        if (nums[nums.length - 1] <= 0)
            return result;
        for (int i = 0; i < nums.length; i++) {
            if (result == nums[i]) {
                result++;
            } else if (result < nums[i]) {
                return result;
            }
        }
        return result;
    }
}
```

