## LeetCode-034-在排序数组中查找元素的第一个和最后一个位置

### １．题目：

在排序数组中查找元素的第一个和最后一个位置

给定一个按照升序排列的整数数组 `nums`，和一个目标值 `target`。找出给定目标值在数组中的开始位置和结束位置。

你的算法时间复杂度必须是 *O*(log *n*) 级别。

如果数组中不存在目标值，返回 `[-1, -1]`。

**示例 1:**

```
输入: nums = [5,7,7,8,8,10], target = 8
输出: [3,4]
```

**示例 2:**

```
输入: nums = [5,7,7,8,8,10], target = 6
输出: [-1,-1]
```

### ２．解题：

​	这是一个排好序的数组，我们只需要查找数组中是否存在`target`，如果存在返回该元素的第一个位置和最后一个位置。

​	查找很简单，我们使用二分查找，时间复杂度`O(log n)`。

​	我们得到索引后分别找到其第一个位置和最后一个位置的索引。

​	需要注意边界问题（`index = 0`和`index = nums.length-1`）.

#### 	代码：

```java

class Solution {
    public static int[] searchRange(int[] nums, int target) {
        //result[0]记录开始位置，result[1]记录结束位置
        int index = -1;
        int low = 0;
        int high = nums.length - 1;
		//二分法查找targrt是否在数组中
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                index = mid;
                break;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
		//target不在数组中
        if (index == -1) {
            return new int[]{-1, -1};
        }
        int start = index;
        int end = index;
        //寻找target的第一个位置
    	while (start > 0) {
            if (nums[start] == nums[start - 1]) {
                start--;
            } else {
                break;
            }
        }
        //寻找targrt的最后一个位置
        while (end < nums.length - 1) {
            if (nums[end] == nums[end + 1]) {
                end++;
            } else {
                break;
            }
        }
        return new int[]{start, end};
    }
}
```

