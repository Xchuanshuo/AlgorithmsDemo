package leetcode;

import java.util.Stack;

/**
 * @author Legend
 * @data by on 21-4-17.
 * @description https://leetcode-cn.com/problems/remove-k-digits/
 * idea:
 *      单调栈
 */
public class Test92 {

    public String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack<>();
        for (char c : num.toCharArray()) {
            while (k > 0 && !stack.isEmpty() && stack.peek() > c) {
                stack.pop();
                k--;
            }
            stack.push(c);
        }
        while (k > 0 && !stack.isEmpty()) {
            k--;
            stack.pop();
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            char c = stack.pop();
            sb.append(c);
        }
        sb.reverse();
        int len = sb.length();
        int pos = -1;
        for (int i = 0;i < len;i++) {
            if (sb.charAt(i) != '0') break;
            pos = i;
        }
        if (pos != -1) sb.delete(0, pos + 1);
        if (sb.length() == 0) return "0";
        return sb.toString();
    }
}
