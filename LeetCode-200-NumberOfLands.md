## LeetCode-200-NumberOfLands

### １．题目：

岛屿的个数

给定一个由 `'1'`（陆地）和 `'0'`（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。

**示例 1:**

```
输入:
11110
11010
11000
00000

输出: 1
```

**示例 2:**

```
输入:
11000
11000
00100
00011

输出: 3
```

### ２．解答：

​	我们需要在矩阵中找到由`'１'`组成的陆地，当我们从一个点出发时，需要判断它的上下左右４点是否为`'1'`，如果有为`'1'`的点，则重复上述动作；若出现不为`'1'`，则说明到达陆地边界．这实际上就是对一个点进行深度遍历，递归查找为`'1'`点，直到找到整个陆地．

​	我们需要注意的是，我们可能会重复遍历同一个点，为了解决这个问题，当我们已经确定当前点为`'1'`时，我们将它置为`'0'`.

​	代码：

```java
class Solution {
    public int numIslands(char[][] grid) {
        //陆地个数
        int count = 0;
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return count;
        //矩阵行数
        int row = grid.length;
        //矩阵列数
        int col = grid[0].length;
		//遍历矩阵
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfsSearch(grid, i, j, row, col);
                }
            }
        }

        return count;
    }
    
	/**
     * 深度遍历，查找该点四周是否为'1'
     * @param grid 矩阵
     * @param i 当前点的行号
     * @param j 当前点的列号
     * @param row 矩阵的行数
     * @param col 矩阵的列数
     */
    private void dfsSearch(char[][] grid, int i, int j, int row, int col) {
        //判断是否在矩阵内
        if (i < 0 || i >= row || j < 0 || j >= col) {
            return;
        }
        //判断是否为＂陆地＂
        if (grid[i][j] != '1')
            return;
        //将该点置为'0'，表示已经访问过该点
        grid[i][j] = 0;
        //判断该点四周是否为＂陆地＂
        dfsSearch(grid, i, j+1, row, col);
        dfsSearch(grid, i, j-1, row, col);
        dfsSearch(grid, i+1, j, row, col);
        dfsSearch(grid, i-1, j, row, col);
        
    }
```

