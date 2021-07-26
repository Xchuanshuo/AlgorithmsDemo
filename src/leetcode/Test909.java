package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Legend
 * @data by on 21-6-27.
 * @description https://leetcode-cn.com/problems/snakes-and-ladders/
 */
public class Test909 {

    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        boolean[] visited = new boolean[n*n+1];
        Queue<Integer> q = new LinkedList<>();
        q.offer(1); visited[1] = true;
        int step = 0, end = n * n;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int k = 0;k < size;k++) {
                int cur = q.poll();
                if (cur == end) return step;
                for (int i = 1;i <= 6;i++) {
                    int dst = cur + i;
                    if (dst > n * n) break;
                    int[] pos = getPos(n, dst);
                    int next = board[pos[0]][pos[1]] == -1 ? dst : board[pos[0]][pos[1]];
                    if (!visited[next]) {
                        visited[next] = true;
                        q.offer(next);
                    }
                }
            }
            step++;
        }
        return -1;
    }

    private int[] getPos(int n, int cur) {
        int x = n - (cur-1)/n - 1;
        int y = (n%2 == 0 ? x%2==0 : x%2 == 1) ? n - (cur-1)%n - 1 : (cur-1)%n;
        return new int[]{x, y};
    }
}
