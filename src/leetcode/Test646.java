package leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Legend
 * @data by on 21-5-12.
 * @description https://leetcode-cn.com/problems/maximum-length-of-pair-chain/
 */
public class Test646 {

    public int findLongestChain(int[][] pairs) {
        int n = pairs.length;
        int[] dp = new int[n];
        Arrays.sort(pairs, Comparator.comparingInt(o -> o[1]));
        Arrays.fill(dp, 1);
        int max = 1;
        for (int i = 1;i < n;i++) {
            for (int j = 0;j < i;j++) {
                if (pairs[i][0] > pairs[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
