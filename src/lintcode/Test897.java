package lintcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Legend
 * @data by on 19-4-30.
 * @description island-city
 */
public class Test897 {

    int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public int numIslandCities(int[][] grid) {
        int result = 0;
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0;i < m;i++) {
            for (int j = 0;j < n;j++) {
                if (grid[i][j] != 0 && !visited[i][j]) {
                    result += bfs(grid, i, j, m, n, visited);
                }
            }
        }
        return result;
    }

    private int bfs(int[][] grid, int x, int y, int m, int n, boolean[][] visited) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(x, y));
        boolean isExist = grid[x][y] == 2;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0;i < size;i++) {
                Node node = queue.poll();
                for (int j = 0;j < 4;j++) {
                    int newX = node.x + dir[j][0];
                    int newY = node.y + dir[j][1];
                    if (newX<0 || newX >= m || newY<0 || newY>=m
                            || grid[newX][newY] == 0
                            || visited[newX][newY]) {
                        continue;
                    }
                    visited[newX][newY] = true;
                    if (grid[newX][newY] == 2) isExist = true;
                    queue.offer(new Node(newX, newY));
                }
            }
        }
        return isExist ? 1 : 0;
    }

    class Node {
        int x, y;
        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
