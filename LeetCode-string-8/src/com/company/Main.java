package com.company;

/**
 * 报数
 *
 * 报数序列是一个整数序列，按照其中的整数的顺序进行报数，得到下一个数。其前五项如下：
 *
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 1 被读作  "one 1"  ("一个一") , 即 11。
 * 11 被读作 "two 1s" ("两个一"）, 即 21。
 * 21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。
 *
 * 给定一个正整数 n（1 ≤ n ≤ 30），输出报数序列的第 n 项。
 *
 * 注意：整数顺序将表示为一个字符串。
 *
 *
 * 示例 1:
 *
 * 输入: 1
 * 输出: "1"
 * 示例 2:
 *
 * 输入: 4
 * 输出: "1211"
 * */
public class Main {


    public static void main(String[] args) {
        System.out.println(countAndSay(1));
        System.out.println(countAndSay(2));
        System.out.println(countAndSay(3));
        System.out.println(countAndSay(4));
        System.out.println(countAndSay(5));
    }
    /**
     * 首先这个题最关键的地方是：读懂题
     * 报数：指的是　把当前字符串中，每个数字个个数报出
     * n=1: 1       : 1个1             -> 11
     * n=2: 11      : 2个1             -> 21
     * n=3: 21      : 1个2,1个1         -> 1211
     * n=4: 1211    : 1个1,1个2,2个1    -> 111221
     *
     * n 的值　与　n-1 有关
     * 所以每次都是从　１　开始
     *
     * 两个关键：　当前数字，以及当前数字的个数
     * */
    public static String countAndSay(int n) {
        String num = "1";
        
        while (--n > 0) {
            num = next(num);
        }
        return num;
    }
    /**
     * 得到ｎｕｍ的下一项
     * */
    private static String next(String num) {
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        while (i < num.length()) {
            char ch = num.charAt(i);
            int count = 0;  //记录当前字符的个数
            while (i < num.length() && ch == num.charAt(i)) {
                i++;
                count++;
            }
            stringBuilder.append(count);
            stringBuilder.append(ch);
        }
        return stringBuilder.toString();

    }
}
