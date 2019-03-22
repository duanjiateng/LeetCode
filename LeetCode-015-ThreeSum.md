## LeetCode-015-ThreeSum

### １．题目：

三数之和

给定一个包含 *n* 个整数的数组 `nums`，判断 `nums` 中是否存在三个元素 *a，b，c ，*使得 *a + b + c =* 0 ？找出所有满足条件且不重复的三元组。

**注意：**答案中不可以包含重复的三元组。

```
例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，

满足要求的三元组集合为：
[
  [-1, 0, 1],
  [-1, -1, 2]
]
```

### ２．解题：

​	首先将数组排序，因为我们知道三数之和必定有一个负数或者全为0，因此当我们拍完序后，如果最小值不为负数，那说明肯定不满足．

​	其次三数之和变量太多，我们可以将它看作为两数之和，条件`nums[i] + nums[j] + nums[k] = target(0)`，改变成`nums[j] + nums[k] = target - nums[i]`．（其中`i<j<k`）

​	接下来我们需要两个指针：`j:最大的数，初始值为数组末尾`和`k:中间数，初始值为i的下一个数`．

​	接下来有三种情况：

```
nums[j] + nums[k] = target - nums[i]　满足题意，找到一组解，则两指针向中间靠拢，继续找其他解．
nums[j] + nums[k] > target - nums[i]　说明大的值太大，让k指针向后移动
nums[j] + nums[k] < target - nums[i]　说明小的值太小，让j指针向前移动
```

#### 	代码：

```java
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        //将数组排序
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            //三数和为0，则其中至少有一个负数
            if (nums[i] > 0)
                break;
            //排除重复的情况
            if (i > 0 && nums[i] == nums[i-1])
                continue;
            //定义双指针
            int k = nums.length - 1;
            int j = i + 1;
            //两数之和的值
            int target = 0 - nums[i];
            while (j < k) {
                if (nums[j] + nums[k] == target) {
                    //asList() 将数组转换成集合
                    List<Integer> list = Arrays.asList(nums[i], nums[j], nums[k]);
                    result.add(list);
                    while (j < k && nums[k] == nums[k-1]) k--;
                    while (j < k && nums[j] == nums[j+1]) j++;
                    k--;
                    j++;
                } else if (nums[j] + nums[k] < target) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return result;
    }
}

```

