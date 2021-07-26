package acwing;

import java.util.Scanner;

/**
 * @author Legend
 * @data by on 21-7-17.
 * @description https://www.acwing.com/problem/content/3772/
 */
public class Test3769 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int T = scanner.nextInt();
            for (int t = 0;t < T;t++) {
                int n = scanner.nextInt();
                int d = scanner.nextInt();
                int[] arr = new int[n];
                for (int i = 0;i < n;i++) {
                    arr[i] = scanner.nextInt();
                }
                solve(arr, d);
            }
        }
    }

    private static void solve(int[] arr, int d) {
        int res = arr[0];
        for (int i = 1;i < arr.length;i++) {
            if (d <= 0) break;
            if (arr[i] > 0) {
                int cnt = arr[i];
                if (d >= cnt*i) {
                    res += cnt;
                    d -= cnt*i;
                } else {
                    int cur = Math.min(d/i, cnt);
                    d -= cur * i;
                    res += cur;
                }
            }
        }
        System.out.println(res);
    }
}
