## LeetCode-88-合并两个有序数组

### 1. 题目：

合并两个有序数组

给定两个有序整数数组 *nums1* 和 *nums2*，将 *nums2* 合并到 *nums1* 中*，*使得 *num1* 成为一个有序数组。

**说明:**

- 初始化 *nums1* 和 *nums2* 的元素数量分别为 *m* 和 *n*。
- 你可以假设 *nums1* 有足够的空间（空间大小大于或等于 *m + n*）来保存 *nums2* 中的元素。

**示例:**

```
输入:
nums1 = [1,2,3,0,0,0], m = 3
nums2 = [2,5,6],       n = 3

输出: [1,2,2,3,5,6]
```

### 2. 解题：

合并两个数组，我们选择从后往前，这样只需要赋值不需要交换。

情况一：当`nums2`为`null`时（`n == 0`），直接返回`nums1`；

情况二：当`nums1`为`null`时（`m == 0`），直接返回`nums2`；

情况三：两个数组从后往前比较，将较大的放在后边。当`nums2`都放入后，那么直接返回；当`nums1`都放入后，将`nums2`覆盖到`nums1`之前的。

#### 代码：

```java
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0)
            return;
        if (m == 0) {
            for (int i = 0; i < n; i++) {
                nums1[i] = nums2[i];
            }
            return;
        }
        int p1 = m - 1;
        int p2 = n - 1;
        int len = m + n - 1;
        
        while (p2 >= 0 || p1 >= 0) {
            //nums2都放入，直接返回
            if (p2 < 0)
                return;
            //判断nums1是否都放入
            int num1 = (p1 < 0) ? Integer.MIN_VALUE : nums1[p1];
            nums1[len--] = (num1 <= nums2[p2]) ? nums2[p2--] : nums1[p1--];
            
        }
    }
}
```

