package lintcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Legend
 * @data by on 19-3-28.
 * @description convert-expression-to-reverse-polish-notation
 */
public class Test370 {

    public List<String> convertToRPN(String[] expression) {
        // write your code here
        List<String> result = new ArrayList<>();
        Stack<Character> stack = new Stack<>();
        for (String str: expression) {
            char c = str.charAt(0);
            if (Character.isDigit(c)) {
                result.add(str);
            } else {
                switch (c) {
                    case '+':
                    case '-':
                    case '*':
                    case '/':
                    case '^':
                        while (!stack.isEmpty() && priority(c) <= priority(stack.peek())) {
                            result.add(String.valueOf(stack.pop()));
                        }
                        stack.push(c);
                        break;
                    case '(':
                        stack.push(c);
                        break;
                    case ')':
                        while (!stack.isEmpty() && stack.peek() != '(') {
                            result.add(String.valueOf(stack.pop()));
                        }
                        stack.pop();
                        break;
                }
            }
        }
        while (!stack.isEmpty()) {
            result.add(String.valueOf(stack.pop()));
        }
        return result;
    }

    private int priority(char c) {
        String s = String.valueOf(c);
        if ("+-".contains(s)) {
            return 0;
        }
        if ("*/".contains(s)) {
            return 1;
        }
        if ("^".contains(s)) {
            return 2;
        }
        return -1;
    }

    public static void main(String[] args) {
        String[] express = {"3","-","4","+","5"};
        Test370 test = new Test370();
        System.out.println(test.convertToRPN(express));
    }
}
