package com.company;

/**
 *  反转字符串
 *
 * 编写一个函数，其作用是将输入的字符串反转过来。
 *
 * 示例 1:
 *
 * 输入: "hello"
 * 输出: "olleh"
 * 示例 2:
 *
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: "amanaP :lanac a ,nalp a ,nam A"
 *
 * */
public class Main {

    public static void main(String[] args) {
	// write your code here
        String s = "hello";
        System.out.println(reverseString(s));
        System.out.println(reverseString1(s));
    }

    /**
     * 使用StringBuilder
     * 从末尾向前读取string的字符
     * 将字符添加到 StringBuilder 中
     * */
    public static String reverseString(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = s.length()-1; i >= 0; i--)  {
            stringBuilder.append(s.charAt(i));
        }
        return stringBuilder.toString();
    }

    /**
     * 使用两个char[]
     *
     * */
    public static String reverseString1(String s) {
        char[] chars = s.toCharArray();
        int len = chars.length;
        char[] chars1 = new char[len];
        for (int i = 0; i < len; i++) {
            chars1[i] = chars[len - 1 -i];
        }
        return new String(chars1);
    }
}
