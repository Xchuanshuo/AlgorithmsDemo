package acwing;

import java.util.Scanner;

/**
 * @author Legend
 * @data by on 21-7-31.
 * @description https://www.acwing.com/problem/content/3791/
 */
public class Test3788 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] arr = new int[n];
            int[] sum = new int[n+1];
            for (int i = 0;i < n;i++) {
                arr[i] = scanner.nextInt();
                sum[i+1] = sum[i] + arr[i];
            }
            int s = 0, cnt = 0;
            for (int i = n - 1;i >= 0;i--) {
                s += arr[i];
                if (sum[i] == s) cnt++;
            }
            if (s == 0) cnt--;
            System.out.println(cnt);
        }
    }
}
