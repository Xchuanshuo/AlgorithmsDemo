package acwing;

import java.util.*;

/**
 * @author Legend
 * @data by on 21-7-29.
 * @description https://www.acwing.com/problem/content/description/3787/
 */
public class Test3784 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = Integer.parseInt(scanner.nextLine());
            String[] strs = scanner.nextLine().split(" ");
            int[] arr = new int[n];
            for (int i = 0;i < n;i++) arr[i] = Integer.parseInt(strs[i]);
            char[] pos = scanner.nextLine().toCharArray();
            solve(arr, pos);
        }
    }

    private static void solve(int[] arr, char[] pos) {
        int max = 0;
        for (int i = 0;i < pos.length;i++) {
            max = Math.max(arr[i], max);
            if (pos[i] == '0' && max != i + 1) {
                System.out.println("NO"); return;
            }
        }
        System.out.println("YES");
    }
}
