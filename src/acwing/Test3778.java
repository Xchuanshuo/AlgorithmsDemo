package acwing;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Legend
 * @data by on 21-7-24.
 * @description https://www.acwing.com/problem/content/3781/
 */
public class Test3778 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int T = scanner.nextInt();
            for (int t = 0;t < T;t++) {
                int n = scanner.nextInt();
                solve(n);
            }
        }
    }

    private static void solve(int n) {
        List<Integer> list = new ArrayList<>();
        int[] arr = new int[n];
        for (int i = 0;i < arr.length;i++) arr[i] = i + 1;
        while (true) {
            int mIdx = 0, total = arr[0];
            for (int i = 1;i < n;i++) {
                total += arr[i];
                if (arr[mIdx] < arr[i]) mIdx = i;
            }
            if (arr[mIdx]*n == total) break;
            list.add(mIdx + 1);
            for (int i = 0;i < n;i++) {
                if (i != mIdx) arr[i]+=list.size();
            }
        }
        System.out.println(list.size());
        for (int v : list) {
            System.out.print(v + " ");
        }
        System.out.println();
    }
}
