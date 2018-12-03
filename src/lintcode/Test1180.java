package lintcode;

/**
 * @author Legend
 * @data by on 18-12-3.
 * @description remove-boxes
 * idea:
 *      动态规划 + 分治
 *      dp[l][r][k] 表示在区间l..r内 移除k个箱子所能获得的最高分
 */
public class Test1180 {

    public int removeBoxes(int[] boxes) {
        // write your code here
        int size = boxes.length;
        int[][][] dp = new int[size][size][size];
        return helper(boxes, dp, 0, size-1, 0);
    }

    private int helper(int[] boxes, int[][][] dp, int l, int r, int k) {
        if (l > r) return 0;
        if (dp[l][r][k] != 0) return dp[l][r][k];
        while (r>1 && boxes[r] == boxes[r-1]) {
            r--;
            k++;
        }
        dp[l][r][k] = helper(boxes, dp, l, r-1, 0) + (k+1)*(k+1);
        for (int i=l;i<r;i++) {
            if (boxes[i] == boxes[r]) {
                dp[l][r][k] = Math.max(dp[l][r][k], helper(boxes, dp, l, i, k+1)
                        +helper(boxes, dp, i+1, r-1, 0));
            }
        }
        return dp[l][r][k];
    }
}
