package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Legend
 * @data by on 21-5-4.
 * @description https://leetcode-cn.com/problems/out-of-boundary-paths/
 * idea:
 *      点(i,j)到外界的路径数等价于外界到点(i,j)的路径数
 */
public class Test576 {

    public int findPaths1(int m, int n, int N, int i, int j) {
        int[][][] dp = new int[m][n][N+1];
        int[][] dirs = {{0,1}, {1, 0}, {0,-1}, {-1, 0}};
        int M = (int)1e9 + 7;
        for (int k = 1;k <= N;k++) {
            for (int x = 0;x < m;x++) {
                for (int y = 0;y < n;y++) {
                    for (int[] d : dirs) {
                        int nx = x + d[0];
                        int ny = y + d[1];
                        if (nx < 0 || nx >= m || ny < 0 || ny >= n) {
                            dp[x][y][k] += 1;
                        } else {
                            dp[x][y][k] = (dp[x][y][k] + dp[nx][ny][k-1])%M;
                        }
                    }
                }
            }
        }
        return dp[i][j][N];
    }

    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        long res = dfs(startRow, startColumn, m, n, maxMove);
        return (int) (res%M);
    }

    Map<String, Long> map = new HashMap<>();
    final long M = (long)1e9 + 7;
    private long dfs(int x, int y, int m, int n, int step) {
        String key = x + "_" + y + "_" + step;
        if (x < 0 || y < 0 || x >= m || y >= n) return 1;
        if (map.containsKey(key)) {
            return map.get(key);
        }
        if (step == 0) return 0;
        long res = (dfs(x + 1, y, m, n, step - 1)
                + dfs(x, y + 1, m, n, step - 1)
                + dfs(x - 1, y, m, n, step - 1)
                + dfs(x, y - 1, m, n, step - 1))%M;
        map.put(key, res);
        return res;
    }

    public static void main(String[] args) {
        int m = 1, n = 2, N = 3;
        int i = 0, j = 1;
        Test576 test = new Test576();
        int res = test.findPaths1(m, n, N, i, j);
        System.out.println(res);
    }
}
