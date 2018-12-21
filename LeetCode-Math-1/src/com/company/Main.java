package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * Fizz Buzz
 * 
 * 写一个程序，输出从 1 到 n 数字的字符串表示。
 *
 * 1. 如果 n 是3的倍数，输出“Fizz”；
 *
 * 2. 如果 n 是5的倍数，输出“Buzz”；
 *
 * 3.如果 n 同时是3和5的倍数，输出 “FizzBuzz”。
 *
 * 示例：
 *
 * n = 15,
 *
 * 返回:
 * [
 *     "1",
 *     "2",
 *     "Fizz",
 *     "4",
 *     "Buzz",
 *     "Fizz",
 *     "7",
 *     "8",
 *     "Fizz",
 *     "Buzz",
 *     "11",
 *     "Fizz",
 *     "13",
 *     "14",
 *     "FizzBuzz"
 * ]
 * */
public class Main {

    public static void main(String[] args) {
	// write your code here
    }

    public List<String> fizzBuzz(int n) {
        List<String> list = new ArrayList<>(n);
        for (int i = 1; i <= n; i++) {
            boolean isFizz = (i % 3 == 0);
            boolean isBuzz = (i % 5 == 0);
            if (isBuzz && isFizz) {
                list.add("FizzBuzz");
            } else if (isFizz) {
                list.add("Fizz");
            } else if (isBuzz) {
                list.add("Buzz");
            } else
                list.add(String.valueOf(i));
        }
        return list;
    }
}
