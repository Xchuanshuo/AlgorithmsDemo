package lintcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Legend
 * @data by on 19-4-28.
 * @description police-distance
 */
public class Test1367 {

    int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public int[][] policeDistance(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] result = new int[m][n];
        for (int i = 0;i < m;i++) {
            for (int j = 0;j < n;j++) {
                if (matrix[i][j] == 0) {
                    result[i][j] = bfs(i, j, m, n, matrix);
                } else if (matrix[i][j] == -1) {
                    result[i][j] = -1;
                }
            }
        }
        return result;
    }

    private int bfs(int x, int y, int m, int n, int[][] matrix) {
        int result = 0;
        boolean[][] visited = new boolean[m][n];
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(x, y));
        while (!queue.isEmpty()) {
            result++;
            int size = queue.size();
            for (int i = 0;i < size;i++) {
                Node node = queue.poll();
                for (int j = 0;j < 4;j++) {
                    int newX = node.x + dir[j][0];
                    int newY = node.y + dir[j][1];
                    if (newX < 0 || newX >= m || newY < 0 || newY >= n
                            || visited[newX][newY]
                            || matrix[newX][newY] == -1) {
                        continue;
                    }
                    if (matrix[newX][newY] == 1) return result;
                    visited[newX][newY] = true;
                    queue.offer(new Node(newX, newY));
                }
            }
        }
        return result;
    }

    class Node {
        int x, y;
        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
