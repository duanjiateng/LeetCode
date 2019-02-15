package com.company;
/**
 *   缺失数字
 *
 *
 * 给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。
 *
 * 示例 1:
 *
 * 输入: [3,0,1]
 * 输出: 2
 * 示例 2:
 *
 * 输入: [9,6,4,2,3,5,7,0,1]
 * 输出: 8
 * 说明:
 * 你的算法应具有线性时间复杂度。你能否仅使用额外常数空间来实现?
 * */
public class Main {

    public static void main(String[] args) {
	// write your code here
    }
    /**
     * 方法一：用时间换取空间
     * 创建一个nums.length+1的数组
     * 遍历nums，将出现的数字在ints中赋值为１
     * 再次遍历ints，找出不是1的下标
     * */
    public int missingNumber(int[] nums) {
        int[] ints = new int[nums.length+1];
        for (int i = 0; i < nums.length; i++) {
            ints[nums[i]] = 1;
        }

        for (int i = 0; i < ints.length; i++) {
            if (ints[i] != 1)
                return i;
        }
        return -1;
    }

    /**
     * 方法二：数学等差数列和
     * 遍历nums求出所有数的和sum
     * sum　-　（从０到nums.length+1的和）
     * */
    public int missingNumber１(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        return ((nums.length+1)*nums.length+1)/2 - sum;
    }


}
