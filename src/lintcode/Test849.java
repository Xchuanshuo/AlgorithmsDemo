package lintcode;

import java.util.Stack;

/**
 * @author Legend
 * @data by on 19-4-14.
 * @description basic-calculator-iii
 */
public class Test849 {

    public int calculate(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        Stack<Character> ops = new Stack<>();
        s = s.replace(" ", "");
        int num = 0;
        for (int i = 0;i < s.length();i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
                if (i == s.length() - 1) stack.push(num);
            } else if ("+-*/".contains(String.valueOf(c))) {
                if (i > 0 && s.charAt(i-1) != ')') {
                    stack.push(num);
                    num = 0;
                }
                while (!ops.isEmpty() && getPriority(c) <= getPriority(ops.peek())) {
                    stack.push(eval(stack, ops.pop()));
                }
                ops.push(c);
            } else if (c == '(') {
                ops.push(c);
            } else if (c == ')') {
                if (i > 0 && s.charAt(i-1) != ')') {
                    stack.push(num);
                    num = 0;
                }
                while (ops.peek() != '(') {
                    stack.push(eval(stack, ops.pop()));
                }
                ops.pop();
            }
        }
        while (!ops.isEmpty()) {
            stack.push(eval(stack, ops.pop()));
        }
        return stack.pop();
    }

    private int getPriority(char c) {
        if (c == '(') return 0;
        if (c == '+' || c == '-') {
            return 1;
        }
        return 2;
    }

    private int eval(Stack<Integer> stack, char ops) {
        int num2 = stack.pop();
        int num1 = stack.pop();
        switch (ops) {
            case '+': return num1 + num2;
            case '-': return num1 - num2;
            case '*': return num1 * num2;
            case '/': return num1 / num2;
        }
        return 0;
    }

    public static void main(String[] args) {
        Test849 test = new Test849();
        System.out.println(test.calculate("((  (  (   1  *  10  )  -(  3 * 8) )   *   3  )   *   1   )"
        ));
    }
}
