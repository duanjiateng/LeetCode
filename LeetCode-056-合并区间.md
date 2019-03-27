## LeetCode-056-合并区间

### １．题目：

合并区间

给出一个区间的集合，请合并所有重叠的区间。

**示例 1:**

```
输入: [[1,3],[2,6],[8,10],[15,18]]
输出: [[1,6],[8,10],[15,18]]
解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
```

**示例 2:**

```
输入: [[1,4],[4,5]]
输出: [[1,5]]
解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
```

### ２．解题：

- 将`intervals`按照每个区间的`start`进行从大到小排序。我们使用`Collections.sort()`方法，但是需要重写`Comparator`的`compare()`方法。

- 将`intervals`的第一个元素放入解集`result`中。

- 遍历`intervals`剩下的元素，若当前元素的`start`≥解集最后一个元素的`end`,说明这两个区间存在重叠，进行合并（将解集最后一个元素的`end`取这两个区间中最大的）。

- 否则，说明不存在重叠，则将当前元素添加到`result`中。

  #### 	代码：

  ```java
  /**
   * Definition for an interval.
   * public class Interval {
   *     int start;
   *     int end;
   *     Interval() { start = 0; end = 0; }
   *     Interval(int s, int e) { start = s; end = e; }
   * }
   */
  class Solution {
      public List<Interval> merge(List<Interval> intervals) {
          //解集
          List<Interval> result = new ArrayList<>();
  
          if (intervals == null || intervals.size() == 0) {
              return result;
          }
  		//按区间的start进行排序
          Collections.sort(intervals, new Comparator<Interval>() {
              @Override
              public int compare(Interval in1, Interval in2) {
                  return in1.start - in2.start;
              }
          });
  
          result.add(intervals.get(0));
          for (int i = 1; i < intervals.size(); i++) {
              //当前区间
              Interval temp = intervals.get(i);
              //解集的最后一个区间
              Interval resLast = result.get(result.size() - 1);
              if (temp.start <= resLast.end) {
                  //存在重叠
                  resLast.end = (resLast.end > temp.end) ? resLast.end : temp.end;
                  result.set(result.size() - 1, resLast);
              } else {
                  //不存在重叠
                  result.add(temp);
              }
          }
          return result;
      }
  }
  ```

  