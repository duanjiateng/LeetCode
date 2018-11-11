package com.company;

/**
 * 移动零
 *
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 示例:
 *
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 *
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 * */
public class Main {

    public static void main(String[] args) {
	// write your code here
        int[] nums = {0, 1, 0, 12, 3};
        moveZeroes1(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(" " + nums[i]);
        }
    }
    /**
     * 遍历每一个元素
     *     若第i个元素为零时，与i后的第一个不为零的元素交换位置
     *
     * */
    public static void moveZeroes(int[] nums) {
        int temp, count;
        for (int i = 0; i < nums.length - 1; i++) {
            count = i + 1;
            if (nums[i] == 0) {
                while (nums[count] == 0) {
                    if (count == nums.length - 1) {
                        return ;
                    }
                    count++;
                }
                temp = nums[count];
                nums[count] = nums[i];
                nums[i] = temp;
            }
        }
    }

    /**
     * 遍历一边数组，找到所有非零元素
     * 将非零元素放到原数组前边,剩余元素为零
     * */
    public static void moveZeroes1(int[] nums) {
        int notZeroIndex = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (notZeroIndex != i) {
                    nums[++notZeroIndex] = nums[i];
                } else {
                    ++notZeroIndex;
                }
            }
        }
        for (notZeroIndex++; notZeroIndex < nums.length; notZeroIndex++) {
             nums[notZeroIndex] = 0;
        }

    }
}
