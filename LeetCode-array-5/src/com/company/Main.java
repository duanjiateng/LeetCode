package com.company;

import java.util.Arrays;

/**
 * 只出现一次的数字
 *
 * 
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 *
 * 说明：
 *
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 *
 * 示例 1:
 *
 * 输入: [2,2,1]
 * 输出: 1
 * 示例 2:
 *
 * 输入: [4,1,2,1,2]
 * 输出: 4
 * */
public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println(1 ^ 0);
    }

    /**
     * 先排序
     * 分三种情况：
     *      1.数组的第一个数为结果，当数组第一个数和第二个数不相等时 或 数组只有一个元素时
     *      2.数组中间的任何一个元素，当 一个元素 与 它的前一个和后一个都不相等时
     *      3.数组的最后一个元素，当数组的最后一个元素与它的前一个元素不相等时
     * */
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);

        if(nums.length == 1 || nums[0] != nums[1])
            return nums[0];
        for (int i = 1; i < nums.length-1; i++) {
            if(nums[i-1] != nums[i] && nums[i] != nums[i+1])
                return nums[i];
        }
        return nums[nums.length-1];
    }

    /**
     * 一个值 出现一次
     * 其余值 出现两次
     * 使用 ^(异或)，
     *      对一个数使用两次异或则还是原来的数
     *      0异或一个数 = 这个数本身
     * */
    public int singleNumber1(int[] nums) {
        int number = 0;
        for (int i = 0; i < nums.length; i++) {
            number ^= nums[i];
        }

        return number;

    }
}
