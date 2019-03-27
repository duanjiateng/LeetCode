## LeetCode-334-递增的三元子序列

### １．题目：

递增的三元子序列

给定一个未排序的数组，判断这个数组中是否存在长度为 3 的递增子序列。

数学表达式如下:

> 如果存在这样的 *i, j, k,*  且满足 0 ≤ *i* < *j* < *k* ≤ *n*-1，
> 使得 *arr[i]* < *arr[j]* < *arr[k]* ，返回 true ; 否则返回 false 。

**说明:** 要求算法的时间复杂度为 O(*n*)，空间复杂度为 O(*1*) 。

**示例 1:**

```
输入: [1,2,3,4,5]
输出: true
```

**示例 2:**

```
输入: [5,4,3,2,1]
输出: false
```

### ２．解题：

​	我们需要找到一个三元递增序列，因为我们每次只能遍历一个变量`nums[i]`，所以我们需要其他两个变量`first`和`second`，如果满足`first < second < nums[i]`，则找到满足题意的子序列。

#### 	代码：

```java
class Solution {
    public boolean increasingTriplet(int[] nums) {
        if (nums.length < 3) {
            return false;
        }
        int first = Integer.MAX_VALUE, second = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num < first) {
                first = num;
            } else if (num > first && num < second) {
                second = num;
            } else if (num > second) {
                return true;
            }
        }
        return false;
    }
}
```