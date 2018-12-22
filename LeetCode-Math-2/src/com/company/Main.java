package com.company;

import java.util.Arrays;

/**
 *  计数质数
 *
 * 统计所有小于非负整数 n 的质数的数量。
 *
 * 示例:
 *
 * 输入: 10
 * 输出: 4
 * 解释: 小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
 * */
public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println(countPrimes(10));
    }

    /**
     * 暴力破解
     * 遍历n次
     * 对于每一个数都进行是否为质数判断
     * */
    public static int countPrimes(int n) {
        int count = 0;
        for (int i = 2; i < n; i++ ) {
            if (isPrinmes(i))
                count++;
        }
        return count;
    }

    private static boolean isPrinmes(int num) {
        for (int i = 2; i < num; i++) {
            if (num % i == 0)
                return false;
        }
        return true;
    }


    /**
     * 埃拉托斯特尼筛法
     * 如果一个数是另一个数的倍数，那这个数肯定不是质数。利用这个性质，可以建立一个质数数组，从2开始将素数的倍数都标注为不是质数。
     *
     * */
    public static int countPrimes1(int n) {
        boolean[] primes = new boolean[n];
        Arrays.fill(primes, true);
        for (int i = 2; i < n; i++) {
            if (primes[i]) {
                for (int j = i * 2; j < n; j = j + i) {
                    primes[j] = false;
                }
            }
        }
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (primes[i])
                count++;
        }
        return count;
    }
}
