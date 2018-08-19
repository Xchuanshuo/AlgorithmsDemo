package lintcode;

/**
 * @author Legend
 * @data by on 18-8-19.
 * @description backpack-vii
 * idea:
 *      多重背包问题 与之前的背包问题类似 这里给物品个数加上了具体的限制
 *      而之前的普通背包问题要么重复取(无数个)要么不能重复取(1个) 所以
 *      首先有一个办法就是把多重背包问题装化为普通的背包问题 也就是可以把
 *      这里的物品个数拆分出来 每个数量都变成一个把相同的物品当作不同的
 *      每个物品对应的价值都是 这样就可以用之前的办法去解决 或者直接按
 *      数量去遍历即可 既然有数量限制 那就给它在这个限制下循环几遍不重复的
 *      情况 其实只要理解了之前的背包问题 这个理解起来就也非常自然了
 */
public class Test798 {

    public int backPackVII(int n, int[] prices, int[] weight, int[] amounts) {
        // write your code here
        int[] dp = new int[n+1];
        for (int i=0;i<prices.length;i++) {
            for (int j=1;j<=amounts[i];j++) {
                for (int k=n;k>=prices[i];k--) {
                    dp[k] = Math.max(dp[k], weight[i]+dp[k-prices[i]]);
                }
            }
        }
        return dp[n];
    }
}
