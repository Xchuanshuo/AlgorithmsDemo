package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Legend
 * @data by on 21-6-24.
 * @description https://leetcode-cn.com/problems/sort-integers-by-the-power-value/
 * idea:
 *      记忆化搜索
 */
public class Test1387 {

    Map<Integer, Integer> map = new HashMap<>();
    public int getKth(int lo, int hi, int k) {
        int n = hi - lo + 1;
        int[][] arr = new int[n][2];
        for (int i = lo;i <= hi;i++) {
            arr[i-lo] = new int[]{i, helper(i)};
        }
        Arrays.sort(arr, (o1, o2) -> {
            if (o1[1] == o2[1]) return o1[0] - o2[0];
            return o1[1] - o2[1];
        });
        return arr[k-1][0];
    }

    private int helper(int cur) {
        if (cur == 1)return 0;
        if (map.containsKey(cur)) return map.get(cur);
        int res = 0;
        if ((cur&1) == 0) {
            res = 1 + helper(cur/2);
        } else {
            res = 1 + helper(3*cur+1);
        }
        map.put(cur, res);
        return res;
    }
}
