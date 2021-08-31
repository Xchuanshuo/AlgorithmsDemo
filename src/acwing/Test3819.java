package acwing;

import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author Legend
 * @data by on 21-8-28.
 * @description https://www.acwing.com/problem/content/description/3819/
 */
public class Test3819 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int T = scanner.nextInt();
            while (T-- > 0) {
                int n = scanner.nextInt();
                int[] arr = new int[n];
                int[] rArr = new int[n];
                long total = 0;
                for (int i = 0;i < n;i++) {
                    arr[i] = scanner.nextInt();
                    rArr[n-i-1] = arr[i];
                    total += arr[i];
                }
                if (total%2 == 1) {
                    System.out.println("NO");
                    continue;
                }
                boolean res = getRes(arr, total) | getRes(rArr, total);
                if (res) System.out.println("YES");
                else System.out.println("NO");
            }
        }
    }

    private static boolean getRes(int[] arr, long total) {
        Set<Long> set = new HashSet<>();
        long cur = 0;
        boolean res = false;
        for (long a : arr) {
            cur += a; set.add(a);
            if (2*cur == total) {
                res = true; break;
            } else if (2*cur > total){
                long val = 2*cur - total;
                if (val%2 != 0) continue;
                val = val / 2;
                if (set.contains(val)) {
                    res = true; break;
                }
            }
        }
        return res;
    }
}
