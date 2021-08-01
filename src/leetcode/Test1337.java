package leetcode;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author Legend
 * @data by on 21-8-1.
 * @description https://leetcode-cn.com/problems/the-k-weakest-rows-in-a-matrix/
 */
public class Test1337 {

    public int[] kWeakestRows(int[][] mat, int k) {
        Queue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1[0] == o2[0]) return o1[1] - o2[1];
            return o1[0] - o2[0];
        });
        int m = mat.length, n = mat[0].length;
        for (int i = 0;i < m;i++) {
            int cnt = 0;
            for (int j = 0;j < n;j++) {
                if (mat[i][j] == 1) cnt++;
            }
            pq.offer(new int[]{cnt, i});
        }
        int[] res = new int[k];
        for (int i = 0;i < k;i++) {
            res[i] = pq.poll()[1];
        }
        return res;
    }
}
