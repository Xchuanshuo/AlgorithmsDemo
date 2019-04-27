package lintcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Legend
 * @data by on 19-4-27.
 * @description shortest-path-to-the-destination
 */
public class Test1563 {

    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};
    public int shortestPath(int[][] targetMap) {
        int result = 0;
        int m = targetMap.length, n = targetMap[0].length;
        boolean[][] visited = new boolean[m][n];
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(0, 0));
        while (!queue.isEmpty()) {
            result++;
            int size = queue.size();
            for (int i = 0;i < size;i++) {
                Node node = queue.poll();
                int x = node.x, y = node.y;
                visited[x][y] = true;
                for (int j = 0;j < 4;j++) {
                    int newX = x + dx[j];
                    int newY = y + dy[j];
                    if (newX < 0 || newX >= m || newY < 0 ||
                            newY >= n || targetMap[newX][newY] == 1) {
                        continue;
                    }
                    if (visited[newX][newY]) continue;
                    if (targetMap[newX][newY] == 2) return result;
                    queue.offer(new Node(newX, newY));
                }
            }
        }
        return -1;
    }

    class Node {
        int x, y;
        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        int[][] arr = {{0,0,1,0}, {0,1,2,0},{1,1,0,1}};
        Test1563 test = new Test1563();
        System.out.println(test.shortestPath(arr));
    }
}
