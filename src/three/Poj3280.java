package three;


import java.util.Scanner;

public class Poj3280 {

    private static int solve(String str, int[] ins, int[] del) {
        int n = str.length();
        char[] chars = str.toCharArray();
        int[][] dp = new int[n][n];
        for (int len = 2;len <= n;len++) {
            for (int i = 0;i <= n - len;i++) {
                int j = i + len - 1;
                if (chars[i] == chars[j]) {
                    dp[i][j] = dp[i+1][j-1];
                } else {
                    int idxI = chars[i] - 'a';
                    int idxJ = chars[j] - 'a';
                    int min = dp[i+1][j-1] + del[idxI] + del[idxJ];
                    dp[i][j] = min;

                    min = dp[i+1][j] + Math.min(ins[idxI], del[idxI]);
                    dp[i][j] = Math.min(dp[i][j], min);

                    min = dp[i][j-1] + Math.min(ins[idxJ], del[idxJ]);
                    dp[i][j] = Math.min(dp[i][j], min);
                }
            }
        }
        return dp[0][n-1];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String[] strs = scanner.nextLine().split(" ");
            int k = Integer.parseInt(strs[0]);
            int[] ins = new int[26];
            int[] del = new int[26];
            String str = scanner.nextLine();
            for (int i = 0;i < k;i++) {
                String[] strings = scanner.nextLine().split(" ");
                int idx = strings[0].charAt(0) - 'a';
                ins[idx] = Integer.parseInt(strings[1]);
                del[idx] = Integer.parseInt(strings[2]);
            }
            int res = solve(str, ins, del);
            System.out.println(res);
        }
    }
}
