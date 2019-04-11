package lintcode;

import java.util.Stack;

/**
 * @author Legend
 * @data by on 19-4-11.
 * @description basic-calculator-ii
 */
public class Test980 {

    public int calculate(String s) {
        // Write your code here
        Stack<Integer> stack = new Stack<>();
        Stack<Character> ops = new Stack<>();
        s = s.trim();
        int num = 0;
        for (int i = 0;i < s.length();i++) {
            char cur = s.charAt(i);
            if (Character.isDigit(cur)) {
                num = num * 10 + cur - '0';
                if (i == s.length() -1) stack.push(num);
            } else if ("+-*/".contains(String.valueOf(cur))) {
                stack.push(num);
                num = 0;
                if (!ops.isEmpty() && getPriority(ops.peek()) < getPriority(cur)) {
                    ops.push(cur);
                    continue;
                }
                while (!ops.isEmpty() && getPriority(ops.peek()) >= getPriority(cur)) {
                    stack.push(eval(stack, ops.pop()));
                }
                ops.push(cur);
            }
        }
        while (!ops.isEmpty()) {
            stack.push(eval(stack, ops.pop()));
        }
        return stack.pop();
    }

    private int eval(Stack<Integer> stack, char ops) {
        int num2 = stack.pop();
        int num1 = stack.pop();
        switch (ops) {
            case '+': return num1 + num2;
            case '-': return num1 - num2;
            case '*': return num1 * num2;
            case '/': return num1 / num2;
            default: return 0;
        }
    }

    private int getPriority(char c) {
        if (c == '+' || c =='-') {
            return 1;
        }
        return 2;
    }

    public static void main(String[] args) {
        Test980 test = new Test980();
        System.out.println(test.calculate("3+26*2"));
    }
}
