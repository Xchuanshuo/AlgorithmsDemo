package lintcode;

import java.util.Arrays;

/**
 * @author Legend
 * @data by on 18-9-10.
 * @description cheapest-flights-with-k-stops
 * idea:
 *      类似于求最短路径 不过限制了节点数 可以直接构造一张图后 进行dfs
 *      也可以使用动态规划 用dp[n][k]表示当终点为n，最多经过k个中转站时 最小的花费
 *      所以每次到达一个站点时 需要比较已有的到达该站点的路线(经过中转的路线)需要的花费
 *      和 从当前路线的起点 达到该站点的花费 取较小值 也就类似于最短路径的松弛操作 而从当前
 *      路线的起点直接达到该站点 需要的中转次数是需要减少的 所以最后可以得出状态转移方程
 *      dp[f[1]][i]=min(dp[f[1]][i], dp[f[0]][i-1]+f[2]) 其中f表示每条路线 i表示
 *      经过中转的次数 需要注意的是 对于起点 经过0次中转 因为没动 所以花费为0 即dp[src][0]=0
 */
public class Test1029 {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        // write your code here
        int[][] dp = new int[n][K+2];
        for (int[] arr: dp) Arrays.fill(arr, 10001);
        dp[src][0] = 0;
        for (int i=1;i<=K+1;i++) {
            for (int[] f: flights) {
                dp[f[1]][i] = Math.min(dp[f[1]][i], dp[f[0]][i-1] + f[2]);
            }
        }
        int result = 10001;
        for (int i=0;i<=K+1;i++) {
            result = Math.min(result, dp[dst][i]);
        }
        return result==10001?-1:result;
    }
}
