package lintcode;

/**
 * @author Legend
 * @data by on 18-8-21.
 * @description drop-eggs-ii
 * idea:
 *      dp dp[i][j]表示i个鸡蛋在j层楼最坏情况下最少的测试次数
 *      对于1个鸡蛋j层楼 最坏情况下需要次数是j次测试也就是k刚好为j时
 *      对于i个鸡蛋j层楼 测试到第k层楼时无非两种情况 如果鸡蛋破了 就
 *      继续用i-1个鸡蛋往k-1层遍历；如果鸡蛋没破 说明下面的楼层不可能是
 *      k层了 就往上面遍历 此时就是去用i个鸡蛋j-k层楼去取 因为这里是取最
 *      最坏情况下 所以上面这两种情况取之前测试过的最大值 然后与当前约束下
 *      已经测试过的最坏情况的相比较取最小值 得出状态转移方程
 *      dp[i][j]=min(dp[i][j], max(dp[i-1][k-1], dp[i][j-k]))
 */
public class Test584 {

    public int dropEggs2(int m, int n) {
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
}
