package leetcode;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author Legend
 * @data by on 21-5-19.
 * @description https://leetcode-cn.com/problems/find-kth-largest-xor-coordinate-value/
 */
public class Test1738 {

    public int kthLargestValue(int[][] matrix, int k) {
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m+1][n+1];
        Queue<Integer> pq = new PriorityQueue<>();
        for (int i = 1;i <= m;i++) {
            for (int j = 1;j <= n;j++) {
                dp[i][j] = dp[i-1][j]^dp[i][j-1]^dp[i-1][j-1]^matrix[i-1][j-1];
                if (pq.size() < k ) {
                    pq.offer(dp[i][j]);
                } else if (dp[i][j] > pq.peek() ) {
                    pq.poll(); pq.offer(dp[i][j]);
                }
            }
        }
        return pq.poll();
    }
}
