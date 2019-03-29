## LeetCode-240-搜索二维矩阵 II

### 1. 题目：

搜索二维矩阵 II

编写一个高效的算法来搜索 *m* x *n* 矩阵 matrix 中的一个目标值 target。该矩阵具有以下特性：

- 每行的元素从左到右升序排列。
- 每列的元素从上到下升序排列。

**示例:**

现有矩阵 matrix 如下：

```
[
  [1,   4,  7, 11, 15],
  [2,   5,  8, 12, 19],
  [3,   6,  9, 16, 22],
  [10, 13, 14, 17, 24],
  [18, 21, 23, 26, 30]
]
```

给定 target = `5`，返回 `true`。

给定 target = `20`，返回 `false`。

### 2. 解题：

​	这是一个特殊的矩阵，每一行是从小到大，每一列也是从小到大。因此我们可以知道矩阵的右上角是行的中最大的，也是列中最小的。

​	因此，我们可以每次都和矩阵的右上角元素比较：

​		`target == matrix[row][col]`返回`true`;

​		`target < matrix[row][col]`说明肯定不在当前列，因此“删去当前列”，`col--`

​		`target > matrix[row][col]`说明肯定不在当前行，因此“删去当前行”，`row++`					

#### 	代码：

```java
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null) return false;
        if (matrix.length == 0) return false;
        if (matrix[0].length == 0) return false;

        int row = 0;
        int col = matrix[0].length - 1;

        while (row < matrix.length && col >= 0) {
            if (target == matrix[row][col]) {
                return true;
            } else if (target < matrix[row][col]) {
                col--;
            } else {
                row++;
            }
        }
        return false;
    }
}
```

