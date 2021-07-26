package leetcode;

import java.util.Stack;

/**
 * @author Legend
 * @data by on 21-5-26.
 * @description https://leetcode-cn.com/problems/reverse-substrings-between-each-pair-of-parentheses/
 */
public class Test1190 {

    public String reverseParentheses(String S) {
        Stack<Character> s = new Stack<>();
        Stack<Character> buffer = new Stack<>();
        for (char c : S.toCharArray()) {
            if (c != ')') {
                s.push(c);
            } else {
                while (s.peek() != '(') buffer.push(s.pop());
                s.pop();
                s.addAll(buffer);
                buffer.clear();
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char c : s) sb.append(c);
        return sb.toString();
    }
}
