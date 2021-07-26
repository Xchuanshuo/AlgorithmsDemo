package acwing;

import java.util.Scanner;

/**
 * @author Legend
 * @data by on 21-7-15.
 * @description https://www.acwing.com/problem/content/3771/
 */
public class Test3768 {

    private static void solve(char[] chs) {
        int cnt = chs[0] == 'x' ? 1 : 0, res = 0;
        for (int i = 1;i < chs.length;i++) {
            if (chs[i] == 'x') {
                cnt++;
            } else {
                if (cnt >= 3) res += cnt - 2;
                cnt = 0;
            }
        }
        if (cnt >= 3) res += cnt - 2;
        System.out.println(res);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            scanner.nextLine();
            char[] chs = scanner.nextLine().toCharArray();
            solve(chs);
        }
    }
}
