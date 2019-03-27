package lintcode;

import java.util.Stack;

/**
 * @author Legend
 * @data by on 19-3-26.
 * @description implement-queue-by-two-stacks
 */
public class Test40 {

    class MyQueue {

        private Stack<Integer> inStack;
        private Stack<Integer> outStack;

        public MyQueue() {
            this.inStack = new Stack<>();
            this.outStack = new Stack<>();
        }

        public void push(int element) {
            inStack.push(element);
        }

        public int pop() {
            operate();
            return outStack.pop();
        }

        private void operate() {
            if (outStack.isEmpty()) {
                while (!inStack.isEmpty()) {
                    outStack.push(inStack.pop());
                }
            }
        }

        public int top() {
            operate();
            return outStack.peek();
        }
    }
}
