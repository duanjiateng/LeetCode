package com.company;

import java.util.Arrays;

/**
 * 两个数组的交集 II
 * 给定两个数组，编写一个函数来计算它们的交集。
 *
 * 示例 1:
 *
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2,2]
 * 示例 2:
 *
 * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出: [4,9]
 * 说明：
 *
 * 输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
 * 我们可以不考虑输出结果的顺序。
 * 进阶:
 *
 * 如果给定的数组已经排好序呢？你将如何优化你的算法？
 * 如果 nums1 的大小比 nums2 小很多，哪种方法更优？
 * 如果 nums2 的元素存储在磁盘上，磁盘内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
 * 
 * */
public class Main {

    public static void main(String[] args) {
	// write your code here
        int i = 0;
        System.out.println(i++);
    }
    /**
     * 用两个for循环遍历
     * 遍历nums1中的每一个元素，在nums2中查找是否有相同的。
     *
     * */
    public int[] intersect(int[] nums1, int[] nums2) {

        if(nums1 == null || nums2 == null)
            return null;
        
        int size, count = 0;    /* size:nums1, nums2 长度中最大的； count： 交集中的个数 */
        size = (nums1.length > nums2.length) ? nums1.length : nums2.length;
        int[] anwser = new int[size];
        int[] temp = new int[nums2.length];     /* 用来标识已经加入到交集集合中的元素，加入到交集中 设置为1 */

        for (int i=0; i<nums1.length; i++) {

            for (int j=0; j<nums2.length; j++) {
                if (nums1[i] == nums2[j] && temp[j] != 1) {
                    anwser[count++] = nums1[i];
                    temp[j] = 1;
                    break;
                }
            }
        }
        int[] result = new  int[count];
        for (int i = 0; i < count; i++) {
            result[i] = anwser[i];
        }

        return result;
    }

    public int[] intersect2(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int len1 = nums1.length;
        int len2 = nums2.length;
        int i = 0, j = 0, count = 0;
        int[] anwser = new int[len1];

        while (len1 > i && len2 > j) {
            if (nums1[i] == nums2[j]) {
                anwser[count++] = nums1[i];
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }

        int[] result = new  int[count];
        for (int k = 0; k < count; k++) {
            result[k] = anwser[k];
        }

        return result;
    }
}
