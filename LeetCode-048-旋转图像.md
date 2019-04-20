## LeetCode-048-旋转图像

### 1. 题目：

旋转图像

给定一个 *n* × *n* 的二维矩阵表示一个图像。

将图像顺时针旋转 90 度。

**说明：**

你必须在**原地**旋转图像，这意味着你需要直接修改输入的二维矩阵。**请不要**使用另一个矩阵来旋转图像。

**示例 1:**

```
给定 matrix = 
[
  [1,2,3],
  [4,5,6],
  [7,8,9]
],

原地旋转输入矩阵，使其变为:
[
  [7,4,1],
  [8,5,2],
  [9,6,3]
]
```

**示例 2:**

```
给定 matrix =
[
  [ 5, 1, 9,11],
  [ 2, 4, 8,10],
  [13, 3, 6, 7],
  [15,14,12,16]
], 

原地旋转输入矩阵，使其变为:
[
  [15,13, 2, 5],
  [14, 3, 4, 1],
  [12, 6, 8, 9],
  [16, 7,10,11]
]
```

### 2. 解题：

不能使用额外空间，因此我们需要通过交换完成。分两步：

1. 以矩阵的中心列为对称轴，进行翻转（实际上进行交换）；
2. 以翻转后矩阵的副对角线为对称轴，进行翻转。

#### 代码：

```java
class Solution {
    public void rotate(int[][] matrix) { 
        int row = matrix.length;
        int col = matrix[0].length;
        
        //以中心列为轴进行翻转，也就是交换元素
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][col - 1 - j];
                matrix[i][col - 1 - j] = temp;
            }
        }
        //以副对角线为轴进行翻转
        for (int i = 0; i < row; i++) {
            for (int j = 0; j< col - i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[col - 1 - j][row - 1 - i];
                matrix[col - 1 - j][row - 1 - i] = temp;
            }
        }
    }
}
```

