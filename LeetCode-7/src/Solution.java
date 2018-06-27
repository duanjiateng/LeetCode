import java.util.Stack;

/**
 * 给定一个 32 位有符号整数，将整数中的数字进行反转。
 *
 * 示例 1:
 *
 * 输入: 123
 * 输出: 321
 *  示例 2:
 *
 * 输入: -123
 * 输出: -321
 * 示例 3:
 *
 * 输入: 120
 * 输出: 21
 * 注意:
 *
 * 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231,  231 − 1]。根据这个假设，如果反转后的整数溢出，则返回 0。
 *
 *
 * */






public class Solution {
    /**
     * 将整数转化为字符串
     * 将字符串压栈
     * 判断栈顶非0
     * 出栈
     * 字符串 换成  整数
     *
     * */

    public static int reverse(int x) {
        int i = 0, state = 0;
        if (0 == x)
            return x;



        String s = Integer.toString(x);
        Stack<Character> stack = new Stack<>();
        if (s.charAt(0) == '-'){
            i = 1;
            state = 1;
        }

        for (; i<s.length(); i++){
            stack.push(s.charAt(i));
        }

        while (stack.peek() == '0'){
            stack.pop();
        }

        StringBuilder strB = new StringBuilder();

        while (!stack.empty()) {
            strB.append(stack.pop());
        }

        long anwser = Long.parseLong(strB.toString());
        if (anwser > Integer.MAX_VALUE){
            return 0;
        }

        if(state == 1){
            anwser *= -1;
        }

        return anwser;
    }

    public static void main(String[] args) {
        int a = 1000;
        System.out.println(reverse(a));
    }
}
