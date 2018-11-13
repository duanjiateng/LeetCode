package com.company;

/**
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 *
 * 最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。
 *
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 * 示例 1:
 *
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 * 示例 2:
 *
 * 输入: [4,3,2,1]
 * 输出: [4,3,2,2]
 * 解释: 输入数组表示数字 4321。
 * */
public class Main {

    public static void main(String[] args) {

    }

    /**
     * 遇9进一位
     * 从最后一位开始
     *      小于9,则加一，直接返回该数组
     *      大于等于9,为0,判断下一位
     * 若循环正常结束，则说明为999999.... ，则第一位为1Q
     *
     * */
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        for (int i = len-1; i >= 0; i-- ) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }

        int[] anwser = new int[len+1];
        anwser[0] = 1;
        return anwser;
        
        
    }
    
}