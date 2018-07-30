package com.company;

/**
 * 给定一个字符串 (s) 和一个字符模式 (p)。实现支持 '.' 和 '*' 的正则表达式匹配。
 *
 * '.' 匹配任意单个字符。
 * '*' 匹配零个或多个前面的元素。
 * 匹配应该覆盖整个字符串 (s) ，而不是部分字符串。
 *
 * 说明:
 *
 * s 可能为空，且只包含从 a-z 的小写字母。
 * p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
 * 示例 1:
 *
 * 输入:
 * s = "aa"
 * p = "a"
 * 输出: false
 * 解释: "a" 无法匹配 "aa" 整个字符串。
 * 示例 2:
 *
 * 输入:
 * s = "aa"
 * p = "a*"
 * 输出: true
 * 解释: '*' 代表可匹配零个或多个前面的元素, 即可以匹配 'a' 。因此, 重复 'a' 一次, 字符串可变为 "aa"。
 * 示例 3:
 *
 * 输入:
 * s = "ab"
 * p = ".*"
 * 输出: true
 * 解释: ".*" 表示可匹配零个或多个('*')任意字符('.')。
 * 示例 4:
 *
 * 输入:
 * s = "aab"
 * p = "c*a*b"
 * 输出: true
 * 解释: 'c' 可以不被重复, 'a' 可以被重复一次。因此可以匹配字符串 "aab"。
 * 示例 5:
 *
 * 输入:
 * s = "mississippi"
 * p = "mis*is*p*."
 * 输出: false
 *
 * */

public class Main {
    /**
     *  用递归的方法实现
     * */

    public static boolean isMatch(String s, String p) {
        //若p为空，若s也为空，返回true，反之返回false
        if (p.isEmpty()) {
            return s.isEmpty();
        }

        //若p的长度为1，若s长度也为1，且相同或是p为'.'则返回true，反之返回false
        if (p.length() == 1) {
            return (s.length() == 1 && (s.equals(p) || p.equals(".")));
        }

        // 若p的第二个字符不为*，若此时s为空返回false，否则判断首字符是否匹配，且从各自的第二个字符开始调用递归函数匹配
        if (p.charAt(1) != '*') {
            if (s.isEmpty())
                return false;
            return (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.') && isMatch(s.substring(1), p.substring(1));
        }

        //若p的第二个字符为*，若s不为空且字符匹配，调用递归函数匹配s和去掉前两个字符的p，若匹配返回true，否则s去掉首字母
        while (!s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.')) {
            if (isMatch(s, p.substring(2)))
                return true;
            s = s.substring(1);
        }

        //返回调用递归函数匹配s和去掉前两个字符的p的结果
        return isMatch(s, p.substring(2));
    }

    public static void main(String[] args) {
        // write your code here
        String s = "abcd"; //"aab";       //"ab";    //"aa";    //"aa";
        String p =  "a.*c"; //"c*a*b";     //".*";    //"a*";    //"a";
        System.out.println(isMatch(s,p));

    }
}
