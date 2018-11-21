package com.company;

/**
 * 最长公共前缀
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 示例 1:
 *
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 *
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:
 *
 * 所有输入只包含小写字母 a-z 。
 * */
public class Main {

    public static void main(String[] args) {
	// write your code here
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0)
            return null;
        StringBuilder strB = new StringBuilder();
        String str = strs[0];

        for (int j = 0; j < str.length(); j++) {
            for (int i = 1; i < strs.length; i++) {
                if (j >= strs[i].length())
                    return strB.toString();
                if (str.charAt(j) == strs[i].charAt(j)) {
                    continue;
                }
                return strB.toString();
            }

            strB.append(str.charAt(j));
        }
        return strB.toString();
    }
}
