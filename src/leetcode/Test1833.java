package leetcode;

import java.util.Arrays;

/**
 * @author Legend
 * @data by on 21-7-7.
 * @description https://leetcode-cn.com/problems/maximum-ice-cream-bars/
 */
public class Test1833 {

    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int cnt = 0, sum = 0;
        for (int i = 0;i < costs.length;i++) {
            sum += costs[i];
            if (sum > coins) break;
            cnt++;
        }
        return cnt;
    }
}
