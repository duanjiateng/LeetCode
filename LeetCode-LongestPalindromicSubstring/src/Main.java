/*
最长回文子串

给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。

示例 1：

输入: "babad"
输出: "bab"
注意: "aba" 也是一个有效答案。
示例 2：

输入: "cbbd"
输出: "bb"
 */
public class Main {

    public static void main(String[] args) {
	// write your code here
    }

    /*
    中心扩展法：
    从字符串的第一个字符出发，向两边扩展，找出最长的回文子串．
    需要考虑奇数和偶数的情况，当前字符串作为中心，或当前字符串作为中心对的左边．
     */
    public String longestPalindrome(String s) {
        int len = s.length();
        if (len <= 1)
            return s;

        String result = "";
        String str;
        for (int i = 0; i < len; i++) {
            //奇数
            str = findLongest(s, i, i);
            if (str.length() > result.length()) {
                result = str;
            }
            //偶数
            str = findLongest(s, i, i+1);
            if (str.length() > result.length()) {
                result = str;
            }
        }
        return result;
    }

    /*
    用来查找从字符串str开始扩展的最大字串
     */
    private String findLongest(String str, int left, int right) {
        int len = str.length();
        int l = left;
        int r = right;
        while (l >= 0 && r < len && str.charAt(l) == str.charAt(r)) {
            l--;
            r++;
        }

        return str.substring(l+1, r);
    }
}
