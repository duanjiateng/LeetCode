## LeetCode-079-WordSearch

### １．题目：

单词搜索

给定一个二维网格和一个单词，找出该单词是否存在于网格中。

单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。

**示例:**

```
board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]

给定 word = "ABCCED", 返回 true.
给定 word = "SEE", 返回 true.
给定 word = "ABCB", 返回 false.
```

### ２．解题：

​	首先这个类似于迷宫问题，当单词的第一个字母在`board`匹配后，判断其位置的上下左右（考虑边界）是否可以匹配单词的下一个字母．我们为了实现这个过程，需要使用DFS．

​	由于同一个单元格内的字母不允许重复使用，因此我们需要使用额外的空间来记录被访问过的单元格．

​	现在我们来考虑递归退出条件．退出的情况无非两种：成功退出，当我们找到单词所有的字母时表示我们成功找到，此时使用一个计数器`count`用来表示成功匹配的字母数，满足`count == word.length()`；另一种情况就是找完所有情况不满足匹配，自动退出．

#### 	代码：

```java
class Solution {
    public boolean exist(char[][] board, String word) {
        if (board == null || (board.length == 0 && board[0].length == 0))
            return false;
        int row = board.length;
        int col = board[0].length;
        boolean[][] visited = new boolean[row][col];
		
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (wordDFS(board, visited, 0, i, j, word)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean wordDFS(char[][] board, boolean[][] visited, int count, int row, int col, String word) {
        //退出条件
        if (count == word.length()) {
            return true;
        }
        //判断边界
        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length) {
            return false;
        }
        //需要匹配的字符
        char ch = word.charAt(count);
        if (!visited[row][col] && ch == board[row][col]) {
            visited[row][col] = true;
            boolean next = (wordDFS(board, visited, count+1, row + 1, col, word) ||
                            wordDFS(board, visited, count+1, row - 1, col, word) ||
                            wordDFS(board, visited, count+1, row, col + 1, word) ||
                            wordDFS(board, visited, count+1, row, col - 1, word));
            visited[row][col] = false;
            return next;
        }
        
        return false;
    }
}
```

