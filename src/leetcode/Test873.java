package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Legend
 * @data by on 21-4-24.
 * @description https://leetcode-cn.com/problems/length-of-longest-fibonacci-subsequence/
 * idea:
 *      因为斐波拉契的当前数由前两个数决定, 所以用dp[i][j]表示以数arr[i]与arr[j]结尾的斐波拉契
 *      数列的最大长度为多少, 前一个数d=arr[i]-arr[j], 若前一个数d存在, 则可以与后两个数组成
 *      斐波那契数列 即 dp[i][j] = dp[j][pos[d]] + 1
 */
public class Test873 {

    public int lenLongestFibSubseq(int[] arr) {
        int n = arr.length;
        if (n < 3) return 0;
        int[][] dp = new int[n][n];
        for (int[] d : dp) Arrays.fill(d, 2);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0;i < n;i++) map.put(arr[i], i);
        int max = 0;
        for (int i = 2;i < n;i++) {
            for (int j = i - 1;j >= 0;j--) {
                int d = arr[i] - arr[j];
                if (map.containsKey(d) && map.get(d) < j) {
                    dp[i][j] = dp[j][map.get(d)] + 1;
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max;
    }
}
