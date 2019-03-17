## LeetCode-017-LetterCombinationOfAPhoneNumber

### １．题目：

电话号码的字母组合



给定一个仅包含数字 `2-9` 的字符串，返回所有它能表示的字母组合。

给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。

![img](http://upload.wikimedia.org/wikipedia/commons/thumb/7/73/Telephone-keypad2.svg/200px-Telephone-keypad2.svg.png)

**示例:**

```
输入："23"
输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
```

**说明:**
尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。

### ２．解答

​	需要找出所有数字所对应的字母的自由组合，实际上就是一个求全排列的问题，使用递归算法来求解，需要考虑退出问题．

​	第一步：拿出当前字符串第一个字符（数字），找出其所对应的所有字母`firstNum`；

​	第二步：取当前字符串的除去第一个字符的剩下的字符串；

​	第三步：对新的字符串进行`letterCombinations()`处理得到`leftNum`；

​	第四步：将`firstNum`和 `leftNum`的元素自由组合；

​	第五步：退出条件是当字符串只有一个元素的时候，返回当前字符串的一个字符对应的字母的`String[]`.

​	代码：

```java
class Solution {
    //数字对应的字母表
    public static String[][] letterTable = new String[][]{
            {"a", "b", "c"},
            {"d", "e", "f"},
            {"g", "h", "i"},
            {"j", "k", "l"},
            {"m", "n", "o"},
            {"p", "q", "r", "s"},
            {"t", "u", "v"},
            {"w", "x", "y", "z"},
    };
    
    
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.length() == 0)
            return result;

        //利用ASCLL,将char转化成int类型的索引，找到当前第一个字符对应的letterTable
        String[] firstNum = letterTable[digits.charAt(0) - 48 - 2];

        //当前字符串只有一个
        if (digits.length() == 1) {
            result.addAll(Arrays.asList(firstNum));
            return result;
        }

        //使用递归，回溯处理除去当前第一个字符的字符串
        List<String> leftNum = letterCombinations(digits.substring(1));

        //将firstNum 和 leftNum的元素自由组合
        for (String str : firstNum ) {
            for (String str2 : leftNum) {
                result.add(str + str2);
            }
        }
        return result;
    }
}
```

