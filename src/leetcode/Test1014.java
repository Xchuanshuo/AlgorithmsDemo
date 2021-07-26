package leetcode;

/**
 * @author Legend
 * @data by on 21-6-24.
 * @description https://leetcode-cn.com/problems/best-sightseeing-pair/
 */
public class Test1014 {

    public int maxScoreSightseeingPair(int[] values) {
        int n = values.length, max = 0;
        int dp = values[0];
        for (int i = 1;i < n;i++) {
            max = Math.max(max, dp + values[i] -i);
            dp = Math.max(dp, values[i] + i);
        }
        return max;
    }
}
