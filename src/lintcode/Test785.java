package lintcode;

/**
 * @author Legend
 * @data by on 18-9-5.
 * @description maximum-weighted-sum-path
 * idea:
 *      dp dp[i][j]表示坐标为(i,j)位置时的最大全值和路径 这里是机器人从右上角到左下
 *      角 可以转换为从左上角出发到右下角 这样只需去将左边和下边的值去比较大小 因为往下
 *      时可能出现越界的情况 所以从行边界的上面一行的位置开始记录 所以得到状态转移方程
 *      dp[i][j]=max(dp[i+1][j], dp[i][j-1])+nums[i][j-1]
 */
public class Test785 {

    public int maxWeight(int[][] nums) {
        int m = nums.length, n = nums[0].length;
        int[][] dp = new int[m+1][n+1];
        for(int i=m-1;i >= 0; i--){
            for(int j=1;j <= n; j++){
                dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]) + nums[i][j-1];
            }
        }
        return dp[0][n];
    }
}
