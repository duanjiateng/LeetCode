package com.company;


import java.util.ArrayList;
import java.util.List;

/**
 *  字符串中的第一个唯一字符
 *
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 *
 * 案例:
 *
 * s = "leetcode"
 * 返回 0.
 *
 * s = "loveleetcode",
 * 返回 2.
 *
 *
 * 注意事项：您可以假定该字符串只包含小写字母
 * 
 * */
public class Main {

    public static void main(String[] args) {
	// write your code here
        String s = "aad";
        System.out.println(firstUniqChar(s));
    }


    /**
     *  str: 字符串的char[]形式
     *  len: 字符串的长度
     *  list: 字符类型的，可变数组，用来存放已经重复出现的字符
     *  flag: 标签，flag为false时，返回当前的i
     *
     *  
     * */
    public static int firstUniqChar(String s) {
        char[] str = s.toCharArray();
        int len = str.length;
        List<Character> list = new ArrayList<>();
        Boolean flag;

        for (int i = 0; i < len; i++ ) {
            flag = false;

            if (list.contains(str[i])) {
                continue;
            }
            for (int j = i+1; j < len; j++) {

                if (str[i] == str[j]) {
                    list.add(str[i]);
                    flag = true;
                    break;
                }
            }
            if (!flag)
                return i;
        }

        return -1;
    }
}
