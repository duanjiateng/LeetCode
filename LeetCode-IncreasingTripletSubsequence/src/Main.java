/*
递增的三元子序列

给定一个未排序的数组，判断这个数组中是否存在长度为 3 的递增子序列。

数学表达式如下:

如果存在这样的 i, j, k,  且满足 0 ≤ i < j < k ≤ n-1，
使得 arr[i] < arr[j] < arr[k] ，返回 true ; 否则返回 false 。
说明: 要求算法的时间复杂度为 O(n)，空间复杂度为 O(1) 。

示例 1:

输入: [1,2,3,4,5]
输出: true

示例 2:

输入: [5,4,3,2,1]
输出: false
 */
public class Main {

    public static void main(String[] args) {
	// write your code here
    }

    /*
    需要找到递增的三元子序列，需要一个二元组［first，second］,只要满足first＜second＜num，则说明找到三元子序列
     */
    public boolean increasingTriplet(int[] nums) {
        if (nums.length <= 3)
            return false;
        int first = Integer.MAX_VALUE, second = Integer.MAX_VALUE;
        for (int num: nums) {
            if (num < first) {
                first = num;
            } else if (num > first && num < second) {
                second = num;
            } else if (num > second) {
                return true;
            }
        }
        return false;
    }
}
