package acwing;

import java.util.Scanner;

/**
 * @author Legend
 * @data by on 21-7-17.
 * @description https://www.acwing.com/problem/content/3773/
 */
public class Test3770 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int T = Integer.parseInt(scanner.nextLine());
            for (int t = 0;t < T;t++) {
                String[] strs = scanner.nextLine().split(" ");
                int n = Integer.parseInt(strs[0]);
                int a = Integer.parseInt(strs[1]);
                int b = Integer.parseInt(strs[2]);
                int c = Integer.parseInt(strs[3]);
                char[] chs = scanner.nextLine().toCharArray();
                solve(chs, a, b, c);
            }
        }
    }

    private static void solve(char[] chs, int a, int b, int c) {
        int s = 0;
        int cost = Math.min(b, c + a);
        for (int i = 0;i < chs.length;i++) {
            if (chs[i] == '0') {
                s += a;
            } else {
                s += cost;
            }
        }
        int res = s; s = 0;
        cost = Math.min(a, c + b);
        for (int i = 0;i < chs.length;i++) {
            if (chs[i] == '1') {
                s += b;
            } else {
                s += cost;
            }
        }
        res = Math.min(res, s);
        System.out.println(res);
    }
}
