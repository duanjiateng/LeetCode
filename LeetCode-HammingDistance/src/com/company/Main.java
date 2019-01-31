package com.company;
/**
 * 汉明距离
 * 两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。
 *
 * 给出两个整数 x 和 y，计算它们之间的汉明距离。
 *
 * 注意：
 * 0 ≤ x, y < 231.
 *
 * 示例:
 *
 * 输入: x = 1, y = 4
 *
 * 输出: 2
 *
 * 解释:
 * 1   (0 0 0 1)
 * 4   (0 1 0 0)
 *        ↑   ↑
 *
 * 上面的箭头指出了对应二进制位不同的位置。
 *
 * */
public class Main {

    public static void main(String[] args) {
	// write your code here
    }
    /**
     * 先将两个数字求异或
     * 使用汉明重量计算1的个数
     * */
    public static int hammingDistance(int x, int y) {
        return hammingWeight(x^y);
    }

    private static int hammingWeight(int num) {
        int count = 0;
        while (num != 0) {
            count += (num & 1);
            num >>>= 1;
        }
        return count;
    }
}
