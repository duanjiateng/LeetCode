## LeetCode-300-最长上升子序列

### 1. 题目：

Longest Increasing Subsequence

给定一个无序的整数数组，找到其中最长上升子序列的长度。

**示例:**

```
输入: [10,9,2,5,3,7,101,18]
输出: 4 
解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
```

**说明:**

- 可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
- 你算法的时间复杂度应该为 O(*n2*) 。

**进阶:** 你能将算法的时间复杂度降低到 O(*n* log *n*) 吗?

### 2. 解题：

我们要注意几点：

- 上升子序列是“严格上升”，是`num[i] < num[j]`不能等于。
- 上升子序列不需要保证连续，只要满足大小即可。

我们使用动态规划，使用数组`dp[i]`来存放`num[i]`作为子序列最后一个元素的子序列最大个数。自底向上(从`nums[0]`到`nums[len-1]`)，计算每一个元素的作为最后一个元素的最大上升子序列的长度。

我们知道公式为：满足`j < j && nums[j] < nums[i]`时，`dp[i] = max{1 + dp[j]}`。

#### 	代码：

```java
class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        if (nums.length == 1)
            return 1;
        int len = nums.length;
        int[] dp = new int[len];
        Arrays.fill(dp, 1);
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i])
                    dp[i] = Math.max(dp[i], 1+dp[j]);
            }
        }
        Arrays.sort(dp);
        return dp[len-1];
    }
}
```

