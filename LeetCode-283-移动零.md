## LeetCode-283-移动零

### 1. 题目：

移动零

给定一个数组 `nums`，编写一个函数将所有 `0` 移动到数组的末尾，同时保持非零元素的相对顺序。

**示例:**

```
输入: [0,1,0,3,12]
输出: [1,3,12,0,0]
```

**说明**:

1. 必须在原数组上操作，不能拷贝额外的数组。
2. 尽量减少操作次数。

### 2. 解题：

本题要求将`0`移动到数组末尾，并且要求非零相对顺序不变。实际上就是让我们将非零元素移到数组头部。

使用双指针`indexZero`(记录第一个0的索引)和`indexNoZero`(记录为移动的第一个非零的索引)。

当`indexZero < indexNoZero`时，则将其“交换”（实际上只需要赋值，并不用真正交换）；

当`indexZero > indexNozero`时，不要交换，继续找下一个非零元素。

注意只有非零元素和只有零元素的情况。

#### 代码：

```java
class Solution {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0)
            return;
        int indexZero = 0;
        int indexNoZero = 0;
        
        while (indexNoZero < nums.length - 1) {
            //找到第一个0元素
            while (nums[indexZero] != 0) {
                indexZero++;
                if (indexZero == nums.length -1)
                    return;
            }

            //找到第一个非零元素
            while (nums[indexNoZero] == 0) {
                indexNoZero++;
                //最右边是零元素j
                if (indexNoZero == nums.length)
                    return;
            }
            
            //如果０在非零前边，则他们交换，否则，非零索引前进
            if (indexZero < indexNoZero) {
                nums[indexZero] = nums[indexNoZero];
                nums[indexNoZero] = 0;    
            } else {
                indexNoZero++;
            }
            
        }
        
    }
}
```

### 3. 优化

```java
class Solution {
    public void moveZeroes(int[] nums) {
        int index = 0;
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (nums[i] != 0) {
                nums[index++] = nums[i];
            }
        }
        for (int i = index; i < length; i++) {
                nums[i] = 0;
        }
    }
}
```

