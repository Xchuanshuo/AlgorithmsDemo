package lintcode;

import java.util.Stack;

/**
 * @author Legend
 * @data by on 19-4-13.
 * @description largest-rectangle-in-histogram
 *
 */
public class Test122 {

    public int largestRectangleArea(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        int max = Integer.MIN_VALUE;
        for (int i = 0;i <= height.length;i++) {
            int cur = i==height.length ? -1 : height[i];
            while (!stack.isEmpty() && height[stack.peek()] >= cur) {
                int h = height[stack.pop()];
                int w = stack.isEmpty() ? i : i - stack.peek() - 1;
                max = Math.max(max, w * h);
            }
            stack.push(i);
        }
        return max;
    }
}
