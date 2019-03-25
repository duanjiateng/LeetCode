## LeetCode-162-寻找峰值

### １．题目：

寻找峰值

峰值元素是指其值大于左右相邻值的元素。

给定一个输入数组 `nums`，其中 `nums[i] ≠ nums[i+1]`，找到峰值元素并返回其索引。

数组可能包含多个峰值，在这种情况下，返回任何一个峰值所在位置即可。

你可以假设 `nums[-1] = nums[n] = -∞`。

**示例 1:**

```
输入: nums = [1,2,3,1]
输出: 2
解释: 3 是峰值元素，你的函数应该返回其索引 2。
```

**示例 2:**

```
输入: nums = [1,2,1,3,5,6,4]
输出: 1 或 5 
解释: 你的函数可以返回索引 1，其峰值元素为 2；
     或者返回索引 5， 其峰值元素为 6。
```

**说明:**

你的解法应该是 *O*(*logN*) 时间复杂度的。

### ２．解题：

​	首先找峰值值类似于找最值（或者是局部最值）。因此我们可以看做找最大值，要满足 `O(logN)` 时间复杂度，我们可以使用二分法找最大值。

​	首先我们需要两个指针：`left`左指针和`right`右指针，`mid`为它们的中值。

​	满足条件`nums[mid] > nums[mid - 1] && mid[mid] > mid[mid + 1]`，就说明找到峰值；

​	当`nums[mid] < nums[mid + 1]`说明目前是在峰值的左坡，则峰值一定在`mid`的右边；

​	当`nums[mid] < nums[mid - 1]`说明目前是在峰值的右坡，则峰值一定在`mid`的左边；

​	此时并没有结束，由于出现了`mid - 1`和`mid + 1`，所以我们必须考虑边界问题，峰值问题是两边是无穷小，因此当我们遇到边界问题时，可以取`Integer.MIN_VALUE`。

#### 	代码：

```java
class Solution {
    public int findPeakElement(int[] nums) {
        if (nums.length <= 0 || nums == null) 
            return -1;
        if (nums.length == 1)
            return 0;
        int left = 0;
        int right = nums.length - 1;
        int mid;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (nums[mid] > ( mid - 1 >= 0 ? nums[mid-1] : Integer.MIN_VALUE ) && (nums[mid] > ( mid + 1 < nums.length ? nums[mid + 1] : Integer.MIN_VALUE))){
                return mid;
            } else if (nums[mid] < ( mid - 1 >= 0 ? nums[mid-1] : Integer.MIN_VALUE )) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
```

