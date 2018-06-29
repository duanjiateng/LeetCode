package com.company;
/**
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 *
 * 示例 1:
 *
 * 输入: 121
 * 输出: true
 * 示例 2:
 *
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3:
 *
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 *
 *
 *
 * */


public class Main {
    /**
     * 负数  返回  false
     * 正数   取反序， 与x比较 返回
     * */
    public static boolean isPalindrome(int x) {
        int y = 0, a = x ;

        if (x < 0)
            return false;
        while (a > 0) {
            y *= 10;
            y += a % 10;
            a /= 10;
        }

        return x == y;

    }

    public static void main(String[] args) {
        // write your code here
        System.out.println(isPalindrome(123));
        System.out.println(isPalindrome(121));
        System.out.println(isPalindrome(111));
        System.out.println(isPalindrome(-1001));
        System.out.println(isPalindrome(+123));

    }
}
