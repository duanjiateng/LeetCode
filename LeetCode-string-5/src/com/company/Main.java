package com.company;

/**
 * 验证回文字符串
 * 
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 *
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 *
 * 示例 1:
 *
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 示例 2:
 *
 * 输入: "race a car"
 * 输出: false
 * */
public class Main {

    public static void main(String[] args) {
	// write your code here
    }

    /**
     * 1.将字符串整理成只含 大小写字母 数字
     * 2.将大写 转化成 小写
     * 3.比较 i 和 len-1-i 是否相同
     * */
    public boolean isPalindrome(String s) {
        if (s == null)
            return true;
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if ( (ch >= '0' && ch <= '9') || (ch >= 'a' && ch <= 'z')) {
                str.append(ch);
            } else if (ch >= 'A' && ch <= 'Z') {
                ch = (char)(ch + 32);
                str.append(ch);
            }
        }
        String s1 = str.toString();
        int len = s1.length();
        for (int i = 0; i < len/2; i++ ) {
            if (s1.charAt(i) != s1.charAt(len-1-i))
                return false;
        }
        return true;
    }
}
