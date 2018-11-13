package com.company;

/**
 *
 * 给定一个 32 位有符号整数，将整数中的数字进行反转。
 *
 * 示例 1:
 *
 * 输入: 123
 * 输出: 321
 *  示例 2:
 *
 * 输入: -123
 * 输出: -321
 * 示例 3:
 *
 * 输入: 120
 * 输出: 21
 * 注意:
 *
 * 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−2^31,  2^31 − 1]。根据这个假设，如果反转后的整数溢出，则返回 0。
 * 
 * */
public class Main {

    public static void main(String[] args) {
	// write your code here
        int i = -1234567;
        System.out.println(reverse(i));
        
    }

    /**
     * 需要注意两点
     * 第一：整数颠倒
     *      %10 取 最后一位
     *      /10 去掉 最后一位
     *
     * 第二：判断是否溢出
     *      若溢出， 则 之前的数值会变化2
     *
     * */
    public static int reverse(int x) {
        int result = 0;
        while ( x != 0 ) {
            int temp = result *10 + x % 10;

            // 如果溢出，则temp会发生变化，temp/10 会与之前的 result 不同
            if (temp / 10 != result)
                return 0;
            
            result = temp;
            x /= 10;
        }
        return result;

    }
}
