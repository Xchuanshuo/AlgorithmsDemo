package three;

import java.util.Scanner;

/**
 * @description
 */
public class Main1 {

    // 12232
    private static int solve(String str) {
        int n = str.length();
        char[] chars = str.toCharArray();
        int[][] dp = new int[n][n];
        for (int len = 2;len <= n;len++) {
            for (int i = 0;i <= n - len;i++) {
                int j = i + len - 1;
                if (chars[i] == chars[j]) {
                    dp[i][j] = dp[i+1][j-1];
                } else {
                    int min = dp[i+1][j-1] + del(chars[i]) + del(chars[j]);
                    dp[i][j] = min;

                    min = Math.min(dp[i+1][j] + ins(chars[i]), dp[i+1][j] + del(chars[i]));
                    dp[i][j] = Math.min(dp[i][j], min);

                    min = Math.min(dp[i][j-1] + ins(chars[j]), dp[i][j-1] + del(chars[j]));
                    dp[i][j] = Math.min(dp[i][j], min);
                }
            }
        }
        return dp[0][n-1];
    }

    private static int del(char c) {
        if (c == '1') {
            return 120;
        } else if (c == '2') {
            return 350;
        } else if (c == '3') {
            return 200;
        } else {
            return 320;
        }
    }

    private static int ins(char c) {
        if (c == '1') {
            return 100;
        } else if (c == '2') {
            return 200;
        } else if (c == '3') {
            return 360;
        } else {
            return 220;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            int res = solve(str);
            System.out.println(res);
        }
    }
}
