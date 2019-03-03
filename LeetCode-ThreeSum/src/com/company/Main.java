package com.company;

import java.util.*;

/*
三数之和

给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。

注意：答案中不可以包含重复的三元组。

例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，

满足要求的三元组集合为：
[
  [-1, 0, 1],
  [-1, -1, 2]
]
*/
public class Main {

    public static void main(String[] args) {
	// write your code here
    }

    /*
        假设确定nums[i]，将三数和转变成两数和:
        条件nums[i] + nums[j] + nums[k] = target(0)，改变成 nums[j] + nums[k] = target - nums[i]
        将原数组排序，i坐标从最小的出发，k坐标从i+1出发，j坐标从最大出发
        先确定i，找到所有满足的k和j后，i++，然后此时j更新到最大坐标处，k更新到i+1处
        其次，要满足排重，满足num[i]不等于num[i+1]
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0)
                break;
            if (i > 0 && nums[i] == nums[i-1])
                continue;
            int j = nums.length - 1;
            int k = i + 1;
            int target = 0 - nums[i];
            while (k < j) {
                if (nums[k] + nums[j] == target) {
                    List<Integer> list = Arrays.asList(nums[i], nums[k], nums[j]);
                    result.add(list);
                    while (k < j && nums[k] == nums[k+1]) k++;
                    while (k < j && nums[j] == nums[j-1]) j--;
                    k++;
                    j--;
                } else if (nums[k] + nums[j] < target) {
                    k++;
                } else {
                    j--;
                }
            }
        }
        return result;
    }
}
