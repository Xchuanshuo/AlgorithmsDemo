package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Legend
 * @data by on 21-7-7.
 * @description https://leetcode-cn.com/problems/count-good-meals/
 */
public class Test1711 {

    public int countPairs(int[] des) {
        Map<Integer, Integer> map = new HashMap<>();
        int M = (int)1e9 + 7, res = 0;
        int max = (1 << 21) + 1;
        for (int i = 0;i < des.length;i++) {
            int d = des[i];
            for (int j = 1;j < max;j<<=1) {
                int cnt = map.getOrDefault(j - d, 0);
                res = (res + cnt)%M;
            }
            map.put(d, map.getOrDefault(d, 0) + 1);
        }
        return res;
    }
}
