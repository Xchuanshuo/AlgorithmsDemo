package lintcode;

import hashtab.Solution;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

/**
 * @author Legend
 * @data by on 18-8-12.
 * @description ternary-expression-parser
 *               expression = "F?1:F?4:F?6:5"
 */
public class Test887 {

    public String parseTernary(String expression) {
        // write your code here
        char[] chars = expression.toCharArray();
        Stack<Integer> stack = new Stack<>();
        for (int i=0;i<chars.length;i++) {
            if (chars[i] == '?') {
                stack.push(i);
            }
        }
        String result = expression;
        while (!stack.isEmpty()) {
            int k = stack.pop();
            result = result.substring(0, k-1)+
                     (chars[k-1]=='T'?result.substring(k+1, k+2):result.substring(k+3, k+4))+
                     result.substring(k+4);
            System.out.println(result);
        }
        return result;
    }

    public static void main(String[] args) {
        Test887 test = new Test887();
        String expression = "F?F?7:T?8:A:6";
        System.out.println(test.parseTernary(expression));
    }
}
