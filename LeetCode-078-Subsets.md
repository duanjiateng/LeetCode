## LeetCode-078-Subsets

### １．题目：

子集

给定一组**不含重复元素**的整数数组 *nums*，返回该数组所有可能的子集（幂集）。

**说明：**解集不能包含重复的子集。

**示例:**

```
输入: nums = [1,2,3]
输出:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
```

### ２．解题

​	这是一个传统的求集合子集的问题，需要注意：不要忘掉空子集；集合中不能有重复元素，包括子集也不能有重复元素．

​	对于这道题我们可以使用递归的思想解答：

​	我们先来观察几组结果

```
输入：nums = [];
结果：[[]];

输入：nums = [1];
结果：[[],
	  [1]
	 ];
	 
输入：nums = [1, 2];
结果：[
      [],
      [1],
      [2],
      [1, 2],
	 ]
```

​	我们发现，实际上`nums = [1]`的解就是在`num = []`的所有解上加上`1`；`nums = [1, 2]`的解就是在`num = [1]`的所有解上加上`2`；所以我们只需要遍历`nums`中的每一个元素，并将解集`result`中的每一个解加上`num[i]`作为新的解集添加到新的解集中．

#### 	代码：

```java
class Solution {
	public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        //先添加空子集
        result.add(new ArrayList<>());
        //遍历每一个元素
        for (int i = 0; i < nums.length; i++) {
            //添加新的子集
            subsetsAppend(result, nums[i]);
        }
        return result;
    }
    /**
     *
     * @param lists 解集
     * @param num 被添加的元素
     */
    private static void subsetsAppend(List<List<Integer>> lists, int num) {
        //需要记录子＝解集进入函数时的长度，下边会向子＝解集中添加新的解，会导致长度改变
        int len = lists.size();
        for (int i = 0; i < len; i++) {
            //得到新的解
            List<Integer> temp = new ArrayList<>(lists.get(i));
            temp.add(num);
            lists.add(temp);
        }
    }
}
```

