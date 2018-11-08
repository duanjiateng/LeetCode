package com.company;


/**
 * 旋转数组
 *
 * 
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 *
 * 示例 1:
 *
 * 输入: [1,2,3,4,5,6,7] 和 k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 * 示例 2:
 *
 * 输入: [-1,-100,3,99] 和 k = 2
 * 输出: [3,99,-1,-100]
 * 解释:
 * 向右旋转 1 步: [99,-1,-100,3]
 * 向右旋转 2 步: [3,99,-1,-100]
 * 说明:
 *
 * 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
 * 要求使用空间复杂度为 O(1) 的原地算法。
 * */
public class Main {

    public static void main(String[] args) {
	// write your code here
    }

    /**
     * 每次移动1个位置
     * 移动k次
     * */
    public void rotate(int[] nums, int k) {
        int temp, kk;
        kk = k%nums.length;
        for (int i = 0; i < kk; i++) {
            temp = nums[nums.length-1];
            for (int j = nums.length-1; j > 0; j--) {
                nums[j] = nums[j-1];
            }
            nums[0] = temp;
        }
    }

    /**
     * 新建一个等大数组，用空间换取时间
     * */
    public void rotate2(int[] nums, int k) {
        int[] new_nums = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            new_nums[(i+k)%nums.length] = nums[i];
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = new_nums[i];
        }
    }

    /**
     * 通过三次倒置，来实现数组的旋转
     * 假设数组    0 1 2 3 4 5 6
     * k = 2
     * 结果       5 6 0 1 2 3 4
     *
     * 以length-k为界限，将数组分为两部分 0 1 2 3 4 ， 5 6
     * 现将前部分倒置 4 3 2 1 0 5 6
     * 再将后部分倒置 4 3 2 1 0 6 5
     * 将整个部分倒置 5 6 0 1 2 3 4
     *
     * */
    public void rotate3(int[] nums, int k) {
        int len = nums.length;
        int t = k%len;
        int m = len - t;
        reverse(nums, 0, m-1);
        reverse(nums, m, len-1);
        reverse(nums, 0, len-1);
    }
    private void reverse(int[] nums, int begin, int end) {
        int b = begin;
        int e = end;
        int temp;
        while (b < e) {
            temp = nums[e];
            nums[e] = nums[b];
            nums[b] = temp;
            b++;
            e--;
        }

    }




}
