## LeetCode-055-跳跃游戏

### 1. 题目：

跳跃游戏

给定一个非负整数数组，你最初位于数组的第一个位置。

数组中的每个元素代表你在该位置可以跳跃的最大长度。

判断你是否能够到达最后一个位置。

**示例 1:**

```
输入: [2,3,1,1,4]
输出: true
解释: 从位置 0 到 1 跳 1 步, 然后跳 3 步到达最后一个位置。
```

**示例 2:**

```
输入: [3,2,1,0,4]
输出: false
解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
```

### 2. 解题：

​	使用贪心算法，使用`max`来记录能够跳跃的最远距离`max{max, i + nums[i]}`。

​	当`max >= nums.length`是说明可以到达末尾；

​	当`i > max`说明到不了当前位置，则返回`false`。

#### 	代码：

```java
class Solution {
    public boolean canJump(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > max) 
                return false;
            max = (max > (nums[i] + i)) ? max : nums[i] + i;
            
            if (max >= nums.length)
                return true;
        }
        return true;
    }
}
```

