package com.company;


import java.lang.reflect.Array;
import java.util.*;

/*
字谜分组
给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。

示例:

输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
输出:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]
说明：

所有输入均为小写字母。
不考虑答案输出的顺序。
 */
public class Main {

    public static void main(String[] args) {
	// write your code here
        String[] strings = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(strings));
    }
    /*
    将String转化成char[]，利用数组的排序，具有相同字母的单词排序后会得到相同的字符串
    使用map(key,value)来存放排序后的字符串和List
     */
    public static List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0)
            return new ArrayList<>();

        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String keyStr = String.valueOf(chars);
            if (!map.containsKey(keyStr)) {
                map.put(keyStr, new ArrayList<>());
            }                                                    
            map.get(keyStr).add(str);
        }

        return new ArrayList<>(map.values());
        


    }
}
