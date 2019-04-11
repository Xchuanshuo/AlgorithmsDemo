package lintcode;

import java.util.Stack;

/**
 * @author Legend
 * @data by on 19-4-11.
 * @description basic-calculator
 */
public class Test978 {

    // 非递归
    public int calculate(String s) {
        // Write your code here
        Stack<Integer> stack = new Stack<>();
        int result = 0, sign = 1, num = 0;
        for (int i = 0;i < s.length();i++) {
            char cur = s.charAt(i);
            if (Character.isDigit(cur)) {
                num = num * 10 + cur - '0';
            } else if (cur == '+') {
                result += sign * num;
                sign = 1;
                num = 0;
            } else if (cur == '-') {
                result += sign * num;
                sign = -1;
                num = 0;
            } else if (cur == '(') {
                stack.push(result);
                stack.push(sign);
                sign = 1;
                result = 0;
            } else if (cur == ')') {
                result += sign * num;
                num = 0;
                result *= stack.pop();
                result += stack.pop();
            }
        }
        if (num != 0) {
            result += sign * num;
        }
        return result;
    }

    // 递归
    private int i = 0;
    public int calculate2(String s) {
        int result = 0, num = 0, sign = 1;
        int len = s.length();
        while (i < len) {
            char cur = s.charAt(i++);
            if (Character.isDigit(cur)) {
                num = num * 10 + cur - '0';
            } else if (cur == '+') {
                result += sign * num;
                sign = 1;
                num = 0;
            } else if (cur == '-') {
                result += sign * num;
                sign = -1;
                num = 0;
            } else if (cur == '(') {
                num = calculate2(s);
            } else if (cur == ')'){
                result += sign * num;
                return result;
            }
        }
        if (num != 0) {
            result += sign * num;
        }
        return result;
    }

    public static void main(String[] args) {
        Test978 test = new Test978();
        System.out.println(test.calculate2("(1+(4+5+2)-3)+(6+8)"));
    }
}
