## LeetCode-347-TopKFrequentElements

### １.题目：

前K个高频元素

给定一个非空的整数数组，返回其中出现频率前 **k** 高的元素。

**示例 1:**

```
输入: nums = [1,1,1,2,2,3], k = 2
输出: [1,2]
```

**示例 2:**

```
输入: nums = [1], k = 1
输出: [1]
```

**说明：**

- 你可以假设给定的 *k* 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
- 你的算法的时间复杂度**必须**优于 O(*n* log *n*) , *n* 是数组的大小。

### ２.解题：

​	要求我们找到数组中出现频率最高的前k的元素，因此我们需要知道每个元素出现的次数。

​	我们选择使用`Map<key, value>`来存数组中的元素和其出现的次数。

​	我们需要按照`value`来排序，为了满足时间复杂度 O(*n* log *n*) ，我们选择使用大顶堆排序（`PriorityQueue`）。我们要注意的是：`PriorityQueue`默认是小顶堆，因此我们需要重写一个新的比较器。

​	然后将`queue`中的前ｋ个元素拿出来放入`List`中。

#### 	代码：

```java
class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        //结果List
        List<Integer> result = new ArrayList<>();
        //map用来存放数组中元素和其出现次数的映射
        Map<Integer, Integer> map = new HashMap<>();
		//使用大顶堆对map中元素排序
        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>(new Comparator<Map.Entry<Integer, Integer>>() {
            //重写比较器
            @Override
            public int compare(Map.Entry<Integer, Integer> t1, Map.Entry<Integer, Integer> t2) {
                return t2.getValue() - t1.getValue();
            }
        });
		//遍历数组
        for (int num : nums) {
            if (!map.containsKey(num)) {　//map中不存在该元素
                map.put(num, 1);
            } else {
                //map中存在该元素
                map.put(num, map.get(num)+1);
            }
        }
		//将map中的元素放入大顶堆中
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            queue.offer(entry);
        }
		//取出大顶堆中的前k个元素
        for (int i = 0; i < k; i++) {
            result.add(queue.poll().getKey());
        }
        return result;
    }
}
```

