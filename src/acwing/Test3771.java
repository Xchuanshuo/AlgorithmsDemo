package acwing;

import java.util.*;

/**
 * @author Legend
 * @data by on 21-7-17.
 * @description https://www.acwing.com/problem/content/description/3774/
 */
public class Test3771 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] arr = new int[n];
            for (int i = 0;i < n;i++) {
                arr[i] = scanner.nextInt();
            }
            solve(arr);
        }
    }

    private static void solve(int[] arr) {
        int n = arr.length;
        Map<Integer, Long> map = new HashMap<>();
        for (int i = 0;i < n;i++) {
            int num = arr[i] - (i + 1);
            map.put(num, map.getOrDefault(num, 0L) + arr[i]);
        }
        long res = 0;
        for (long val : map.values()) {
            res = Math.max(res, val);
        }
        System.out.println(res);
    }
}
