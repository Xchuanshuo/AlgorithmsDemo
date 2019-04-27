package lintcode;

/**
 * @author Legend
 * @data by on 19-4-27.
 * @description cable-car-ride
 */
public class Test1386 {

    int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
    public int cableCarRide(int[][] height) {
        int result = 0;
        int m = height.length, n = height[0].length;
        for (int i = 0;i < m;i++) {
            for (int j = 0;j < n;j++) {
                result = Math.max(result, dfs(height, i, j, m, n));
            }
        }
        return result;
    }

    private int dfs(int[][] height, int x, int y, int m, int n) {
        int result = 0;
        for (int i = 0;i < 8;i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];
            if (newX < 0 || newX >= m || newY < 0 ||
                    newY >= n || height[newX][newY] < height[x][y]) {
                continue;
            }
            result = Math.max(result, dfs(height, newX, newY, m, n));
        }
        return result + 1;
    }
}
