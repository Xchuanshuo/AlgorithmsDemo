package acwing;

import java.util.Scanner;

/**
 * @author Legend
 * @data by on 21-8-6.
 * @description https://www.acwing.com/problem/content/3797/
 */
public class Test3797 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            if (n == 1) {
                System.out.println("a"); continue;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("a").append("b");
            for (int i = 2;i < n;i++) {
                if (sb.charAt(i-2) == 'a') {
                    sb.append('b');
                } else {
                    sb.append('a');
                }
            }
            System.out.println(sb.toString());
        }
    }
}
