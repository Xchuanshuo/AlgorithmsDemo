package lintcode;

import java.util.*;

/**
 * @author Legend
 * @data by on 19-3-28.
 * @description valid-parentheses
 */
public class Test423 {

    public boolean isValidParentheses(String s) {
        // write your code here
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if ("([{".contains(String.valueOf(c))) {
                stack.push(c);
            } else {
                if (!stack.isEmpty() && isValid(stack.peek(), c)) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    private boolean isValid(char c1, char c2) {
        return (c1 == '(' && c2 == ')') || (c1 == '{' && c2 == '}')
                || (c1 == '[' && c2 == ']');
    }
}
