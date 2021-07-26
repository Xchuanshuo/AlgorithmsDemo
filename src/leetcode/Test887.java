package leetcode;

/**
 * @author Legend
 * @data by on 21-6-10.
 * @description
 * idea:
 *      方法1 超时
 *      dp dp[i][j]表示i个鸡蛋在j层楼最坏情况下最少的测试次数
 *      对于1个鸡蛋j层楼 最坏情况下需要次数是j次测试也就是k刚好为j时
 *      对于i个鸡蛋j层楼 测试到第k层楼时无非两种情况 如果鸡蛋破了 就
 *      继续用i-1个鸡蛋往k-1层遍历；如果鸡蛋没破 说明下面的楼层不可能是
 *      k层了 就往上面遍历 此时就是去用i个鸡蛋j-k层楼去取 因为这里是取最
 *      最坏情况下 所以上面这两种情况取之前测试过的最大值 然后与当前约束下
 *      已经测试过的最坏情况的相比较取最小值 得出状态转移方程
 *      dp[i][j]=min(dp[i][j], max(dp[i-1][k-1], dp[i][j-k]) + 1)
 *
 *      方法2 逆向思维 直接算对于楼层为i, 鸡蛋个数为k时最多能测试的楼层数为多少
 *           当测试次数为i 使用鸡蛋为e个时 可测试楼层数超过n时, i即为最小次数
 *           要求当前次数i, k个鸡蛋能测试的楼层数, 分为两种情况
 *           1.鸡蛋碎了, 楼层数为 dp[i-1][k-1]
 *           2.鸡蛋没碎, 楼层数为 dp[i-1][k], 最后加上当前测试的1次
 *
 *           即 dp[i][k] = dp[i-1][k-1] + dp[i-1][k] + 1
 */
public class Test887 {

    public int superEggDrop1(int m, int n) {
        // write your code here
        int[][] dp = new int[m+1][n+1];
        for (int i=1;i<=m;i++) {
            for (int j=1;j<=n;j++) {
                dp[i][j] = Integer.MAX_VALUE;
                if (i == 1) {
                    dp[i][j] = j;
                } else {
                    for (int k=1;k<=j;k++) {
                        dp[i][j] = Math.min(dp[i][j], Math.max(dp[i-1][k-1], dp[i][j-k])+1);
                    }
                }
            }
        }
        return dp[m][n];
    }

    public int superEggDrop2(int e, int n) {
        if (e == 1)  return n;
        if (n == 1) return 1;
        int[][] dp = new int[n+1][e+1];
        for (int i = 1;i <= e;i++) dp[1][i] = 1;
        for (int i = 2;i <= n;i++) {
            for (int k = 1;k <= e;k++) {
                dp[i][k] = dp[i-1][k-1] + dp[i-1][k] + 1;
                if (dp[i][e] >= n) return i;
            }
        }
        return 0;
    }
}
