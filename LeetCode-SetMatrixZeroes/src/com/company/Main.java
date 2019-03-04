package com.company;
/*
    矩阵置零
给定一个 m x n 的矩阵，如果一个元素为 0，则将其所在行和列的所有元素都设为 0。请使用原地算法。

示例 1:

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
示例 2:

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
进阶:

一个直接的解决方案是使用  O(mn) 的额外空间，但这并不是一个好的解决方案。
一个简单的改进方案是使用 O(m + n) 的额外空间，但这仍然不是最好的解决方案。
你能想出一个常数空间的解决方案吗？
 */
public class Main {

    public static void main(String[] args) {
	// write your code here
        int[][] nums = new int[3][2];
        System.out.println(nums.length);
        System.out.println(nums[0].length);
    }

    /*
    使用额外O(m+n)空间来记录矩阵中为０元素的位置
    第一次遍历查找为０的位置
    第二次遍历置零
     */
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
    /*
    使用常数空间，则需要进行优化，不使用两个数组记录０元素的位置，使用矩阵的第一行和第一列来记录０元素的位置，
    但是需要注意的本身第一行和第一列就有０元素的情况，因此需要两个变量rowFlag,colFlag来记录，最后对第一行和
    第一列进行置零处理．
     */
    public void setZeroes1(int[][] matrix) {
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
