package lintcode;

/**
 * @author Legend
 * @data by on 18-8-22.
 * @description maximal-square-ii
 * idea:
 *      dp 与matrix-square解法一样 但这里是求对角线全为1最大正方形 且其它位置都为0
 *      dp[i][j]表示位置i,j位置对角线为1的最大矩阵的边长 这里因为是要考虑对角线全为1 所以
 *      除了当前左上角的位置外 实际还要考虑它的上边和左边 需要用两个多余的数组来记录这两个
 *      方向的情况 也就是为1就要将其置为0 只有除对角线外其它位置都为0 才满足题目的条件 同样的
 *      所求的对角线方向只要值为0就过滤掉 然后求dp[i][j]时 也是在左边、上边、左上这几个方向的
 *      值取最小值 因为对于位置i,j周围的位置 如果一直是满足题目的条件 也就是只有对角线为全为1
 *      那么对于左、上两边为0的数量肯定至少是大于等于对角位置的 也就是当 1 0 这种情况是相等
 *      其它情况就是大于了 如果小于就表明左边、上边有方向不是全为0      0 1
 *      此时不满足题意 那么已经存在的对角线为1的记录 就得作废 所以我们这里总是取最小值 来保证满足条件
 */
public class Test631 {

    public int maxSquare2(int[][] matrix) {
        // write your code here
        int row = matrix.length, col = matrix[0].length;
        int[][] dp = new int[row+1][col+1];
        int[][] left = new int[row+1][col+1];
        int[][] top = new int[row+1][col+1];
        int max = 0;
        for (int i=1;i<=row;i++) {
            for (int j=1;j<=col;j++) {
                int cur = matrix[i-1][j-1];
                left[i][j] = cur==0? left[i][j-1]+1 : 0;
                top[i][j] = cur==0? top[i-1][j]+1 : 0;
                dp[i][j] = cur==1? Math.min(Math.min(left[i][j-1], top[i-1][j]), dp[i-1][j-1])+1 : 0;
                max = Math.max(max, dp[i][j]);
            }
        }
        return max*max;
    }
}
