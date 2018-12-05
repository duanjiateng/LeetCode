package com.company;
/**
 * 合并两个有序数组
 *
 *
 * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 *
 * 说明:
 *
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 * 示例:
 *
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 *
 * 输出: [1,2,2,3,5,6]
 * */
public class Main {

    public static void main(String[] args) {
	// write your code here
        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
        int[] nums2 = new int[]{2, 5, 6};
        merge(nums1, 3, nums2, 3);
    }
    /**
     * 使用额外空间
     * 将nums1 和 nums2放在nums3中
     * */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] nums3 = new int[m+n];
        int i = 0, j = 0, count = 0;
        while (i < m && j < n) {
            if (nums1[i] <= nums2[j]) {
                nums3[count++] = nums1[i++];
            } else {
                nums3[count++] = nums2[j++];
            }
        }
        while (i < m) {
            nums3[count++] = nums1[i++];
        }

        while (j < n) {
            nums3[count++] = nums2[j++];
        }
        for (int k = 0; k < nums3.length; k++) {
            nums1[k] = nums3[k];
        }
    }
    /**
     * 直接在nums1上操作
     *
     * 从后往前操作，可以减少操作次数
     *
     * */
    public static void merge１(int[] nums1, int m, int[] nums2, int n) {
        //nums1为空，则将nums2给nums1
        if (m == 0 && n >0) {
            for (int i = 0; i < n; i++) {
                nums1[i] = nums2[i];
            }
        }
        int i = m-1, j = n-1;
        while (i >= 0 && j >= 0) {
            if (nums2[j] > nums1[i]) {
                nums1[i+j+1] = nums2[j--];
                continue;
            }
            nums1[i+j+1] = nums1[i--];
        }
        while (j >= 0) {
            nums1[j] = nums2[j--];
        }
        
    }
}
