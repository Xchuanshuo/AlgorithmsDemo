package leetcode;

/**
 * @author Legend
 * @data by on 21-4-16.
 * @description https://leetcode-cn.com/problems/unique-binary-search-trees/
 * idea:
 *      dp[i]为前i个节点所有不同形态的二叉树数量
 *      直接累加前i个节点中以任意节点[j为根节点]的二叉树数量
 *      即 dp[i] += dp[j-1]*d[i-j]
 *      初始条件 dp[0]=1, 表示空树只有1棵
 */
public class Test96 {

    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1;i <= n;i++) {
            for (int j = 1;j <= i;j++) {
                dp[i] += dp[j-1] * dp[i - j];
            }
        }
        return dp[n];
    }
}
