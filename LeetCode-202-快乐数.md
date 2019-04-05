## LeetCode-202-快乐数

### 1. 题目：

快乐数

编写一个算法来判断一个数是不是“快乐数”。

一个“快乐数”定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，也可能是无限循环但始终变不到 1。如果可以变为 1，那么这个数就是快乐数。

**示例:** 

```
输入: 19
输出: true
解释: 
1^2 + 9^2 = 82
8^2 + 2^2 = 68
6^2 + 8^2 = 100
1^2 + 0^2 + 0^2 = 1
```

### 2. 解题：

主要是跟着题意出发，判断`n`是否是快乐数。

需要注意几点：

- 主要部分就是对`n`进行`/10`和`%10`运算，然后对每一位平方，求和。
- 但是对于可能出现无限循环的情况，才用`set`来解决，将出现的所有`n`都放进`set`，判断`n`是否在`Set`中出现过，若出现过则说明出现循环。

#### 代码：

```java
class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (!set.contains(n)) {
            set.add(n);
            int tmp = 0;
            if (n != 1) {
                while (n > 0) {
                    tmp += (n % 10) * (n % 10);
                    n /= 10;
                }
            } else {
                return true;
            }
            n = tmp;
        }
        return false;
    }
}
```

### 3. 优化：

​	针对于出现循环的情况，最后只会进入一个循环`4 → 16 → 37 → 58 → 89 → 145 → 42 → 20 → 4`，因此只需要判断`n`是否等于`4`。

#### 代码：

```java
class Solution {
    public boolean isHappy(int n) {
        int tmp = 0;
        while (n != 1) {
            while (n > 0) {
            tmp += (n % 10) * (n % 10);
            n /= 10;
            }
            n = tmp;
            tmp = 0;
            if (n == 4) return false;
        }
        return true;
    }
}
```

