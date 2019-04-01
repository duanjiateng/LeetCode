## LeetCode-322-零钱兑换

### 1. 题目：

零钱兑换

给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 `-1`。

**示例 1:**

```
输入: coins = [1, 2, 5], amount = 11
输出: 3 
解释: 11 = 5 + 5 + 1
```

**示例 2:**

```
输入: coins = [2], amount = 3
输出: -1
```

**说明**:
你可以认为每种硬币的数量是无限的。

### 2. 解题：

​	使用动态规划，我们假设`f(n)`表示`n`需要的最少数量。

​	动态规划求最小值公式：`f(n) = min{f(i) + f(n - i)}`，而对于本题，我们需要根据所给的硬币来求最小值：`f(n) = 1 + f(n - coins[i])`。

​	为了方便计算，我们使用"自底向上"（从`f(1)`到`f(amount)`）和数组来存储数据，这样我们避免重复计算。

​	对于数组初始化，赋值为`amount + 1`，我们知道假设有硬币`1`，最多也只有`amount`。

#### 	代码：

```java
class Solution {
    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0 || amount < 0) return -1;
        if (amount == 0) return 0;
        int[] dp = new int[amount+1];
        Arrays.fill(dp, amount+1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i >= coins[j])
                    dp[i] = Math.min(dp[i], 1 + dp[i - coins[j]]);
            }
        }
        return (dp[amount] == amount+1) ? -1 : dp[amount];
    }
}
```

