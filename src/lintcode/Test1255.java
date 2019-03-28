package lintcode;

import java.util.Stack;

/**
 * @author Legend
 * @data by on 19-3-28.
 * @description remove-k-digits
 * 22222 22222
 * 5
 */
public class Test1255 {

    public String removeKdigits(String num, int k) {
        // write your code here
        char[] chars = num.toCharArray();
        System.out.println(chars.length);
        Stack<Character> stack = new Stack<>();
        for (char c : chars) {
            while (!stack.isEmpty() && k > 0 && c < stack.peek()) {
                stack.pop();
                k--;
            }
            stack.push(c);
        }
        StringBuilder builder = new StringBuilder();
        while (!stack.isEmpty()) {
            builder.append(stack.pop());
        }
        String str = builder.reverse().toString();
        while (str.startsWith("0")) {
            str = str.substring(str.indexOf("0")+1);
        }
        if (str.length() > chars.length - k) {
            str = str.substring(k);
        }
        return "".equals(str) ? "0" : str;
    }
}
