package lintcode;

/**
 * @author Legend
 * @data by on 18-8-20.
 * @description maximal-square
 * idea:
 *      dp dp[i][j]表示位置i, j位置所构成全为1的正方形的最大边长
 *      如果在i,j位置有一个最大边长 那么这个最大边长-1肯定是前面某个
 *      位置的最大边长 要么在左方 要么在上方 要么在左上方 所以这时
 *      取边长最小的位置 肯定是包含了这个位置的边长的 不然i,j位置就
 *      不会有这个最大边长 这样说可能有点抽象 也就是在位置i,j 周围的
 *      几个方向 可能会有为0的 如果此时取较大的 那么最大边长会增加
 *      但是它不一定能和构成正方形 这时就与条件相悖了 所以取最小的 最差
 *      情况下 也就是边长为1；反之, 如果周围的几条刚好能和当前构成正方形 也就是都为1
 *      那么可能其它几个方向的值可能都相等，也有可能有位置于其它地方构成更大的
 *      边 但可能加进来当前后 这个大的范围正方形有不满足条件的 即为0的位置 既然不能
 *      保证 所以还是取最小的 保证结果绝对正确
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
