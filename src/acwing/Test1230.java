package acwing;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Legend
 * @data by on 21-6-27.
 * @description https://www.acwing.com/problem/content/description/1232/
 */
public class Test1230 {


    private static long solve(int[] arr, int k) {
        int n = arr.length;
        Map<Long, Long> map = new HashMap<>();
        map.put(0L, 1L);
        long sum = 0, res = 0;
        for (int i = 0;i < n;i++) {
            sum += arr[i];
            long d = sum%k;
            if (map.containsKey(d)) {
                res += map.get(d);
            }
            map.put(d, map.getOrDefault(d, 0L) + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            int[] arr = new int[n];
            for (int i = 0;i < n;i++) {
                arr[i] = scanner.nextInt();
            }
            long res = solve(arr, k);
            System.out.println(res);
        }
    }
}
