## LeetCode-189-旋转数组

### 1. 题目：

旋转数组

给定一个数组，将数组中的元素向右移动 *k* 个位置，其中 *k* 是非负数。

**示例 1:**

```
输入: [1,2,3,4,5,6,7] 和 k = 3
输出: [5,6,7,1,2,3,4]
解释:
向右旋转 1 步: [7,1,2,3,4,5,6]
向右旋转 2 步: [6,7,1,2,3,4,5]
向右旋转 3 步: [5,6,7,1,2,3,4]
```

**示例 2:**

```
输入: [-1,-100,3,99] 和 k = 2
输出: [3,99,-1,-100]
解释: 
向右旋转 1 步: [99,-1,-100,3]
向右旋转 2 步: [3,99,-1,-100]
```

**说明:**

- 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
- 要求使用空间复杂度为 O(1) 的原地算法。

### 2. 解题：

使用三次倒置，

第一次整个数组倒置；

以第k个元素为中心将数组分为两部分，

第二次前部分数组倒置；

第三次后部分数组倒置。

主要注意，当`k > nums.length`时，需要对`k`进行`k = k % nums.length`处理。

```
假设数组    0 1 2 3 4 5 6
k = 2
结果       5 6 0 1 2 3 4

以length-k为界限，将数组分为两部分 0 1 2 3 4 ， 5 6
现将前部分倒置 4 3 2 1 0 5 6
再将后部分倒置 4 3 2 1 0 6 5
将整个部分倒置 5 6 0 1 2 3 4
```

#### 代码：

```java
class Solution {
    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k == 0)
            return;
        k = k % nums.length;
        
        reverse(nums, 0, nums.length-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, nums.length-1);
    }
    
    private void reverse(int[] nums, int start, int end) {
        int left = start;
        int right  = end;
        while(left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
}
```

### 3. 其他解法：

```java
/**
 * 每次移动1个位置
 * 移动k次
 * */
public void rotate(int[] nums, int k) {
    int temp, kk;
    kk = k%nums.length;
    for (int i = 0; i < kk; i++) {
        temp = nums[nums.length-1];
        for (int j = nums.length-1; j > 0; j--) {
            nums[j] = nums[j-1];
        }
        nums[0] = temp;
    }
}

/**
 * 新建一个等大数组，用空间换取时间
 * */
public void rotate2(int[] nums, int k) {
    int[] new_nums = new int[nums.length];
    for (int i = 0; i < nums.length; i++) {
        new_nums[(i+k)%nums.length] = nums[i];
    }

    for (int i = 0; i < nums.length; i++) {
        nums[i] = new_nums[i];
    }
}
```