package acwing;

import java.util.Scanner;
import java.util.concurrent.Callable;

/**
 * @author Legend
 * @data by on 21-8-30.
 * @description https://www.acwing.com/problem/content/3818/
 */
public class Test3818 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int T = scanner.nextInt();
            while (T-- > 0) {
                long n = scanner.nextInt();
                long res = 1;
                for (int i = 2;i <= Math.sqrt(n);i++) {
                    if (n%i == 0) {
                        res *= i;
                        while (n%i == 0) n/=i;
                    }
                }
                if (n >= 1) res *= n;
                System.out.println(res);
            }
        }
    }

}
