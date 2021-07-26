package leetcode;

/**
 * @author Legend
 * @data by on 21-5-5.
 * @description https://leetcode-cn.com/problems/stone-game-v/
 * idea:
 *      解法1. dfs + 记忆化搜索 枚举所有的使左右两边数字分割后区间长度大于1的方案,
 *            取所有方案中最大的值, 计算左右区间的和, 有三种情况
 *            1).左边区间的和小于右边区间, 右边丢弃, 继续递归处理左边的区间
 *            2).左边区间的和大于右边区间, 左边丢弃, 继续处理右边区间
 *            3).左右两边区间和相等, 分别计算1,2两种情况 取结果较大的方案
 *            递归终止条件: 只有一个数时 返回0; 有两个数时, 丢弃掉大的 返回较小的
 *           使用mem[l][r]保存[l,r]区间的计算结果, 防止重复计算
 *
 *     解法2. dp, 用dp[i][j]表示在区间[i,j]内, Alice能获得的最大分数
 *           状态转移方程同样根据上述的递推思路
 *           同样枚举区间[i,j]内所有的分割方式 假设分割点为k, 分为3种情况
 *           1).sum(i,k) < sum(k+1,j) dp[i][j] = sum(i,k) + dp[l][k]
 *           2).sum(i,k) > sum(k+1,j) dp[i][j] = sum(k+1,j) + dp[k+1][j]
 *           3).sum(i,k) = sum(k+1,j) dp[i][j] = max(1), 2))
 *           结果: dp[0][n-1]
 */
public class Test1563 {

    public int stoneGameV2(int[] stones) {
        int n = stones.length;
        int[] sum = new int[n+1];
        for (int i = 0;i < n;i++) sum[i+1] = sum[i] + stones[i];
        int[][] dp = new int[n][n];
        for (int len = 2;len <= n;len++) {
            for (int i = 0;i <= n - len;i++) {
                int j = i + len - 1;
                if (len == 2) {
                    dp[i][j] = Math.min(stones[i], stones[j]);
                } else {
                    for (int k = i;k < j;k++) {
                        int left = sum[k+1] - sum[i];
                        int right = sum[j+1] - sum[k+1];
                        if (left < right) {
                            dp[i][j] = Math.max(dp[i][j], left + dp[i][k]);
                        } else if (left > right) {
                            dp[i][j] = Math.max(dp[i][j], right + dp[k+1][j]);
                        } else {
                            int m = Math.max(left + dp[i][k], right + dp[k+1][j]);
                            dp[i][j] = Math.max(dp[i][j], m);
                        }
                    }
                }
            }
        }
        return dp[0][n-1];
    }

    public int stoneGameV1(int[] stones) {
        int n = stones.length;
        int[] sum = new int[n+1];
        for (int i = 0;i < n;i++) sum[i+1] = sum[i] + stones[i];
        int[][] mem = new int[n][n];
        return dfs(stones, 0, n - 1, sum, mem);
    }

    private int dfs(int[] stones, int l, int r, int[] sum, int[][] mem) {
        if (l == r) return 0;
        if (l + 1 == r ) return Math.min(stones[l], stones[r]);
        if (mem[l][r] != 0) return mem[l][r];
        int max = 0;
        for (int i = l;i < r;i++) {
            int left = sum[i+1] - sum[l];
            int right = sum[r+1] - sum[i+1];
            int m = 0;
            if (left < right) {
                m = left + dfs(stones, l, i, sum, mem);
            } else if (left > right){
                m = right + dfs(stones, i + 1, r, sum, mem);
            } else {
                m = Math.max(left + dfs(stones, l, i, sum, mem), right + dfs(stones, i + 1, r, sum, mem));
            }
            max = Math.max(max, m);
        }
        return mem[l][r] = max;
    }

    public static void main(String[] args) {
        Test1563 test = new Test1563();
        int[] stones = {6,2,3,4,5,5};
//        int[] stones = {1,1,2};
        int res = test.stoneGameV2(stones);
        System.out.println(res);
    }
}
