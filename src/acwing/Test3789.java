package acwing;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Legend
 * @data by on 21-7-31.
 * @description https://www.acwing.com/problem/content/3792/
 */
public class Test3789 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            char[] chs = scanner.nextLine().toCharArray();
            solve(chs);
        }
    }

    private static void solve(char[] chs) {
        int n = chs.length;
        long[][] dp = new long[26][26];
        long[] cnt = new long[26];
        long max = 0;
        for (int i = 0;i < n;i++) {
            char c = chs[i];
            for (int j = 0;j < 26;j++) {
                dp[c-'a'][j] += cnt[j];
                max = Math.max(max, dp[c-'a'][j]);
            }
            cnt[c-'a']++;
            max = Math.max(max, cnt[c-'a']);
        }
        System.out.println(max);
    }
}
