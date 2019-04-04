package lintcode;

import java.util.Stack;

/**
 * @author Legend
 * @data by on 19-4-4.
 * @description asteroid-collision
 */
public class Test1001 {

    public int[] asteroidCollision(int[] asteroids) {
        // write your code here
        Stack<Integer> stack = new Stack<>();
        for (int i = 0;i < asteroids.length;i++) {
            int cur = asteroids[i];
            if (stack.isEmpty() || cur > 0) {
                stack.push(cur);
                continue;
            }
            while (true) {
                int pre = stack.peek();
                if (pre < 0) {
                    stack.push(cur);
                    break;
                }
                if (pre > -cur) {
                    break;
                }
                if (pre == -cur) {
                    stack.pop();
                    break;
                }
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(cur);
                    break;
                }
            }
        }
        int[] result = new int[stack.size()];
        for (int i=result.length-1;i>=0;i--) {
            result[i] = stack.pop();
        }
        return result;
    }

    public static void main(String[] args) {
        Test1001 test1001 = new Test1001();
        int[] res = {5, 10, -5};
        System.out.println(test1001.asteroidCollision(res).length);
    }
}
