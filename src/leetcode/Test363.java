package leetcode;

import java.util.TreeSet;

/**
 * @author Legend
 * @data by on 21-4-22.
 * @description https://leetcode-cn.com/problems/max-sum-of-rectangle-no-larger-than-k/submissions/
 */
public class Test363 {

    public int maxSumSubmatrix(int[][] matrix, int t) {
        int m = matrix.length, n = matrix[0].length;
        int[][] preSum = new int[m+1][n+1];
        for (int j = 0;j < n;j++) {
            for (int i = 0;i < m;i++) {
                preSum[i+1][j+1] = preSum[i][j+1] + matrix[i][j];
            }
        }
        int max = -100001;
        for (int i = 0;i < m;i++) {
            for (int j = i;j < m;j++) {
                int cur = 0;
                TreeSet<Integer> set = new TreeSet<>();
                set.add(0);
                for (int k = 0;k< n;k++) {
                    cur += preSum[j+1][k+1] - preSum[i][k+1];
                    int d = cur - t;
                    Integer gt = set.ceiling(d);
                    if (gt != null) max = Math.max(max, cur - gt);
                    set.add(cur);
                }
            }
        }
        return max;
    }
}
