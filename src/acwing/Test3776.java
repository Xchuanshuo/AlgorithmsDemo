package acwing;

import java.util.Scanner;

/**
 * @author Legend
 * @data by on 21-7-22.
 * @description https://www.acwing.com/problem/content/3779/
 */
public class Test3776 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int T = scanner.nextInt();
            for (int t = 0;t < T;t++) {
                int a = scanner.nextInt();
                int b = scanner.nextInt();
                int c = scanner.nextInt();
                int d = scanner.nextInt();
                int e = scanner.nextInt();
                int f = scanner.nextInt();
                solve(a, b, c, d, e, f);
            }
        }
    }

    private static void solve(int a, int b, int c, int d, int e, int f) {
        int res = 0;
        for (int i = 1;i <= d;i++) {
            if (f > e && b > 0 && c > 0) {
                b--; c--; res += f;
            } else {
                if (a > 0) {
                    a--; res += e;
                } else if (b > 0 && c > 0) {
                    b--; c--; res += f;
                }
            }
        }
        System.out.println(res);
    }
}
