package acwing;

import java.util.Scanner;

/**
 * @author Legend
 * @data by on 21-7-12.
 * @description https://www.acwing.com/video/3300/
 */
public class Test3763 {

    private static void solve(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int cnt = 0, sum = 0, min = (int)1e9;
        for (int i = 0;i < m;i++) {
            for (int j = 0;j < n;j++) {
                min = Math.min(min, Math.abs(mat[i][j]));
                sum += Math.abs(mat[i][j]);
                if (mat[i][j] < 0) cnt++;
            }
        }
        if (cnt%2 == 1) sum -= 2 * min;
        System.out.println(sum);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int t = scanner.nextInt();
            for (int k = 0;k < t;k++) {
                int n = scanner.nextInt();
                int m = scanner.nextInt();
                int[][] mat = new int[n][m];
                for (int i = 0;i < n;i++) {
                    for (int j = 0;j < m;j++) {
                        mat[i][j] = scanner.nextInt();
                    }
                }
                solve(mat);
            }
        }
    }
}
