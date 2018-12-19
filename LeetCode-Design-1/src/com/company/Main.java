package com.company;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

/**
 *   Shuffle an Array
 *   
 * 打乱一个没有重复元素的数组。
 *
 * 示例:
 *
 * // 以数字集合 1, 2 和 3 初始化数组。
 * int[] nums = {1,2,3};
 * Solution solution = new Solution(nums);
 *
 * // 打乱数组 [1,2,3] 并返回结果。任何 [1,2,3]的排列返回的概率应该相同。
 * solution.shuffle();
 *
 * // 重设数组到它的初始状态[1,2,3]。
 * solution.reset();
 *
 * // 随机返回数组[1,2,3]打乱后的结果。
 * solution.shuffle();
 * */
public class Main {

    private int[] nums;
    private Random random;

    public static void main(String[] args) {
	// write your code here
        int[] nums = {1, 2, 3};
        Main m = new  Main(nums);
        display(m.reset());
        display(m.shuffle());
        display(m.shuffle());
        display(m.shuffle());
        display(m.shuffle());
    }

    public static void display(int[] nums) {
        System.out.print("[ ");
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.print("]");
        System.out.println();
    }

    public Main(int[] nums) {
        this.nums = nums;
        random = new Random(System.currentTimeMillis());
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return this.nums;
    }

    /** Returns a random shuffling of the array. */
    /**
     * 使用Random随机将下标找出来
     * 将copy[i],copy[]
     * */
    public int[] shuffle() {
        int[] copy = Arrays.copyOf(nums, nums.length);
        for (int i = 1; i < copy.length; i++) {
            int index = random.nextInt(i + 1);
            int temp = copy[index];
            copy[index] = copy[i];
            copy[i] = temp;
        }
        return copy;
    }

}
