package acwing;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author Legend
 * @data by on 21-7-24.
 * @description https://www.acwing.com/problem/content/3780/
 */
public class Test3777 {

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

    private static void solve(char[] chs) {
        int n = chs.length;
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        for (int i = 0;i < n;i++) {
            char c = chs[i];
            if (c == 'W') q1.offer(i);
            else q2.offer(i);
        }
        int cntW = q1.size(), cntB = q2.size();
        if (cntW == n || cntB == n) {
            System.out.println(0); return;
        }
        if (cntW%2 == 1 && cntB%2 == 1) {
            System.out.println(-1); return;
        }
        if (cntW%2 != 0) {
            q1 = q2; cntW = cntB;
        }
        int k = 0;
        Queue<Integer> t = new LinkedList<>(q1);
        for (int i = 0;i < cntW;i += 2) {
            int v1 = t.remove(), v2 = t.remove();
            k += v2 - v1;
        }
        System.out.println(k);
        for (int i = 0;i < cntW;i += 2) {
            int v1 = q1.remove(), v2 = q1.remove();
            for (int j = v1;j < v2;j++) {
                System.out.print(j+1 + " ");
            }
        }
        System.out.println();
    }
}
