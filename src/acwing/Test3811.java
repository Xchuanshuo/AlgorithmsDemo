package acwing;

import java.util.Scanner;

/**
 * @author Legend
 * @data by on 21-8-21.
 * @description https://www.acwing.com/problem/content/3811/
 */
public class Test3811 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int T = scanner.nextInt();
            while (--T >= 0) {
                int n = scanner.nextInt();
                int min = n+1;
                for (int a = 1;a <= (n+a-1)/a;a++) {
                    int b = (n + a - 1) / a;
                    min = Math.min(min, a + b);
                }
                System.out.println(min);
            }
        }
    }
}
