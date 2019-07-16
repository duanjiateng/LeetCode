## LeetCode-119-杨辉三角 II

### 1. 题目：

 杨辉三角 II

给定一个非负索引 *k*，其中 *k* ≤ 33，返回杨辉三角的第 *k* 行。

![img](https://upload.wikimedia.org/wikipedia/commons/0/0d/PascalTriangleAnimated2.gif)

在杨辉三角中，每个数是它左上方和右上方的数的和。

**示例:**

```
输入: 3
输出: [1,3,3,1]
```

**进阶：**

你可以优化你的算法到 *O*(*k*) 空间复杂度吗？

### 2. 解题：

每一层的数据都和上一层有关，因此从第一层开始计算；

对于每一层分两种情况：

1. 第一个和最后一个元素为`1`
2. 剩下的数元素是其上一层`[i-1]`和`[i]`的和

### 代码：

```java
class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>(rowIndex);
        List<Integer> next = new ArrayList<>(rowIndex);
        int k = 0;
        while (k <= rowIndex) {
            for (int i = 0; i <= k; i++) {
                if (i == 0 || i == k) {
                    next.add(1);
                } else {
                    int num = res.get(i-1) + res.get(i);
                    next.add(num);
                }
            }
            res = next;
            next = new ArrayList<>(rowIndex);
            k++;
        }
        return res;
    }
}
```

### 3. 进阶：

数学方法：

杨辉三角就是二项式系数；

有通项公式：`C(n,m)=(n)!/[(m)!(n-m)!] `；

研究每一项的规律：`C(4,1)=C(4,0)*4/1,C(4,2)=C(4,1)*3/2, C(4,3)=C(4,2)*2/3,C(4,4)=C(4,3)*1/4`；

### 代码：

```java
class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> ans = new ArrayList<>(rowIndex + 1);
        long current = 1;
        for (int i = 0; i <= rowIndex; i++) {
            ans.add((int) current);
            current = current * (rowIndex-i)/(i+1);
        }
        return ans;
    }
}
```

