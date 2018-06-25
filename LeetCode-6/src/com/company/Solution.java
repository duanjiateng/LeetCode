package com.company;

/**
 * 将字符串 "PAYPALISHIRING" 以Z字形排列成给定的行数：
 *
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 之后从左往右，逐行读取字符："PAHNAPLSIIGYIR"
 *
 * 实现一个将字符串进行指定行数变换的函数:
 *
 * string convert(string s, int numRows);
 * 示例 1:
 *
 * 输入: s = "PAYPALISHIRING", numRows = 3
 * 输出: "PAHNAPLSIIGYIR"
 * 示例 2:
 *
 * 输入: s = "PAYPALISHIRING", numRows = 4
 * 输出: "PINALSIGYAHRPI"
 * 解释:
 *
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 * */

/**
 * 按行读取，每一行排列规律
 * 第1行          i = 0；              k*(2numRows - 2) + i
 * 第numRows行    i = numRows - 1      k*(2numRows - 2) + i
 * 1 ~ numRows行  i = (0，numRows)     k*(2numRows - 2) + i  and (k+1)(2numRows - 2) - i
 *
 * */
public class Solution {

    public static String convert(String s, int numRows) {
        StringBuilder strB = new StringBuilder();
        int len = s.length();
        int n = 2*numRows - 2;

        if (1 == numRows || 1 == n)
            return s;
        for (int i=0; i<numRows; i++){
            for (int k=0; k+i < len; k += n){
                strB.append(s.charAt(k + i));
                if (0 != i && numRows-1 != i && k+n-i < len){
                    strB.append(s.charAt(k + n - i));
                }

            }
        }

        return strB.toString();
    }

    public static void main(String[] args) {
        // write your code here
        String s1 = "PAYPALISHIRING";
        //System.out.println(convert(s1, 3));
        String s = convert(s1, 4);
        System.out.println(s == "PINALSIGYAHRPI");
        System.out.println(convert(s1, 4));


    }
}