package leetcode;

import java.util.*;

/**
 * @author Legend
 * @data by on 21-4-24.
 * @description https://leetcode-cn.com/problems/longest-arithmetic-subsequence/
 * idea:
 *      与斐波拉契数列长度(Test873)类似,但这里可能出现[重复]元素, 导致没法得到前面元素的准确位置
 *      (可以用一个列表来保存每个位置的索引即可)
 *      所以不能使用一样的方式去处理 这里用dp[i][d]表示以元素i位置结尾 且公差为d的最大公差序列长度
 *      状态: dp[i][d] = dp[j][d] + 1 其中d = A[i] - A[j]
 */
public class Test1027 {

    public int longestArithSeqLength2(int[] A) {
        int n = A.length;
        if (n <= 2) return n;
        int[][] dp = new int[n][20010];
        for (int[] d : dp) Arrays.fill(d, 1);
        int max = 1;
        for (int i = 1;i < n;i++) {
            for (int j = 0;j < i;j++) {
                int d  = A[i] - A[j] + 10000;
                dp[i][d] = dp[j][d] + 1;
                max = Math.max(max, dp[i][d]);
            }
        }
        return max;
    }

    public int longestArithSeqLength1(int[] A) {
        int n = A.length;
        if (n <= 2) return n;
        int[][] dp = new int[n][n];
        for (int[] d : dp) Arrays.fill(d, 2);
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0;i < n;i++) {
            if (!map.containsKey(A[i])) {
                map.put(A[i], new LinkedList<>());
            }
            map.get(A[i]).add(i);
        }
        int max = 2;
        for (int i = 2;i < n;i++) {
            for (int j = i - 1;j >= 0;j--) {
                int d = A[j] - (A[i] - A[j]);
                List<Integer> list = map.get(d);
                if (list == null) continue;
                for (int idx : list) {
                    if (idx >= j) break;
                    dp[i][j] = dp[j][idx] + 1;
                    max = Math.max(dp[i][j], max);
                }
            }
        }
        return max;
    }
}
