package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author Legend
 * @data by on 21-7-14.
 * @description https://leetcode-cn.com/problems/the-skyline-problem/
 * idea:
 *      扫描线 + 堆
 */
public class Test218 {

    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<int[]> list = new ArrayList<>();
        for (int[] b : buildings) {
            list.add(new int[]{b[0], b[2]});
            list.add(new int[]{b[1], -b[2]});
        }
        Collections.sort(list, (o1, o2) -> {
            if (o1[0] == o2[0]) return o2[1] - o1[1];
            return o1[0] - o2[0];
        });
        List<List<Integer>> result = new ArrayList<>();
        PriorityQueue<Integer> q = new PriorityQueue<>((a, b)->b-a);
        q.offer(0); int last = -1;
        for (int[] p : list) {
            if (p[1] < 0) {
                q.remove(-p[1]);
            } else {
                q.add(p[1]);
            }
            int h = q.peek();
            if (h != last) {
                List<Integer> cur = new ArrayList<>();
                cur.add(p[0]); cur.add(h);
                result.add(cur);
            }
            last = h;
        }
        return result;
    }
}
