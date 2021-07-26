package leetcode;

import java.util.Arrays;

/**
 * @author Legend
 * @data by on 21-5-17.
 * @description https://leetcode-cn.com/problems/filling-bookcase-shelves/
 * idea:
 *      dp[i]表示前i本书需要书架的整体最小高度 因为书本的排放是按照顺序的
 *      考虑当前的书本, 只需要看从当前书本往前,连续的几本书,厚度累加 <= width的情况下
 *      都可以与当前书本组成1层, 看连续几本书组成新的层 能使整体高度最小
 *      状态转移方程: dp[i] = min(dp[i], dp[j] + max)
 *                  表示前j本书组成的最小高度, 加上剩下的一层的最大书本高度
 *      初始条件: dp[0]=0, 表示0本书组成的最小高度为0
 *      结果: dp[n] 表示前n本书需要的书架最小高度
 */
public class Test1105 {

    public int minHeightShelves(int[][] books, int width) {
        int n = books.length, INF = (int)1e9;
        int[] dp = new int[n+1];
        Arrays.fill(dp, INF);
        dp[0] = 0;
        for (int i = 1;i <= n;i++) {
            int w = 0, max = 0;
            for (int j = i - 1;j >= 0;j--) {
                w += books[j][0];
                max = Math.max(max, books[j][1]);
                if (w > width) break;
                dp[i] = Math.min(dp[i], dp[j] + max);
            }
        }
        return dp[n];
    }
}
