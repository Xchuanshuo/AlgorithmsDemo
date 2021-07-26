package acwing;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Legend
 * @data by on 21-7-8.
 * @description https://www.acwing.com/problem/content/3764/
 */
public class Test3761 {

    private static int solve(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int a : arr) map.put(a, map.getOrDefault(a, 0) + 1);
        int min = Integer.MAX_VALUE, idx = -1;
        for (int i = 0;i < arr.length;i++) {
            int a = arr[i];
            if (map.get(a) == 1) {
                if (a < min) {
                    min = a ; idx = i + 1;
                }
            }
        }
        return idx;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int t = scanner.nextInt();
            for (int i = 0;i < t;i++) {
                int n = scanner.nextInt();
                int[] arr = new int[n];
                for (int j = 0;j < n;j++) {
                    arr[j] = scanner.nextInt();
                }
                System.out.println(solve(arr));
            }
        }
    }
}
