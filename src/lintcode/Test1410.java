package lintcode;

import java.util.Stack;

/**
 * @author Legend
 * @data by on 18-8-12.
 * @description matrix-water-injection
 */
public class Test1410 {

    private int[][] dirs = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
    public String waterInjection(int[][] matrix, int R, int C) {
        // Write your code here
        if (matrix==null || matrix.length==0) return "NO";
        int row = matrix.length, col = matrix[0].length;
        Stack<Point> stack = new Stack<>();
        stack.push(new Point(R, C));
        while (!stack.isEmpty()) {
            int count = stack.size();
            for (int i=0;i<count;i++) {
                Point point = stack.pop();
                for (int j=0;j<4;j++) {
                    int newX = point.x + dirs[j][0];
                    int newY = point.y + dirs[j][1];
                    if (newX<0 || newX>=row || newY<0 || newY>=col ) {
                        return "YES";
                    } else {
                        if (matrix[newX][newY]<matrix[point.x][point.y]) {
                            stack.push(new Point(newX, newY));
                        }
                    }
                }
            }
        }
        return "NO";
    }

    class Point {
        int x, y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
