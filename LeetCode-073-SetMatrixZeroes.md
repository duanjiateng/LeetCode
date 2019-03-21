## LeetCode-073-SetMatrixZeroes

### １．题目：

矩阵置零

给定一个 *m* x *n* 的矩阵，如果一个元素为 0，则将其所在行和列的所有元素都设为 0。请使用**原地**算法**。**

**示例 1:**

```
输入: 
[
  [1,1,1],
  [1,0,1],
  [1,1,1]
]
输出: 
[
  [1,0,1],
  [0,0,0],
  [1,0,1]
]
```

**示例 2:**

```
输入: 
[
  [0,1,2,0],
  [3,4,5,2],
  [1,3,1,5]
]
输出: 
[
  [0,0,0,0],
  [0,4,5,0],
  [0,3,1,0]
]
```

**进阶:**

- 一个直接的解决方案是使用  O(*mn*) 的额外空间，但这并不是一个好的解决方案。
- 一个简单的改进方案是使用 O(*m* + *n*) 的额外空间，但这仍然不是最好的解决方案。
- 你能想出一个常数空间的解决方案吗？

### ２．解题：

​	使用额外的O(m+n)空间来记录矩阵中为0的元素．

​	使用两次遍历，第一次遍历用来找到所有0元素，并把它们的位置记录下来．

​	第二次遍历用来置零．

#### 	代码：

```java
	public void setZeroes(int[][] matrix) {
        //n用来记录０元素的行号
        int[] n = new int[matrix.length];
        //m用来记录０元素的列号
        int[] m = new int[matrix[0].length];
        //遍历矩阵，记录０元素的位置
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    n[i] = 1;
                    m[j] = 1;
                }
            }
        }
        //将行置零
        for (int i = 0; i < matrix.length; i++) {
            if (n[i] == 1) {
                for (int j = 0; j < matrix[0].length; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        //将列置零
        for (int j = 0; j < matrix[0].length; j++) {
            if (m[j] == 1) {
                for (int i = 0; i < matrix.length; i++) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
```

### ３．优化

​	对上面的代码进行优化，使用常数空间．不需要使用两个数组来记录0元素的位置，使用第一行和第一列来记录，但是需要注意其第一行和第一列本身就有0元素的情况，因此需要两个变量rawFlag，colFlag来标识是否有0，最后对第一行和第一列进行置零处理．

#### 	代码：

```java
class Solution {
    public void setZeroes(int[][] matrix) {
        //矩阵行数
        int rawLen = matrix.length;
        //矩阵列数
        int colLen = matrix[0].length;
        //行标记，第一行没有０元素为false
        boolean rawFlag = false;
        //列标记，第一列没有０元素为false
        boolean colFlag = false;
        //遍历矩阵
        for (int i = 0; i < rawLen; i++) {
            for (int j = 0; j < colLen; j++) {
                if (matrix[i][j] == 0) {
                    if (i == 0) {
                        rawFlag = true;
                    }
                    if (j == 0) {
                        colFlag = true;
                    }
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        //对非首行首列进行置零
        for (int i = 1; i < rawLen; i++) {
            for (int j = 1; j < colLen; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        //对首行置零
        if (rawFlag) {
            for (int j = 0; j < colLen; j++) {
                matrix[0][j] = 0;
            }
        }
        //对首列置零
        if (colFlag) {
            for (int i = 0; i < rawLen; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
```

