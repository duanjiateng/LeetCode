import java.util.Stack;

public class Solution {
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
