package lintcode;

/**
 * @author Legend
 * @data by on 18-8-23.
 * @description unique-binary-search-trees
 * idea:
 *      dp 这里求BST的形态数 但BST的唯一性貌似不那么好判断 后面注意到以
 *      某个节点为根节点时 它的形态数其实就是等于左右子树的排列数相乘
 *      以n=3为例 ，刚开始以1为根节点 2和3都比1大 所以只能放在1的右边
 *      而对于2和3而言 有有两种方式 要么3在2的右节点上 要么2在3的左节点
 *      所以以1为根节点的BST的形态有2*1(假设子树为空表示只有一种)种 然后以2为根节点
 *      此时只有1种方式 接着以3为根节点 与以1为根节点同理 所以n=3时总共有5种形态的BST
 *      对于n=0和n=1时 都表示只有一种排列 所以这里用dp[i]表示当有i个节点时 BST的形态数
 *      有多少种 dp[i]取决于 i前面所有的节点各自为根节点时BST的数量的和 而求前面的BST的数量
 *      也就是看 它们各自为根节点时 左右子树排列数的乘积 得出状态转移方程
 *      dp[i] += dp[j-1] * dp[i-j]
 */
public class Test163 {

    public int numTrees(int n) {
        // write your code here
        if (n==0) return 1;
        int[] dp = new int[n+1];
        dp[0] = dp[1] = 1;
        for (int i=2;i<=n;i++) {
            for (int j=1;j<=i;j++) {
                dp[i] += dp[j-1] * dp[i-j];
            }
        }
        return dp[n];
    }
}
