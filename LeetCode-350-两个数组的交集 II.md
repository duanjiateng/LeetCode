## LeetCode-350-两个数组的交集 II

### 1. 题目：

两个数组的交集 II

给定两个数组，编写一个函数来计算它们的交集。

**示例 1:**

```
输入: nums1 = [1,2,2,1], nums2 = [2,2]
输出: [2,2]
```

**示例 2:**

```
输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
输出: [4,9]
```

**说明：**

- 输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
- 我们可以不考虑输出结果的顺序。

**进阶:**

- 如果给定的数组已经排好序呢？你将如何优化你的算法？
- 如果 *nums1* 的大小比 *nums2* 小很多，哪种方法更优？
- 如果 *nums2* 的元素存储在磁盘上，磁盘内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？

### 2. 解题：

使用`ArrayList`来存放重复元素。

将两个数组排序，使用两个指针`i`、`j`来遍历两个数组，当其中一个数组遍历完时结束。

当`nums1[i] == nums2[j]`，将该元素加入到`ArrayList`，并且`i++, j++`；

当`nums1[i] < nums2[j]`，`i++`；

当`nums1[i] > nums2[j]`，`j++`。

最后再将`ArrayList`转换成`int[]`。

#### 代码：

```java
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null)
            return null;
        
        List<Integer> list = new ArrayList<>();
        
        int len1 = nums1.length;
        int len2 = nums2.length;
        int i = 0;
        int j = 0;
        
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        while (i < len1 && j < len2) {
            if (nums1[i] == nums2[j]) {
                list.add(nums1[i]);
                j++;
                i++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }
        
        int[] res = new int[list.size()];
        
        for (int k = 0; k < list.size(); k++) {
            res[k] = list.get(k);
        }
        return res;
    }
}
```

