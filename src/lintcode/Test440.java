package lintcode;

/**
 * @author Legend
 * @data by on 18-8-19.
 * @description backpack-iii
 * idea:
 *      背包问题 同backpack-ii 但这里变成了同类物品可以重复的取 dp[j]表示大小为j
 *      的背包 可以放入背包物品的最大价值 同样两种状态 要么取要么不取 所以这里把j
 *      放到内循环时 需要从小到大遍历 假设当前大小j已经取了物品i 此时dp[j-A[i]]
 *      j是不断递增的 递增时又重复取到物品i 然后在下一轮循环相同的j大小下
 *      取其它物品时和已经重复取的方案做比较 即dp[j]=max(dp[j], V[i-1]+dp[j-A[i-1])
 */
public class Test440 {

    public int backPackIII(int[] A, int[] V, int m) {
        if (A==null || A.length==0 || V==null || V.length==0) return 0;
        int[] dp = new int[m+1];
        for (int i=1;i<=A.length;i++) {
            for (int j=A[i-1];j<=m;j++) {
                dp[j] = Math.max(dp[j], V[i-1] + dp[j-A[i-1]]);
            }
        }
        return dp[m];
    }
}
