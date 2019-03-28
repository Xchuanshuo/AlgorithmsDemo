package lintcode;

import java.util.Stack;

/**
 * @author Legend
 * @data by on 19-3-28.
 * @description evaluate-reverse-polish-notation
 */
public class Test424 {

    public int evalRPN(String[] tokens) {
        // write your code here
        Stack<Integer> stack = new Stack<>();
        for (String str : tokens) {
            if (!"+-*/".contains(str)) {
                stack.push(Integer.valueOf(str));
            } else {
                int val1 = stack.pop();
                int val2 = stack.pop();
                if (str.equals("+")) {
                    stack.push(val1 + val2);
                } else if (str.equals("*")) {
                    stack.push(val1 * val2);
                } else if (str.equals("/")) {
                    stack.push(val2 / val1);
                } else if (str.equals("-")) {
                    stack.push(val2 - val1);
                }
            }
        }
        return stack.pop();
    }
}
