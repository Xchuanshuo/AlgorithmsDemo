package lintcode;

import java.util.Stack;

/**
 * @author Legend
 * @data by on 19-3-28.
 * @description baseball-game
 */
public class Test983 {

    public int calPoints(String[] ops) {
        // Write your code here
        Stack<Integer> stack = new Stack<>();
        for (String str : ops) {
            if (str.equals("+")) {
                int temp = stack.pop();
                int val = stack.peek() + temp;
                stack.push(temp);
                stack.push(val);
            } else if (str.equals("D")) {
                int val = stack.peek() * 2;
                stack.push(val);
            } else if (str.equals("C")) {
                stack.pop();
            } else {
                stack.push(Integer.valueOf(str));
            }
        }
        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }

}
