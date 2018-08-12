package lintcode;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author Legend
 * @data by on 18-8-1. waiting...solution
 * @description bricks-falling-when-hit
 */
public class Test1014 {

    private int[][] dirs = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    private int[][] newGrid;
    private int row, col;
    public int[] hitBricks(int[][] grid, int[][] hits) {
        // Write your code here
        if (grid == null || grid.length == 0) return new int[]{};
        row = grid.length;
        col = grid[0].length;
        newGrid = grid;
        int[] result = new int[hits.length];
        for (int[] hit: hits) {
            if (newGrid[hit[0]][hit[1]] == 1) {
                newGrid[hit[0]][hit[1]] = 0;
            } else {
                newGrid[hit[0]][hit[1]] = -1;
            }
        }
        for (int i=0;i<col;i++) {
            dfs(new Point(i, 0));
        }
        for (int i=0;i<result.length;i++) {
            int[] hit = hits[i];
            if (newGrid[hit[0]][hit[1]] == -1) continue;
            newGrid[hit[0]][hit[1]] = 1;
            if (isConnected(hit[0], hit[1])) {
                result[i] = dfs(new Point(hit[1], hit[0]));
            }
        }
        return result;
    }

    public int dfs(Point point) {
        Stack<Point> stack = new Stack<>();
        stack.push(point);
        int count = -1;
        while (!stack.isEmpty()) {
            Point cur = stack.pop();
            newGrid[cur.y][cur.x] = 2;
            count++;
            for (int i = 0; i < 4; i++) {
                int newX = cur.x + dirs[i][0];
                int newY = cur.y + dirs[i][1];
                if (newX < 0 || newX >= col || newY < 0 || newY >= row ) {
                    continue;
                }
                if (newGrid[newY][newX] != 1) continue;
                stack.push(new Point(newX, newY));
            }
        }
        return count;
    }

    public boolean isConnected(int i, int j) {
        if ((i>0&&newGrid[i-1][j]==2) || (i<row-1&&newGrid[i+1][j]==2)
                || (j>0&&newGrid[i][j-1]==2) || (j<col-1&&newGrid[i][j+1]==2)) {
            return true;
        }
        return false;
    }

    class Point {
        int x, y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        Test1014 test = new Test1014();
        int[][] grid = {{1, 0, 1}, {1, 1, 1}};
        int[][] hits = {{0,0}, {0, 2}, {1, 1}};
        int[] result = test.hitBricks(grid, hits);
        for (int i: result) {
            System.out.print(i+", ");
        }
    }
}
