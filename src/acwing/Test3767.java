package acwing;

import java.util.Scanner;

/**
 * @author Legend
 * @data by on 21-7-14.
 * @description https://www.acwing.com/problem/content/3770/
 */
public class Test3767 {

    private static void solve(char[] ch1, char[] ch2) {
        int cnt1 = 0, cnt2 = 0;
        for (int i = 0;i < ch1.length;i++) {
            if (ch1[i] > ch2[i]) {
                cnt1++;
            } else if (ch1[i] < ch2[i]) {
                cnt2++;
            }
        }
        if (cnt1 == 0) {
            System.out.println(-1);
        } else {
            System.out.println((cnt1+cnt2)/cnt1);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            scanner.nextLine();
            char[] ch1 = scanner.nextLine().toCharArray();
            char[] ch2 = scanner.nextLine().toCharArray();
            solve(ch1, ch2);
        }
    }
}
