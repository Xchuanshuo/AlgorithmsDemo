package acwing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @author Legend
 * @data by on 21-8-28.
 * @description https://www.acwing.com/problem/content/description/3821/
 */
public class Test3821 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Queue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1[1] == o2[1]) return o1[0] - o2[0];
            return o1[1] - o2[1];
        });
        for (int i = 0;i < n;i++) {
            String[] str = br.readLine().split(" ");
            int l = Integer.parseInt(str[0]), r = Integer.parseInt(str[1]);
            pq.add(new int[]{l, r});
        }
        int res = 1;
        int[] pre = pq.remove();
        while (!pq.isEmpty()) {
            int[] cur = pq.remove();
            if (cur[0] > pre[1]) {
                res++;
                pre = cur;
            }
        }
        System.out.println(res);
    }
}
