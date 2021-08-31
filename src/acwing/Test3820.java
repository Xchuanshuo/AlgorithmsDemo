package acwing;

import java.util.Scanner;

/**
 * @author Legend
 * @data by on 21-8-28.
 * @description https://www.acwing.com/problem/content/description/3820/
 */
public class Test3820 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n1 = scanner.nextInt();
            int n2 = scanner.nextInt();
            int k = scanner.nextInt();
            int m = scanner.nextInt();
            int[] a1 = new int[n1];
            int[] a2 = new int[n2];
            for (int i = 0;i < n1;i++) {
                a1[i] = scanner.nextInt();
            }
            for (int i = 0;i < n2;i++) {
                a2[i] = scanner.nextInt();
            }
            if (a1[k-1] < a2[n2-m]) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
