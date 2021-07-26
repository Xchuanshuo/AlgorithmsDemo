package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Legend
 * @data by on 21-6-25.
 * @description https://leetcode-cn.com/problems/integer-replacement/
 * idea:
 *      记忆化搜索
 */
public class Test397 {

    Map<Long, Integer> map = new HashMap<>();
    public int integerReplacement(int n) {
        return dfs(n);
    }

    private int dfs(long n) {
        if (n == 1) return 0;
        if (map.containsKey(n)) return map.get(n);
        int res = 0;
        if ((n&1) == 0) {
            res = 1 + dfs(n / 2);
        } else {
            res = 1 + Math.min(dfs(n+1), dfs(n-1));
        }
        map.put(n, res);
        return map.get(n);
    }
}
