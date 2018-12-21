package com.company;

import java.util.Stack;

/**
 * 最小栈
 * 
 * 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 * push(x) -- 将元素 x 推入栈中。
 * pop() -- 删除栈顶的元素。
 * top() -- 获取栈顶元素。
 * getMin() -- 检索栈中的最小元素。
 * 示例:
 *
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 * */
public class Main {
    Stack<Integer> stack;
    Stack<Integer> minStack;

    public static void main(String[] args) {
	// write your code here
        Main main = new Main();
        main.push(-2);
        main.push(-0);
        main.push(-3);
        System.out.println(main.getMin());
        main.pop();
        main.pop();
        System.out.println(main.getMin());

//        main.push(2147483646);
//        main.push(2147483646);
//        main.push(2147483647);
//        main.top();
//        main.pop();
//        System.out.println(main.getMin());
//        main.pop();
//        System.out.println(main.getMin());
//        main.pop();
//        main.push(2147483647);
//        main.top();
//        System.out.println(main.getMin());
//        main.push(-2147483648);
//        main.top();
//        System.out.println(main.getMin());
//        main.pop();
//        System.out.println(main.getMin());


    }

    /** initialize your data structure here. */
    public Main() {
        this.stack = new Stack<>();
        this.minStack = new Stack<>();
    }

    public void push(int x) {
        if (minStack.isEmpty() || minStack.peek().intValue() >= x){
            minStack.push(x);
        }
        stack.push(x);
    }

    public void pop() {
        if (minStack.isEmpty() || stack.isEmpty())
            return;

        if (stack.peek().intValue() == minStack.peek().intValue()) {
            minStack.pop();
            System.out.println("aaa");
        }
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

    /**
     * Your MinStack object will be instantiated and called as such:
     * MinStack obj = new MinStack();
     * obj.push(x);
     * obj.pop();
     * int param_3 = obj.top();
     * int param_4 = obj.getMin();
     */

}
