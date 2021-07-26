package leetcode;

import java.util.*;

/**
 * @author Legend
 * @data by on 21-6-20.
 * @description https://leetcode-cn.com/problems/freedom-trail/
 * idea:
 *      dp[i][j] 当前ring为位置j 拼出key的前i个字符 最少步数
 *     由 dp[i-1][k]转移过来 dp[i-1][k] + min(abs(j-k), n- abs(j-k)) + 1
 */
public class Test514 {

    public int findRotateSteps(String ring, String key) {
        char[] rings = ring.toCharArray();
        char[] keys = key.toCharArray();
        int m = keys.length, n = rings.length;
        int INF = (int)1e9;
        Map<Character, List<Integer>> map = new HashMap<>();
        for (int i = 0;i < rings.length;i++) {
            if (!map.containsKey(rings[i])) {
                map.put(rings[i], new ArrayList<>());
            }
            map.get(rings[i]).add(i);
        }
        int[][] dp = new int[m][n];
        for (int[] d : dp) Arrays.fill(d, INF);
        for (int k : map.get(keys[0])) {
            dp[0][k] = Math.min(k, n - k) + 1;
        }
        for (int i = 1;i < m;i++) {
            for (int j : map.get(keys[i])) {
                for (int k : map.get(keys[i-1])) {
                    dp[i][j] = Math.min(dp[i][j], dp[i-1][k]
                            + Math.min(Math.abs(j-k), n-Math.abs(j-k)) + 1);
                }
            }
        }
        int res = INF;
        for (int r : dp[m-1]) {
            res = Math.min(res, r);
        }
        return res;
    }
}
