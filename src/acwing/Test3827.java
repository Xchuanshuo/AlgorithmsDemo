package acwing;

import java.util.Scanner;

/**
 * @author Legend
 * @data by on 21-8-30.
 * @description
 */
public class Test3827 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int T = scanner.nextInt();
            while (T-- > 0) {
                int n = scanner.nextInt();
                int[] arr = new int[n];
                int cnt = 0;
                for (int i = 0;i < n;i++) {
                    arr[i] = scanner.nextInt();
                    if (arr[i] == 1) cnt++;
                }
                for (int i = 1;i < n - 1;i++) {
                    if (arr[i] == 0 && arr[i-1] == 1
                                    &&  arr[i+1] == 1) {
                        cnt++;
                    }
                }
                System.out.println(cnt);
            }
        }
    }
}
