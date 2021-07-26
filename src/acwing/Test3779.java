package acwing;

import java.util.Map;
import java.util.Scanner;

/**
 * @author Legend
 * @data by on 21-7-24.
 * @description https://www.acwing.com/problem/content/3782/
 */
public class Test3779 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int k = scanner.nextInt();
            int[][] arr = new int[k][5];
            for (int i = 0;i < k;i++) {
                int sum = 0;
                int minIdx = 0, maxIdx = 0;
                int n = scanner.nextInt();
                int[] a = new int[n];
                for (int j = 0;j < n;j++) {
                    int cur = scanner.nextInt();
                    sum += cur;
                    a[j] = cur;
                    if (a[j] < a[minIdx]) minIdx = j;
                    if (a[j] > a[maxIdx]) maxIdx = j;
                }
                arr[i] = new int[]{sum, maxIdx+1, minIdx+1, a[maxIdx], a[minIdx]};
            }
            solve(arr);
        }
    }

    private static void solve(int[][] arr) {
        int k = arr.length;
        for (int i = 0;i < k;i++) {
            int[] a1 = arr[i];
            for (int j = i + 1;j < k;j++) {
                int[] a2 = arr[j];
                if (a1[0] - a1[3] == a2[0] - a2[3]) {
                    System.out.println("YES");
                    System.out.println((i+1) + " " + a1[1]);
                    System.out.println((j+1) + " " + a2[1]); return;
                } else if (a1[0] - a1[3] == a2[0] - a2[4]) {
                    System.out.println("YES");
                    System.out.println((i+1) + " " + a1[1]);
                    System.out.println((j+1) + " " + a2[2]); return;
                } else if (a1[0] - a1[4] == a2[0] - a2[3]) {
                    System.out.println("YES");
                    System.out.println((i+1) + " " + a1[2]);
                    System.out.println((j+1) + " " + a2[1]); return;
                } else if (a1[0] - a1[4] == a2[0] - a2[4]) {
                    System.out.println("YES");
                    System.out.println((i+1) + " " + a1[2]);
                    System.out.println((j+1) + " " + a2[2]); return;
                }
            }
        }
        System.out.println("NO");
    }
}
