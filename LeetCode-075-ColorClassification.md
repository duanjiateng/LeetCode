## LeetCode-075-ColorClassification

### １．题目：

颜色分类

给定一个包含红色、白色和蓝色，一共 *n* 个元素的数组，**原地**对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。

此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。

**注意:**
不能使用代码库中的排序函数来解决这道题。

**示例:**

```
输入: [2,0,2,1,1,0]
输出: [0,0,1,1,2,2]
```

**进阶：**

- 一个直观的解决方案是使用计数排序的两趟扫描算法。
  首先，迭代计算出0、1 和 2 元素的个数，然后按照0、1、2的排序，重写当前数组。
- 你能想出一个仅使用常数空间的一趟扫描算法吗？

### ２．解题

​	只为AC(手动滑稽)，因为题目要求颜色排序，颜色用数字代替，顺序正好从小到大，这实际上就是一道数组排序题，因此排序算法都可以使用，这里选择最简单的**冒泡排素**．

#### 	代码：

```java
class Solution {
    public void sortColors(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
    }
}
```

### ３．优化：

​	采用三路快排的思想，因为有`0, 1, 2`，三个数，如果我们让`0`到达最左边，让`2`到达最右边，那么`1`自然最在中间部分．

​	首先我们需要两个指针：`left`：用来指到最左边0的下一个位置；`right`：用来指到最右边２的上一个位置．

​	然后遍历数组，如果发现`nums[i] == 0`，则将`left`和`i`的值交换并且`left++`；如果发现`nums[i] == 2`，则将`right`和`i`的值交换并且`right--`，此时要注意交换后的数是什么．

​	要注意，`i`最多取到`right`的位置．

#### 	代码：

```java
class Solution {
    public void sortColors(int[] nums) {
        //左指针
        int left = 0;
        //右指针
        int right = nums.length-1;
        
        for (int i = 0; i <= right; i++) {
            if (nums[i] == 0) {
                swap(nums, i, left);
                left++;
            } else if(nums[i] == 2) {
                swap(nums, i, right);
                right--;
                //要判断交换过来的数是什么
                i--;
            }
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
```

