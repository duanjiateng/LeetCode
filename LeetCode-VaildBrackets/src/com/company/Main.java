package com.company;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 *  有效的括号
 *
 *
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * 示例 1:
 *
 * 输入: "()"
 * 输出: true
 * 示例 2:
 *
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 *
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 *
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 *
 * 输入: "{[]}"
 * 输出: true
 * */
public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println(isValid("()[]"));
    }

    public static boolean isValid(String s) {
        if (s == null || s.length() == 0)
            return true;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
                continue;
            }
            if (ch == ')') {
                if (stack.isEmpty() || !(stack.pop() == '(')) {
                    return false;
                }
            }

            if (ch == ']') {
                if (stack.isEmpty() || !(stack.pop() == '[')) {
                    return false;
                }
            }

            if (ch == '}') {
                if (stack.isEmpty() || !(stack.pop() == '{')) {
                    return false;
                }
            }
        }

        if (stack.isEmpty())
            return true;
        return false;
    }

    public static boolean isValid1(String s) {
        if (s == null || s.length() == 0)
            return true;
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
                continue;
            }
            if (stack.isEmpty() || !(stack.pop() == map.get(ch))) {
                return false;
            }
        }
        if (stack.isEmpty())
            return true;
        return false;
    }
}
