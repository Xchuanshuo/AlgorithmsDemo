package acwing;

import java.util.Scanner;

/**
 * @author Legend
 * @data by on 21-7-19.
 * @description https://www.acwing.com/problem/content/3776/
 */
public class Test3773 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int T = scanner.nextInt();
            for (int t = 0;t < T;t++) {
                int n = scanner.nextInt();
                int x = scanner.nextInt();
                int[] arr = new int[n];
                for (int i = 0;i < n;i++) {
                    arr[i] = scanner.nextInt();
                }
                solve(arr, x);
            }
        }
    }

    private static void solve(int[] arr, int x) {
        int max = 0;
        for (int i = 0;i < arr.length;i++) {
            if (arr[i] == x) {
                System.out.println(1); return;
            }
            max = Math.max(max, arr[i]);
        }
        if (max > x) {
            System.out.println(2);
        } else {
            System.out.println((x+max-1)/max);
        }
    }
}
