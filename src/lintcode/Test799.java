package lintcode;

/**
 * @author Legend
 * @data by on 18-8-19.
 * @description backpack-viii
 * idea:
 *      背包问题 这个题目变成了求给定价值和数量的硬币能组合成0-n范围内值的种数
 *      所以这里可以用dp[i]表示价值总和为i有没有被已有的硬币组合出 因为这里的硬币
 *      有数量限制，这里还需要用到一个数组来记录已经使用的硬币数 use[i]表示价值为
 *      i时已经使用的硬币数量 然后这里还需要注意一下初始条件 dp[0]=true 总价值为0
 *      的硬币默认就是被组合出的
 */
public class Test799 {

    public int backPackVIII(int n, int[] value, int[] amount) {
        // write your code here
        boolean[] dp = new boolean[n+1];
        dp[0] = true;
        int count = value.length, result=0;
        for (int i=0;i<count;i++) {
            int[] use = new int[n+1];
            for (int j=value[i];j<=n;j++) {
                // 不算上当前的价值之前的价值已经被组合出 且当前价值还没有被组合出
                // 价值达到j-value[i]时已使用的硬币i的数量小于硬币i的总数量
                if (dp[j-value[i]] && !dp[j] && use[j-value[i]]<amount[i]) {
                    dp[j] = true;
                    result++;
                    use[j] = use[j-value[i]]+1;
                }
            }
        }
        return result;
    }
}
