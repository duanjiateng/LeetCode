## LeetCode-1020-将数组分成和相等的三个部分

1. ### 题目：

   给定一个整数数组 `A`，只有我们可以将其划分为三个和相等的非空部分时才返回 `true`，否则返回 `false`。

   形式上，如果我们可以找出索引 `i+1 < j` 且满足 `(A[0] + A[1] + ... + A[i] == A[i+1] + A[i+2] + ... + A[j-1] == A[j] + A[j-1] + ... + A[A.length - 1])` 就可以将数组三等分。

   

   **示例 1：**

   ```
   输出：[0,2,1,-6,6,-7,9,1,2,0,1]
   输出：true
   解释：0 + 2 + 1 = -6 + 6 - 7 + 9 + 1 = 2 + 0 + 1
   ```

   **示例 2：**

   ```
   输入：[0,2,1,-6,6,7,9,-1,2,0,1]
   输出：false
   ```

   **示例 3：**

   ```
   输入：[3,3,6,5,-2,2,5,1,-9,4]
   输出：true
   解释：3 + 3 = 6 = 5 - 2 + 2 + 5 + 1 - 9 + 4
   ```

    

   **提示：**

   1. `3 <= A.length <= 50000`
   2. `-10000 <= A[i] <= 10000`

2. ### 解题：

   暴力解法，用两次循环，缺陷：时间复杂度`O(n^2)`。

   首先定义两个指针`first, second`用来将数组分成三段(`[0, first-1],[first, second-1],[second, length-1]`)。然后进行两次循环遍历所有情况。

   判断`sum([0, first-1]) == sum([first, second-1]) == sum([second, length-1])`如果满足条件，则返回`true`。

   #### 代码：

   ```java
   	public static boolean canThreePartsEqualSum(int[] A) {
           int first;
           int second = 2;
           int len = A.length;
           for (first = 1; first < second; first++) {
               for (second = first+1; second < len; second++) {
                   if (getSum(A, 0, first-1) == getSum(A, first, second-1) &&
                           getSum(A, first, second-1) == getSum(A, second, len-1)) {
                       return true;
                   }
               }
           }
           return false;
       }
   	//求和函数
   	private static int getSum(int[] nums, int start, int end) {
           int sum = 0;
           for (int i = start; i <= end; i++) {
               sum += nums[i];
           }
           return sum;
       }
   ```

   3. ### 优化：

      上一个解法时间复杂度不符合题意，因此我们需要考虑时间复杂度`O(n)`。

      我们需要将数组分成和相同三部分，说明两点：

      ​	１．该数组的和可以被３整除。

      ​	２．每个部分的和＝数组总和的三分之一。

      因此，我们只需要从`A[0]`开始累加，当累加和＝sum的三分之一，记录一次，重新从下一个累加，看是否`count == 3`;

      需要注意的是：最后一个元素累加后退出循环，如果在此之前没有找出答案，需要在循环外进行一次判断。

      #### 代码：

      ```java
      class Solution {
          public boolean canThreePartsEqualSum(int[] A) {
              int sum = 0;
              int count = 0;
              //求总和
              for (int i = 0; i < A.length; i++) {
                  sum += A[i]; 
              }
              //判断能否被3整除
              if ( sum % 3 == 0) {
                  //为了方便找出每一部分
                  sum /= 3;
                  //临时部分和
                  int temp = A[0];
                  for (int i = 1; i < A.length; i++) {
                      if (temp == sum) { //找到一部分
                          temp = A[i];
                          if (++count == 3 && A[i] != 0) {
                              return true;                        
                          }
                      } else {
                          temp += A[i];
                      }
                  }
                  //最后一个元素相加后没有进行判断，需要单独判断
                  return count == 2 && temp == sum;
              }
              return false;
          }
      }
      ```

      