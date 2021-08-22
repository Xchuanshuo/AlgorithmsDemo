package acwing;

import java.util.Scanner;

/**
 * @author Legend
 * @data by on 21-8-2.
 * @description https://www.acwing.com/problem/content/3793/
 */
public class Test3793 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int c = scanner.nextInt();
            int[] arr = new int[n];
            for (int i = 0;i < n;i++) {
                arr[i] = scanner.nextInt();
            }
            int cnt = 1;
            for (int i = n-2;i >= 0;i--) {
                if (arr[i+1] - arr[i] > c) break;
                cnt++;
            }
            System.out.println(cnt);
        }
    }
}
