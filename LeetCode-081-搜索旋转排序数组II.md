## LeetCode-081-搜索旋转排序数组II

### 1. 题目：

搜索旋转排序数组II

假设按照升序排序的数组在预先未知的某个点上进行了旋转。

( 例如，数组 `[0,0,1,2,2,5,6]` 可能变为 `[2,5,6,0,0,1,2]` )。

编写一个函数来判断给定的目标值是否存在于数组中。若存在返回 `true`，否则返回 `false`。

**示例 1:**

```
输入: nums = [2,5,6,0,0,1,2], target = 0
输出: true
```

**示例 2:**

```
输入: nums = [2,5,6,0,0,1,2], target = 3
输出: false
```

**进阶:**

- 这是 [搜索旋转排序数组](https://duanjiateng.github.io/2019/03/28/LeetCode-033/#more) 的延伸题目，本题中的 `nums`  可能包含重复元素。
- 这会影响到程序的时间复杂度吗？会有怎样的影响，为什么？

### 2. 解题：

​	和**搜索旋转排序数组**不同的是出现了重复元素，而且可能重复元素是旋转点，因此使用二分法查找旋转点就会变得复杂。

​	最简单的方法直接遍历一遍，看是否存在`target`.

#### 	代码：

```java
class Solution {
    public boolean search(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (target == nums[i]) {
                return true;
            }
        }   
        return false;
    }
}
```

### 3. 优化：

​	对与遍历进行优化，实际上仍然是遍历一遍，但是是从尾向前遍历，这样如果大于尾部元素，则有可能结果在数组前半部分，这时从头遍历，可以提高效率。

#### 	代码：

```java
class Solution {
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return false;
        if (nums.length == 1) return target == nums[0];
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            if (nums[right] == target || nums[left] == target) return true;
            if (nums[right] < target && nums[left] > target) return false;
            if (nums[right] < target) {
                left++;
            } else {
                right--;
            }
        }
        return false;
    }
}
```

