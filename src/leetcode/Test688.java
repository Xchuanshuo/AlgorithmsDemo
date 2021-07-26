package leetcode;

/**
 * @author Legend
 * @data by on 21-5-4.
 * @description https://leetcode-cn.com/problems/knight-probability-in-chessboard/
 * idea:
 *      走k步到达棋盘上某一点的概率为 所有走k-1步到达上一点的概率之和 * 1/8 (每一步都有8个方向可选)
 */
public class Test688 {

    public double knightProbability(int n, int N, int row, int column) {
        double[][][] dp = new double[n][n][N+1];
        int[][] dirs = {{-2, -1}, {-2, 1}, {-1, -2}, {1, -2},
                        {2, -1}, {2, 1}, {-1, 2}, {1, 2}};
        dp[row][column][0] = 1.0;
        for (int k = 1;k <= N;k++) {
            for (int x = 0;x < n;x++) {
                for (int y = 0;y < n;y++) {
                    for (int[] dir : dirs) {
                        int nx = x + dir[0];
                        int ny = y + dir[1];
                        if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                            dp[nx][ny][k] += dp[x][y][k-1] * 0.125;
                        }
                    }
                }
            }
        }
        double total = 0.0;
        for (int i = 0;i < n;i++) {
            for (int j = 0;j < n;j++) {
                total += dp[i][j][N];
            }
        }
        return total;
    }

    public static void main(String[] args) {
        Test688 test = new Test688();
        int n = 8, N = 30, i = 6, j = 4;
        double res = test.knightProbability(n, N, i, j);
        System.out.println(res);
    }
}
