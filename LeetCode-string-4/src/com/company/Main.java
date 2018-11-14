package com.company;

import java.util.Arrays;

/**
 * 有效的字母异位词
 *
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的一个字母异位词。
 *
 * 示例 1:
 *
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 *
 * 输入: s = "rat", t = "car"
 * 输出: false
 * 说明:
 * 你可以假设字符串只包含小写字母。
 *
 * 进阶:
 * 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 * */
public class Main {

    public static void main(String[] args) {
	// write your code here
    }

    /**
     * 将两个字符串转换成数组形式
     * 再将两个字符串排序
     * 判断 每个位置上 两个字符串是否想同
     *
     * */
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] s_ch = s.toCharArray();
        char[] t_ch = t.toCharArray();
        Arrays.sort(s_ch);
        Arrays.sort(t_ch);
        for (int i=0; i<s_ch.length; i++) {
            if (s_ch[i] != t_ch[i])
                return false;
        }
        return true;
    }

    /**
     * 创建一个大小为26的数组，用来存放每个字母出现次数
     * 如果s中出现，则该字符的次数++
     * 如果t中出现，则该字符的次数--
     *
     * 当数组每个索引的值都为0时，则满足条件
     * */
    public boolean isAnagram1(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] ints = new int[26];

        for (int i = 0; i < s.length(); i++) {
            ints[s.charAt(i) - 'a']++;
            ints[t.charAt(i) - 'a']--;
        }

        for (int i : ints) {
            if (i != 0)
                return false;
        }
        return true;
    }
}
