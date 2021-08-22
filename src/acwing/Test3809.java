package acwing;

import java.util.Scanner;

/**
 * @author Legend
 * @data by on 21-8-16.
 * @description https://www.acwing.com/problem/content/description/3809/
 */
public class Test3809 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int T = Integer.parseInt(scanner.nextLine());
            while (--T >= 0) {
                scanner.nextLine();
                String str = scanner.nextLine();
                char[] chs = str.toCharArray();
                int idx = chs.length-1;
                for (int i = 1;i < chs.length;i++) {
                    if (chs[i] < chs[i-1]) {
                        idx = i - 1; break;
                    }
                }
                System.out.println(str.substring(0, idx) + str.substring(idx+1));
            }
        }
    }
}
