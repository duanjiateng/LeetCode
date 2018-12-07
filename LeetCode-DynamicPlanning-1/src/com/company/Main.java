package com.company;

/**
 *     爬楼梯
 *       
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * 注意：给定 n 是一个正整数。
 *
 * 示例 1：
 *
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * 示例 2：
 *
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 * */
public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println(climbStairs(35));
    }
    /**
     * 使用排列组合
     * 无论那种方式　都是由１和２组成，则找到２的个数　以及　上楼梯的步数
     * 则使用组合就能找到答案
     * 问题是：如果n超过３５时，求阶乘会超过long的长度，而导致结果错误
     * */
    public static int climbStairs(int n) {
        if (n == 0)     return 0;
        if (n == 1)     return 1;
        if (n == 2)     return 2;
        int nums_2 = n / 2;
        int result = 0;
        for (int i = 1; i <= nums_2; i++) {
            result += combination(i, n-i);
        }
        return result + 1;

    }

    /**
     * 计算阶乘
     *
     * */
    private static long factorial(int n) {
        long sum = 1;
        while (n > 0) {
            sum *= n--;
        }
        return sum;
    }

    /**
     * 组合公式计算
     * */
    private static long combination(int m, int n) {
        return m <= n ? factorial(n) / (factorial(m) * factorial(n - m)) : 0;
    }

    /**
     * 使用递归
     * n个台阶：开始１步的方法数＋开始两步的方法数，这样只用计算n-1 和　n-2的方法数
     * 以此类推　最终　会剩下　1 和　2
     * 1个台阶的方法只有１
     * 2个台阶的方法只有2
     * 使用数组存放从1开始的方法数
     * */
    public static int climbStairs１(int n) {
        if (n == 1)
            return 1;
        else if (n == 2)
            return 2;
        else {
            int[] result = new int[n];
            result[0] = 1;
            result[1] = 2;
            for (int i = 2; i < n; i++) {
                result[i] = result[i-1] + result[i-2];
            }
            return result[n-1];
        }
    }

}
