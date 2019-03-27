package lintcode;

import java.util.Stack;

/**
 * @author Legend
 * @data by on 19-3-26.
 * @description min-stack
 */
public class Test12 {

    class MinStack {

        private Stack<Integer> stack;
        private Stack<Integer> minStack;

        public MinStack() {
            this.stack = new Stack<>();
            this.minStack = new Stack<>();
        }

        public void push(int number) {
            stack.push(number);
            if (number <= min()) {
                minStack.push(number);
            }
        }

        public int pop() {
            int val = stack.pop();
            if (val == min()) {
                minStack.pop();
            }
            return val;
        }

        public int min() {
            if (minStack.isEmpty()) {
                return Integer.MAX_VALUE;
            }
            return minStack.peek();
        }
    }
}
