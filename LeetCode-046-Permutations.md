## LeetCode-046-Permutations

### １．题目：

全排列

给定一个**没有重复**数字的序列，返回其所有可能的全排列。

**示例:**

```
输入: [1,2,3]
输出:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
```

### ２．解题：

​	这是全排列问题，需要找出所有符合条件的结果，所以我们可以使用**回溯算法**，我们来考虑回溯三要素：

​	*选择：选择的对象是数列中的每个元素，可以使用for循环；*

​	*限制：list中不能出现重复的元素；*

​	*退出条件：当list.size() == nums.length时，将list的值加入到解集中lists．*

#### 	代码

```java
class Solution {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        permuteDFS(result, new ArrayList<>(), nums);
        return result;
    }

    /**
     *
     * @param lists 解集
     * @param list 当前解集的值
     * @param nums 需要被排序的数列
     */
    private static void permuteDFS(List<List<Integer>> lists, List<Integer> list, int[] nums) {
        //退出条件
        if (list.size() == nums.length) {
            /*
            * 这里一定要重新创建ArrayList对象，不能直接添加list
            * 因为下边的list.remove(list.size() - 1);会改变list中的数据．
            */
            lists.add(new ArrayList<>(list));
            return;
        }
 		//遍历数列       
        for (int i = 0; i < nums.length; i++) {
            if (!list.contains(nums[i])) {
                list.add(nums[i]);
                permuteDFS(lists, list, nums);
                list.remove(list.size() - 1);
            }
        }
    }
}
```

####   