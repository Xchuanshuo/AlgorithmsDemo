package acwing;

import java.util.Scanner;

/**
 * @author Legend
 * @data by on 21-8-3.
 * @description https://www.acwing.com/problem/content/3794/
 */
public class Test3794 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = Integer.parseInt(scanner.nextLine());
            String str = scanner.nextLine();
            char[] chs = str.toCharArray();
            StringBuilder res = new StringBuilder();
            for (int i = 0;i < chs.length;i++, n--) {
                if (n%2 == 0) {
                    res.insert(0, chs[i]);
                } else {
                    res.append(chs[i]);
                }
            }
            System.out.println(res.toString());
        }
    }
}
