## LeetCode-215-数组中第k个最大元素

### １．题目

数组中第k个最大元素

在未排序的数组中找到第 **k** 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。

**示例 1:**

```
输入: [3,2,1,5,6,4] 和 k = 2
输出: 5
```

**示例 2:**

```
输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
输出: 4
```

**说明:**

你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。

### ２．解题

​	这个题的大体思路很简单，将数组排序，从大到小排，则结果就是第k个元素（从小到大排，结果就是倒数第k个元素）。因此这道题就是考察数组排序算法。

​	这里选择了传统快排算法。

#### 	代码：

```java
class Solution {
    public int findKthLargest(int[] nums, int k) {
        quickSort(nums, 0, nums.length-1);
        return nums[nums.length - k];
    }
    public static void quickSort(int[] nums, int start, int end) {
        if (start >= end) 
            return;
        //左指针
        int left = start;
        //右指针
        int right = nums.length - 1;
        //基准数
        int key = nums[start];   
        while (left < right) {
            /*从right出发
              在右边找出一个比key小的数
            */
            while (key <= nums[right] && right > left) 
                right--;
            //这时找到比key小的数，或者left >= right
            if (left < right) {
                //将比key小的数放在前边
                nums[left] = nums[right]; 
                left++;
            }
            /*从前往后出发
              找到比key大的一个数
            */
            while (nums[left] <= key && left < right) {
                left++;
            }
            //这时找到比key大的数，或者left >= right
            if (left < right) {
                nums[right] = nums[left];
                right--;
            }
        }
        //跳出循环时，left == right，找到key的位置
        nums[left] = key;
        //以key为中心，将当前数组分为两部分
        quickSort(nums, start, left-1);
        quickSort(nums, left+1, end);
    }
}
```

### ３．优化

​	虽然传统快排比一般的排序，但是远不及Java中`Arrays`中的优化快排算法快。

​	只为AC的答案（手动滑稽）！

```java
class Solution {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length-k];
    }
}
```

