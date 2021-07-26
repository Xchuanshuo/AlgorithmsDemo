package leetcode;

/**
 * @author Legend
 * @data by on 21-6-8.
 * @description https://leetcode-cn.com/problems/last-stone-weight-ii/
 */
public class Test1049 {

    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for (int s : stones) sum += s;
        int[] dp = new int[sum/2+1];
        for (int i = 0;i < stones.length;i++) {
            for (int j = sum/2;j >= stones[i];j--) {
                dp[j] = Math.max(dp[j], dp[j-stones[i]]+ stones[i]);
            }
        }
        return sum - 2*dp[sum/2];
    }
}
