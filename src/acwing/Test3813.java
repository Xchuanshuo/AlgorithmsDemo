package acwing;

import java.util.Scanner;

/**
 * @author Legend
 * @data by on 21-8-22.
 * @description https://www.acwing.com/problem/content/3813/
 */
public class Test3813 {

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
                int cnt = 0, res = 0;
                for (int i = 0;i < 2*n;i++) {
                    if (arr[i%n] == 1) {
                        cnt++;
                    } else {
                        cnt = 0;
                    }
                    res = Math.max(res, cnt);
                }
                System.out.println(res);
            }
        }
    }
}
