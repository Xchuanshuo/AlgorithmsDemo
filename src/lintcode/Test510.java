package lintcode;

import java.util.Stack;

/**
 * @author Legend
 * @data by on 19-4-13.
 * @description maximal-rectangle
 * idea:
 *      与Test12一样 首先需要统计以每个位置为底边时的高度是多少
 *      这样就转换成了求解直方图最大矩形面积
 */
public class Test510 {

    public int maximalRectangle(boolean[][] matrix) {
        // write your code here
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int m = matrix.length, n = matrix[0].length;
        int[][] h = new int[m][n];
        for (int i = 0;i < m;i++) {
            for (int j = 0;j < n;j++) {
                if (matrix[i][j]) {
                    h[i][j] = i == 0 ? 1 : h[i-1][j] + 1;
                }
            }
        }
        int result = 0;
        for (int i = 0;i < m;i++) {
            result = Math.max(result, calMaxArea(h[i]));
        }
        return result;
    }

    private int calMaxArea(int[] h) {
        Stack<Integer> stack = new Stack<>();
        int max = Integer.MIN_VALUE;
        for (int i = 0;i <= h.length;i++) {
            int cur = i == h.length ? -1 : h[i];
            while (!stack.isEmpty() && h[stack.peek()] >= cur) {
                int height = h[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                max = Math.max(max, width * height);
            }
            stack.push(i);
        }
        return max;
    }

}
