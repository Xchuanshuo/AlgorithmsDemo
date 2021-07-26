package leetcode;

import java.util.Stack;

/**
 * @author Legend
 * @data by on 21-4-14.
 * @description https://leetcode-cn.com/problems/largest-rectangle-in-histogram/
 * idea:
 *      单调递增栈
 */
public class Test84 {

    public int largestRectangleArea(int[] heights1) {
        if (heights1 == null || heights1.length == 0) return 0;
        int[] heights = new int[heights1.length + 2];
        for (int i = 1;i <= heights1.length;i++) {
            heights[i] = heights1[i-1];
        }
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        for (int i = 0;i < heights.length;i++) {
            while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
                int cur = stack.pop();
                if (stack.isEmpty()) break;
                int l = stack.peek();
                int r = i - 1;
                max = Math.max(max, (r - l) * heights[cur]);
            }
            stack.push(i);
        }
        return max;
    }
}
