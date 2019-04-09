## LeetCode-166-分数到小数

### 1. 题目：

分数到小数

给定两个整数，分别表示分数的分子 numerator 和分母 denominator，以字符串形式返回小数。

如果小数部分为循环小数，则将循环的部分括在括号内。

**示例 1:**

```
输入: numerator = 1, denominator = 2
输出: "0.5"
```

**示例 2:**

```
输入: numerator = 2, denominator = 1
输出: "2"
```

**示例 3:**

```
输入: numerator = 2, denominator = 3
输出: "0.(6)"
```

### 2. 解题：

吐槽一句，这个题真是太多“坑”。

首先说一下整体思想，分成三部分处理：符号＋整数部分＋小数部分。

**符号**：让两数相乘与0比较。

​	注意：`int`类型的范围为，因为`Interger.MIN_VALUE * -1`的结果会溢出，所以先转换成`long`类型。

**整数部分**：取两数的绝对值，进行整数的除法运算。这时判断余数是否为`0`，若为`0`则说明只有整数部分，否则，有小数部分。

**小数部分**：计算小数时，看作整数除法运算，余数每次乘十，向前进一位。

计算小数部分有３种情况：
    １）不是循环小数，则退出条件为余数为0
    ２）纯循环小数，则小数部分全是循环体构成，只需找到循环体，加括号
    ３）混循环小数，则小数部分是由不循环部分与第一个循环节连成的数字组成的数，需要找到其分界线

对于解决循环问题，我们使用一个`HashMap<Long, Integer>`来存每一次的余数，如果出现相同的余数，则说明出现循环；`long`是余数，`Integet`是字符串中的索引。

我们需要两个变量`int index, int cycleIndex`，分别用来存小数部分每位的索引，以及出现循环的索引。

#### 代码：

```java
class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (denominator == 0) return null;
        if (numerator == 0) return "0";
        //符号
        String flag = "";
        //整数部分
        String integer;
        //小数部分
        StringBuilder dec = new StringBuilder();
        //索引
        int index = 0;
        //循环索引
        int cycleIndex = -1;
        /**
         * 使用map存余数，如果余数存在则说明出现循环
         * Long: 余数
         * Integer: 余数的索引
         */
        Map<Long, Integer> map = new HashMap<>();
        //注意int类型的溢出,Integer.MIN_VALUE / -1
        long denominatorL = (long)denominator;
        long numeratorL = (long)numerator;
        //正负号
        if (numeratorL * denominatorL < 0) {
            flag = "-";
        }
        //取绝对值
        denominatorL = (long)Math.abs(denominatorL);
        numeratorL = (long)Math.abs(numeratorL);
        //整数部分
        integer = String.valueOf(numeratorL / denominatorL);
        //取余数
        numeratorL %= denominatorL;

        //只有整数
        if (numeratorL == 0) {
            return flag + integer;
        }
        
        /**
         * 计算小数部分时，将其看做整数除法，每次将分母向前移一位
         * 计算小数部分有３种情况：
         * 　１）不是循环小数，则退出条件为余数为０
         * 　２）纯循环小数，则小数部分全是循环体构成，只需找到循环体，加括号
         * 　３）混循环小数，则小数部分是由不循环部分与第一个循环节连成的数字组成的数，需要找到其分界线
         */
        map.put(numeratorL, index++);
        while (numeratorL != 0 && cycleIndex == -1) {
            numeratorL *= 10;
            dec.append(numeratorL/denominatorL);
            numeratorL %= denominatorL;
            if (map.containsKey(numeratorL)) {
                cycleIndex = map.get(numeratorL);
                break;
            }
            map.put(numeratorL, index++);
        }
        //不是循环小数
        if (cycleIndex == -1) {
            return flag + integer + "." + dec.toString();
        } else {
            return flag + integer + "." + dec.toString().substring(0, cycleIndex) + "(" + dec.toString().substring(cycleIndex) + ")";
        }
    }
}
```

