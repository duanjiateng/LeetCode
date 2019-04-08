## LeetCode-029-两数相除

### 1. 题目：

两数相除

给定两个整数，被除数 `dividend` 和除数 `divisor`。将两数相除，要求不使用乘法、除法和 mod 运算符。

返回被除数 `dividend` 除以除数 `divisor` 得到的商。

**示例 1:**

```
输入: dividend = 10, divisor = 3
输出: 3
```

**示例 2:**

```
输入: dividend = 7, divisor = -3
输出: -2
```

**说明:**

- 被除数和除数均为 32 位有符号整数。
- 除数不为 0。
- 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231,  231 − 1]。本题中，如果除法结果溢出，则返回 231 − 1。

### 2. 解题：

首先不能使用乘法、除法和mod运算，我们想到可以使用减法来实现除法，但是我们会发现减法的效率很低。

除了这些操作，我们知道，位运算也可以表示乘法和除法，只是乘除的都是２的幂。

通过除法公式：`dividend / (2^n) = divisor + 余数`;

我们知道了：`dividend / (2^n) >= divisor`时，余数：`dividend - divisor*(2^n)`,

此时相当于`dividend / divisor = 2^n`.

则商就是满足情况的所有`2^n`的和。

**注意**：

- 对于正负问题，我们在处理之前，将正负号提取出来，使用它们的绝对值进行计算，最后的结果再加上正负号。

- 对于`int`类型范围问题（实际上就是`Integer.MIN_VALUE`的绝对值），我们使用`long`类型。
- 要注意除法溢出问题（实际上就是`Integer.MIN_VALUE / -1`）.

#### 代码：

```java
class Solution {
    public int divide(int dividend, int divisor) {
        int res = 0;
        // 被除数为0
        if (dividend == 0)
            return res;
        // 除法溢出问题
        if (dividend == Integer.MIN_VALUE && divisor == -1) 
            return Integer.MAX_VALUE;
        // 被除数的符号
        int sign1 = 1;
        // 除数的符号
        int sign2 = 1;
        // 防止int类型溢出
        long dividendL = dividend;
        long divisorL = divisor;
        // 对被除数绝对值处理
        if (dividendL < 0) {
            sign1 = -1;
            dividendL = sign1 * dividendL;
        }
        // 对除数绝对值处理
        if (divisorL < 0) {
            sign2 = -1;
            divisorL = divisorL * sign2;
        }
        // 进行除法运算
        for (int i = 31; i >= 0; i--) {
            // 找合适的2^n
            if (dividendL >> i >= divisorL) {
                // 结果加上2^n
                res += (1 << i);
                // 当前除法的商 dividendL - divisorL * (2^n)
                dividendL -= (divisorL << i);
            }
        }     
        // 结果加上符号
        return sign1*sign2*res;
    }
}
```

