package acwing;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author Legend
 * @data by on 21-7-13.
 * @description https://www.acwing.com/problem/content/3767/
 */
public class Test3764 {

    private static void solve(char[] chs) {
        char[] c1 = new char[chs.length];
        char[] c2 = new char[chs.length];
        boolean flag = false;
        for (int i = 0;i < chs.length;i++) {
            int cnt = chs[i] - '0';
            if (i == 0) {
                c1[i] = c2[i] = '1';
            } else {
                if (cnt == 1) {
                    if (!flag) {
                        c1[i] = '1';
                    } else {
                        c2[i] = '1';
                    }
                    flag = true;
                } else if (cnt == 2) {
                    if (!flag) {
                        c1[i] = '1'; c2[i] = '1';
                    } else {
                        c2[i] = '2';
                    }
                }
            }
        }
        System.out.println(new String(c1));
        System.out.println(new String(c2));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int T = Integer.parseInt(scanner.nextLine());
            for (int t = 0;t < T;t++) {
                scanner.nextLine();
                char[] chs = scanner.nextLine().toCharArray();
                solve(chs);
            }
        }
    }
}
