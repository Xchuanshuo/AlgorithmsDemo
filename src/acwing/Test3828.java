package acwing;

import java.util.*;

/**
 * @author Legend
 * @data by on 21-9-2.
 * @description https://www.acwing.com/problem/content/3828/
 */
public class Test3828 {

    static final int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String[] f = scanner.nextLine().split(" ");
            int r = Integer.parseInt(f[0]);
            int c = Integer.parseInt(f[1]);
            char[][] grid = new char[r][c];
            for (int i = 0;i < r;i++) {
                grid[i] = scanner.nextLine().toCharArray();
            }
            int[] e = new int[2];
            for (int i = 0;i < r;i++) {
                for (int j = 0;j < c;j++) {
                    if (grid[i][j] == 'E') {
                        e[0] = i; e[1] = j; break;
                    }
                }
            }
            solve(e, grid);
        }
    }

    private static void solve(int[] e, char[][] grid) {
        int r = grid.length, c = grid[0].length;
        Map<Integer, Integer> disMap = new HashMap<>();
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[r][c];
        q.offer(e); visited[e[0]][e[1]] = true;
        int step = 0, target = 0;
        while (!q.isEmpty()) {
            step++;
            int size = q.size();
            for (int k = 0;k < size;k++) {
                int[] cur = q.remove();
                for (int i = 0;i < dirs.length;i++) {
                    int nx = cur[0] + dirs[i][0];
                    int ny = cur[1] + dirs[i][1];
                    if (nx < 0 || nx >= r || ny < 0 || ny >= c ||
                            visited[nx][ny] || grid[nx][ny] == 'T') continue;
                    if (grid[nx][ny] == 'S') target = step;
                    visited[nx][ny] = true;
                    if (Character.isDigit(grid[nx][ny])) {
                        int cnt = grid[nx][ny] - '0';
                        disMap.put(step, disMap.getOrDefault(step, 0) + cnt);
                    }
                    q.offer(new int[]{nx, ny});
                }
            }
        }
        int res = 0;
        for (int key : disMap.keySet()) {
            int val = disMap.get(key);
            if (key <= target) res += val;
        }
        System.out.println(res);
    }
}
