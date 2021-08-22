package acwing;

import java.util.Scanner;

/**
 * @author Legend
 * @data by on 21-8-21.
 * @description https://www.acwing.com/problem/content/3812/
 */
public class Test3812 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int T = scanner.nextInt();
            while (T-- > 0) {
                int n = scanner.nextInt();
                int[] arr = new int[n];
                for (int i = 0;i < n;i++) {
                    arr[i] = scanner.nextInt();
                }
                solve(arr);
            }
        }
    }

    private static void solve(int[] arr) {
        int n = arr.length, min = arr[0], max = arr[0];
        for (int i = 1;i < n;i++) {
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);
        }
        int t = min, res = Integer.MAX_VALUE;
        for (int i = min;i <= max;i++) {
            int w = 0;
            for (int a : arr) {
                if (a == i) continue;
                if (i > a) {
                    w += Math.abs(i-a-1);
                } else {
                    w += Math.abs(i + 1 - a);
                }
            }
            if (w < res) {
                res = w; t = i;
            }
        }
        System.out.println(t + " " + res);
    }
}
