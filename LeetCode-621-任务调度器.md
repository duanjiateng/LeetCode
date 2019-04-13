## LeetCode-621-任务调度器

### 1. 题目：

Task Scheduler

给定一个用字符数组表示的 CPU 需要执行的任务列表。其中包含使用大写的 A - Z 字母表示的26 种不同种类的任务。任务可以以任意顺序执行，并且每个任务都可以在 1 个单位时间内执行完。CPU 在任何一个单位时间内都可以执行一个任务，或者在待命状态。

然而，两个**相同种类**的任务之间必须有长度为 **n** 的冷却时间，因此至少有连续 n 个单位时间内 CPU 在执行不同的任务，或者在待命状态。

你需要计算完成所有任务所需要的**最短时间**。

**示例 1：**

```
输入: tasks = ["A","A","A","B","B","B"], n = 2
输出: 8
执行顺序: A -> B -> (待命) -> A -> B -> (待命) -> A -> B.
```

**注：**

1. 任务的总个数为 [1, 10000]。
2. n 的取值范围为 [0, 100]。

### 2. 解题：

我们求最短时间，优先完成任务最多的，在完成数量最多的任务间隔中穿插其他任务或等待。

先来明确几个变量：

`n`：是间隔

`max`：个数最多的任务的数量。例如，`["A","A","A","B","B"]`，`max = 3`.

`maxCount`：有多少个最大数量；例如，`["A","A","A","B","B","B"]`，`maxCount = 2`.

当出现等待的时候，我们可以计算出最短时间为：`(max-1)*(n+1)+maxCount`

当没有出现等待时，`(max-1)*(n+1)+maxCount`会小于`tasks.length`，也就是说明最大任务　的间隔由其他任务填满，此时最小时间就是`tasks.length`。

#### 代码：

```java
class Solution {
    public int leastInterval(char[] tasks, int n) {
        if (n == 0)
            return tasks.length;
        int[] counts = new int[26];
        int len = counts.length;
        for (int i = 0; i < tasks.length; i++) {
            counts[tasks[i] - 'A']++;
        }
        Arrays.sort(counts);
        int max = 0;
        int maxCount = 0;
        max = counts[len - 1];
        // 找最大任务的个数
        for (int i = len - 1; i >= 0; i--) {
            if (max == counts[i]) {
                maxCount++;
                continue;
            }
            break;
        }
        int res = (max-1)*(n+1)+maxCount;
        return res > tasks.length ? res : tasks.length;
    }
}
```

