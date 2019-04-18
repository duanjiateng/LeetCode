## LeetCode-066-加一

### 1. 题目：

加一

给定一个由**整数**组成的**非空**数组所表示的非负整数，在该数的基础上加一。

最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。

你可以假设除了整数 0 之外，这个整数不会以零开头。

**示例 1:**

```
输入: [1,2,3]
输出: [1,2,4]
解释: 输入数组表示数字 123。
```

**示例 2:**

```
输入: [4,3,2,1]
输出: [4,3,2,2]
解释: 输入数组表示数字 4321。
```

### 2. 解题：

这个题主要思路从数组的最后一个元素开始加一，然后看是否进位。

若进位，则给数组的前一个元素加一，判断是否进位，重复此动作；

若不进位，则加一完成。

**需要注意**：当出现`9,99,999...`这种情况时，需要重新创建一个数组，使其第一个元素为`1`.

#### 代码：

```java
class Solution {
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        int carry = 1;
        int i = len - 1;
        while(carry == 1 && i >= 0) {
            int num = digits[i] + carry;
            carry = 0;
            if (num == 10) {
                carry = 1;
                digits[i] = 0;
                i--;
            } else {
                digits[i] = num;
            }
        } 
        
        if (carry == 1) {
            int[len+1] res = new int[len+1];
            res[0] = 1;
            return res;
        }
        return digits;
    }
}
```

