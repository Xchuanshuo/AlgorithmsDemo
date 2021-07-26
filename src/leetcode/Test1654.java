package leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @author Legend
 * @data by on 21-5-23.
 * @description https://leetcode-cn.com/problems/minimum-jumps-to-reach-home/
 */
public class Test1654 {

    public int minimumJumps(int[] forbidden, int a, int b, int x) {
        Set<String> set = new HashSet<>();
        for (int f : forbidden) {
            set.add(f+"_" + 0);
            set.add(f+"_" + 1);
        }
        Queue<Point> q = new LinkedList<>();
        int[] dir = {a, -b};
        q.offer(new Point(0));
        int res = 0;
        while (!q.isEmpty()) {
            res++;
            int size = q.size();
            for (int i = 0;i < size;i++) {
                Point cur = q.poll();
                if (cur.pos == x) return res - 1;
                for (int j = 0;j < dir.length;j++) {
                    int next = cur.pos + dir[j];
                    String k1 = next + "_" + 0;
                    String k2 = next + "_" + 1;
                    if (next <= 0 || next > 6000) continue;
                    if (cur.isBack && j == 1) continue;
                    if (j == 1 && !set.contains(k2)) {
                        set.add(k2);
                        q.offer(new Point(next, true));
                    } else {
                        if (!set.contains(k1)) {
                            set.add(k1);
                            q.offer(new Point(next, false));
                        }
                    }
                }
            }
        }
        return -1;
    }

    private class Point {
        boolean isBack = false;
        int pos;

        Point(int pos) {
            this.pos = pos;
        }

        Point(int pos, boolean isBack) {
            this.pos = pos;
            this.isBack = isBack;
        }
    }
}
