package lintcode;

import java.util.Stack;

/**
 * @author Legend
 * @data by on 19-4-9.
 * @description expression-evaluation
 */
public class Test368 {

    public int evaluateExpression(String[] expression) {
        // write your code here
        if (expression == null || expression.length == 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        Stack<String> ops = new Stack<>();
        for (String s : expression) {
            if(!"+-*/()".contains(s)) {
                stack.push(Integer.valueOf(s));
            } else if ("(".equals(s)) {
                ops.push(s);
            } else if (")".equals(s)) {
                while (!ops.isEmpty() && !ops.peek().equals("(")) {
                    stack.push(evaluate(stack, ops.pop()));
                }
                ops.pop();
            } else {
                if ("+-".contains(s)) {
                    while (!ops.isEmpty() && "+-*/".contains(ops.peek())) {
                        stack.push(evaluate(stack, ops.pop()));
                    }
                } else {
                    while (!ops.isEmpty() && "*/".contains(ops.peek())) {
                        stack.push(evaluate(stack, ops.pop()));
                    }
                }
                ops.push(s);
            }
        }
        while (!ops.isEmpty()) {
            stack.push(evaluate(stack, ops.pop()));
        }
        if (stack.isEmpty()) return 0;
        return stack.pop();
    }

    public int evaluate(Stack<Integer> stack, String s) {
        int num2 = stack.pop();
        int num1 = stack.pop();
        switch (s) {
            case "+": return num1 + num2;
            case "-": return num1 - num2;
            case "*": return num1 * num2;
            case "/": return num1 / num2;
            default: return 0;
        }
    }

    public static void main(String[] args) {
        Test368 test = new Test368();
        String[] expression = {"2", "*", "6", "-", "(","23", "+", "7", ")", "/", "(", "1", "+", "2", ")"};
        System.out.println(test.evaluateExpression(expression));
    }
}
