package lintcode;

import tree.heap.Array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Legend
 * @data by on 18-8-18.
 * @description modern-ludo-i
 * idea:
 *
 */
public class Test1565 {

    public int modernLudo(int length, int[][] connections) {
        // Write your code here
        int[] dp = new int[length+1];
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] c: connections) {
            map.put(c[0], c[1]);
        }
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[1] = 0;
        for (int i=1;i<=length;i++) {
            for (int j=i+1, end=Math.min(i+6, length);j<=end;j++) {
                dp[j] = Math.min(dp[j], dp[i]+1);
            }
            if (map.containsKey(i)) {
                int con = map.get(i);
                dp[con] = Math.min(dp[con], dp[i]);
            }
        }
        return dp[length];
    }
}
