package lintcode;

/**
 * @author Legend
 * @data by on 18-8-20.
 * @description maximal-square
 * idea:
 *      dp dp[i][j]表示位置i, j位置所构成全为1的正方形的最大边长
 *      如果在i,j位置有一个最大边长 那么这个最大边长-1肯定是前面某个
 *      位置的最大边长 要么在左上方 要么在上方 要么在左上方 所以这时
 *      取边长最小的位置 肯定是包含了这个位置的边长的 不然i,j位置就
 *      不会有这个最大边长
 */
public class Test436 {

    public int maxSquare(int[][] matrix) {
        // write your code here
        int col=matrix[0].length, row=matrix.length;
        int max = 0;
        int[][] dp = new int[row+1][col+1];
        for (int i=1;i<=row;i++) {
            for (int j=1;j<=col;j++) {
                if (matrix[i-1][j-1] == 1) {
                    dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1])+1;
                    max = Math.max(dp[i][j], max);
                }
            }
        }
        return max*max;
    }
}
