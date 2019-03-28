## LeetCode-033-搜索旋转排序数组

### 1. 题目：

搜索旋转排序数组

假设按照升序排序的数组在预先未知的某个点上进行了旋转。

( 例如，数组 `[0,1,2,4,5,6,7]` 可能变为 `[4,5,6,7,0,1,2]` )。

搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 `-1` 。

你可以假设数组中不存在重复的元素。

你的算法时间复杂度必须是 *O*(log *n*) 级别。

**示例 1:**

```
输入: nums = [4,5,6,7,0,1,2], target = 0
输出: 4
```

**示例 2:**

```
输入: nums = [4,5,6,7,0,1,2], target = 3
输出: -1
```

### 2. 解题：

​	一个升序数组被旋转后其实是变成两个升序数组，所以我们可以使用二分法查找。总体思路有两步：

​	a) 找到旋转点，也就是最小的点`min`，使用二分法查找。

​	b) 通过旋转点将数组分为两个升序数组，分别使用二分法查找。

#### 	代码：

```java
class Solution {
     public int search(int[] nums, int target) {
        //最小值的索引
        int min = -1;
        int left = 0;
        int right = nums.length - 1;
        //用来找最小值
        while (left < right) {
            //使用位运算除２
            int mid = left + ((right - left) >>> 1);
            //如果mid < right说明最小值在右边
            if (nums[mid] < nums[right]) {
                right = mid;
            } else {
                //说明最小值在左边
                left = mid + 1;
            }
        }
        min = left;
        int indexLeft = BinarySearch(nums, 0, min - 1, target);
        int indexRight = BinarySearch(nums, min, nums.length-1, target);
        return (indexLeft == -1) ? indexRight : indexLeft;

    }
	//使用二分法查找目标值
    public int BinarySearch(int[] nums, int start, int end, int key) {
        int left = start;
        int right = end;
        while (left <= right) {
            int mid = left + ((right - left) >>> 1);
            if (nums[mid] == key) {
                return mid;
            } else if (nums[mid] < key) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
```

### 3.  注意：

​	我们需要注意一点：`<<, >>, >>>`的优先级**低于**`+, -`。

​	因此我们用位运算来计算除以2的运算需要写成`left + ((right - left) >>> 1)`不能写成`left + (right - left) >>> 1`。