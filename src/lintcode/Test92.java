package lintcode;

/**
 * @author Legend
 * @data by on 18-8-19.
 * @description backpack
 * idea:
 *      背包问题 dp[j]表示大小为j的背包最多可装的空间 每次需要比较取或者不取
 *      当前物品时 背包所用的总空间的大小 取当前物品时就是dp[j-A[i]]+A[i]
 *      表示大小为j-A[i]时最多可装的总空间 然后加上需要取的物品需要占用的空间A[i]
 *      因为这里物品不能重复取 所以实现时在内循环的遍历需要从最大容量m开始 表示
 *      大小已经为{m..A[i]}时背包最多可装的空间(要么当前不取A[i],要么取A[i])
 *      这样保证了每次在该大小的物品时时 只取了一次当前物品
 */
public class Test92 {

    public int backPack(int m, int[] A) {
        // write your code here
        int[] dp = new int[m+1];
        for (int i=0;i < A.length;i++) {
            for (int j=m;j >= A[i];j--) {
                // 每次比较不取当前物品和取出当前物品的总大小
                dp[j] = Math.max(dp[j], A[i]+dp[j-A[i]]);
            }
        }
        return dp[m];
    }
}
