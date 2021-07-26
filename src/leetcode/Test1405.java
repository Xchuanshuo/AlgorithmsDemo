package leetcode;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author Legend
 * @data by on 21-5-18.
 * @description https://leetcode-cn.com/problems/longest-happy-string/
 */
public class Test1405 {

    public String longestDiverseString(int a, int b, int c) {
        Queue<int[]> pq = new PriorityQueue<>((o1, o2) -> o2[1]-o1[1]);
        if (a > 0) pq.offer(new int[]{1, a});
        if (b > 0) pq.offer(new int[]{2, b});
        if (c > 0) pq.offer(new int[]{3, c});
        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        while (!pq.isEmpty()) {
            int[] f  = pq.poll();
            cnt++;
            sb.append(get(f[0]));
            if (cnt == 2) {
                cnt = 0;
                if (pq.isEmpty()) break;
                int[] s = pq.poll();
                sb.append(get(s[0]));
                if (s[1] > 1) pq.offer(new int[]{s[0], s[1] - 1});
            }
            if (f[1] > 1) pq.offer(new int[]{f[0], f[1] - 1});
        }
        return sb.toString();
    }

    private String get(int v) {
        if (v == 1) return "a";
        if (v == 2) return "b";
        return "c";
    }
}
