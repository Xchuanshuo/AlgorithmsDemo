package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Legend
 * @data by on 21-5-29.
 * @description https://leetcode-cn.com/problems/number-of-submatrices-that-sum-to-target/
 */
public class Test1074 {

    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int[][] sums = new int[m+1][n+1];
        for (int i = 1;i <= m;i++) {
            for (int j = 1;j <= n;j++) {
                sums[i][j] = sums[i-1][j] + matrix[i-1][j-1];
            }
        }

        int res = 0;
        for (int i = 1;i <= m;i++) {
            for (int k = i;k <= m;k++) {
                int sum = 0;
                Map<Integer, Integer> map = new HashMap<>();
                map.put(0, 1);
                for (int j = 1;j <= n;j++) {
                    int cur =  sums[k][j] - sums[i-1][j];
                    sum += cur;
                    int t = sum - target;
                    if (map.containsKey(t)) {
                        res += map.get(t);
                    }
                    map.put(sum, map.getOrDefault(sum, 0) + 1);
                }
            }
        }
        return res;
    }
}
