package com.company;

/**
 * 实现 strStr() 函数。
 *
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 *
 * 示例 1:
 *
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 * 示例 2:
 *
 * 输入: haystack = "aaaaa", needle = "bba"
 * 输出: -1
 * 说明:
 *
 * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 *
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
 * */

public class Main {

    public static void main(String[] args) {

        System.out.println(strStr("hello", "ll"));
    }

    /**
     * 只为了解题，使用JavaAPI
     * */
    public static int strStr1(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

    /**
     * 截取字串对比
     * */
    public static int strStr(String haystack, String needle) {
        if( needle.isEmpty())
            return 0;
        int len_hay = haystack.length();
        int len_needle = needle.length();

        for (int i = 0; i < len_hay; i++) {
            if (len_hay - i < len_needle) {
                return -1;
            }
            if (haystack.substring(i, i+len_needle).equals(needle))
                return i;
        }
        return -1;
    }
}
