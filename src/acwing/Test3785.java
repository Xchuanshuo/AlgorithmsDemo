package acwing;

import java.util.Scanner;

/**
 * @author Legend
 * @data by on 21-7-31.
 * @description https://www.acwing.com/problem/content/description/3788/
 */
public class Test3785 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String[] strs = scanner.nextLine().split(" ");
            int n = Integer.parseInt(strs[0]);
            int k = Integer.parseInt(strs[1]);
            char[][] grid = new char[n][n];
            for (int i = 0;i < n;i++) {
                grid[i] = scanner.nextLine().toCharArray();
            }
            solve(grid, k);
        }
    }

    private static void solve(char[][] grid, int k) {
        int n = grid.length;
        int[][][] dp1 = new int[n+1][n+1][2];
        int[][][] dp2 = new int[n+2][n+2][2];
        for (int i = 1;i <= n;i++) {
            for (int j = 1;j <= n;j++) {
                if (grid[i-1][j-1] == '.') {
                    dp1[i][j][0] = dp1[i][j-1][0] + 1;
                    dp1[i][j][1] = dp1[i-1][j][1] + 1;
                }
            }
        }
        int res = 0;
        int x = 1, y = 1;
        for (int i = n;i >= 1;i--) {
            for (int j = n;j >= 1;j--) {
                if (grid[i-1][j-1] == '#') continue;
                dp2[i][j][0] = dp2[i][j+1][0] + 1;
                dp2[i][j][1] = dp2[i+1][j][1] + 1;
                int cnt = 0;
                cnt += Math.max(0, Math.min(dp1[i][j-1][0], k-1) + Math.min(dp2[i][j][0], k) - k + 1);
                cnt += Math.max(0, Math.min(dp1[i-1][j][1], k-1) + Math.min(dp2[i][j][1], k) - k + 1);
                if (res < cnt) {
                    res = cnt; x = i; y = j;
                }
            }
        }
        System.out.println(x + " " + y);
    }
}
