## LeetCode-050-Pow(x, n)

### 1. 题目：

Pow(x, n)

实现`pow(x, n)`，即计算 x 的 n 次幂函数。

**示例 1:**

```
输入: 2.00000, 10
输出: 1024.00000
```

**示例 2:**

```
输入: 2.10000, 3
输出: 9.26100
```

**示例 3:**

```
输入: 2.00000, -2
输出: 0.25000
解释: 2-2 = 1/22 = 1/4 = 0.25
```

**说明:**

- -100.0 < *x* < 100.0
- *n* 是 32 位有符号整数，其数值范围是 [−231, 231 − 1] 。

### 2. 解题：

我们使用分治方法。我们知道如果是偶数次幂，例如`x^8`，我们通过`x^4, x^2, x^1`来求出，这样减少了运算。如果是奇数次幂，奇数减一就是偶数，最后再补一个`x`就可以。

#### 代码：

```java
class Solution {
    public double myPow(double x, int n) {
        if (n < 0) {
            return 1.0 / pow(x, -n);
        } else {
            return pow(x, -n);
        }
    }
    
    private double pow(double x, int n) {
        if (n == 0)
            return 1;
        double res;
        double temp = pow(x, n/2);
        if (n % 2 == 0) {
            res = temp * temp;
        } else {
            res = temp * temp * x;
        }
        return res;
    }
}
```

