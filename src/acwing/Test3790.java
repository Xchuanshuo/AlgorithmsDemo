package acwing;

import java.util.Scanner;

/**
 * @author Legend
 * @data by on 21-7-31.
 * @description https://www.acwing.com/problem/content/3790/
 */
public class Test3790 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int T = scanner.nextInt();
            for (int t = 0;t < T;t++) {
                int a = scanner.nextInt();
                int b = scanner.nextInt();
                if (a%b == 0) {
                    System.out.println(0);
                } else if (a > b) {
                    System.out.println(b - a%b);
                } else {
                    System.out.println(b - a);
                }
            }
        }
    }
}
