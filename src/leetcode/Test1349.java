package leetcode;

import java.util.Arrays;

/**
 * @author Legend
 * @data by on 21-5-9.
 * @description https://leetcode-cn.com/problems/maximum-students-taking-exam/
 * idea:
 *      状压DP 穷举每排座位可以安排的方案数 2^n 第i排座位的分配情况可以由
 *             第i-1排的座位安排情况得到
 *
 *      https://leetcode-cn.com/problems/maximum-students-taking-exam/solution/can-jia-kao-shi-de-zui-da-xue-sheng-shu-ya-suo-zhu/
 */
public class Test1349 {

    public int maxStudents(char[][] seats) {
        int m = seats.length, n = seats[0].length;
        int state = 1 << n;
        int[] valid = new int[m];
        for (int i = 0;i < m;i++) {
            for (int j = 0;j < n;j++) {
                valid[i] |=  (seats[i][j] == '.' ? 1 : 0) << j;
            }
        }
        int[][] dp = new int[m][state];
        for (int[] d : dp) Arrays.fill(d, -1);
        int res = 0;
        for (int i = 0;i < m;i++) {
            for (int j = 0;j < state;j++) {
                if ((j & valid[i]) == j && (j&(j>>1)) == 0) {
                    if (i == 0) {
                        dp[i][j] = Integer.bitCount(j);
                    } else {
                        for (int k = 0;k < state;k++) {
                            if (dp[i-1][k] == -1) continue;
                            if ((j&(k>>1)) != 0 || (j&(k<<1)) != 0) continue;
                            dp[i][j] = Math.max(dp[i][j], dp[i-1][k] + Integer.bitCount(j));
                        }
                    }
                }
                res = Math.max(res, dp[i][j]);
            }
        }
        return res;
    }
}
