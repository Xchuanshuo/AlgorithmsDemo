package acwing;

import java.util.Scanner;

/**
 * @author Legend
 * @data by on 21-8-14.
 * @description https://www.acwing.com/problem/content/description/3805/
 */
public class Test3805 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int T = scanner.nextInt();
            while (--T >= 0) {
                int n = scanner.nextInt();
                int[] arr = new int[n];
                for (int i = 0;i < n;i++) {
                    arr[i] = scanner.nextInt();
                }
                int res = solve(arr, 0, n - 1);
                System.out.println(res);
            }
        }
    }

    private static int solve(int[] arr, int l, int r) {
        if (l >= r) return 1;
        for (int i = l+1;i <= r;i++) {
            if (arr[i] < arr[i-1]) {
                int mid = l + (r-l)/2;
                return Math.max(solve(arr, l, mid), solve(arr, mid + 1, r));
            }
        }
        return r - l + 1;
    }
}
