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
        System.out.println(firstUniqChar1(s));
    }


    /**
     *  str: 字符串的char[]形式
     *  len: 字符串的长度
     *  list: 字符类型的，可变数组，用来存放已经重复出现的字符
     *  flag: 标签，flag为false时，返回当前的i
     *
     *  先判断 i 是否在 list 中存在
     *      存在：跳出当前循环，进行下一次循环
     *      不存在：查找 j 是否与 i 相同的
     *          存在相同： 添加到list中, flag = true, 跳出循环
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

    /**
     * 从26个小写英语字母出发
     * 遍历字母
     * 查找当前字母在 s 中第一次出现的索引 resulit
     *      result = -1; 不存在
     *      result 如果和 s 的最后一次出现的索引相同，说明该字符只出现一次
     *
     * */
    public static int firstUniqChar1(String s) {
        int result = -1;
        for (char ch = 'a'; ch <= 'z'; ch++) {
            int index = s.indexOf(ch);
            if (index != -1 && index == s.lastIndexOf(ch)) {
                result = (result == -1) ? index : Math.min(result, index);
            }
        }

        return result;
    }
}

