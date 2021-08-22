package acwing;

import java.util.*;

/**
 * @author Legend
 * @data by on 21-8-4.
 * @description https://www.acwing.com/problem/content/3795/
 */
public class Test3795 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int T = scanner.nextInt();
            for (int t = 0;t < T;t++) {
                int n = scanner.nextInt();
                int k = scanner.nextInt();
                List<Integer> list = new ArrayList<>();
                Set<Integer> set = new HashSet<>();
                boolean[] invalid = new boolean[n+1];
                int cnt = 0;
                for (int i = 2;i <= n;i++) {
                    if (!invalid[i]) {
                        list.add(i);
                        int j = 2, cur = i * j;
                        while (cur <= n) {
                            invalid[cur] = true;
                            j++;
                            cur = i * j;
                        }
                    }
                }
                for (int i = 1;i < list.size();i++) {
                    int cur = list.get(i);
                    if (set.contains(cur)) cnt++;
                    set.add(list.get(i) + list.get(i-1) + 1);
                }
                System.out.println(cnt >= k ? "YES" : "NO");
            }
        }
    }
}
