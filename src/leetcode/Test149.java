package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Legend
 * @data by on 21-6-24.
 * @description https://leetcode-cn.com/problems/max-points-on-a-line
 * idea:
 *      计算对于同一个点的斜率, 有多少相同的, 说明有多少个点在同一直线上
 *      时间复杂度 O(n^2) 空间: O(n)
 */
public class Test149 {

    public int maxPoints(int[][] points) {
        int res = 0, n = points.length;
        if (n == 1) return 1;
        for (int i = 0;i < n;i++) {
            Map<Double, Integer> map = new HashMap<>();
            for (int j = 0;j < n;j++) {
                if (j == i) continue;
                double k = 1.0*(points[j][1] - points[i][1]) /
                        (points[j][0] - points[i][0]);
                if (map.containsKey(k)) {
                    map.put(k, map.get(k) + 1);
                } else {
                    map.put(k, 2);
                }
            }
            for (int v : map.values()) {
                res = Math.max(res, v);
            }
        }
        return res;
    }
}
