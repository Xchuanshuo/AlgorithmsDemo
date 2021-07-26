package leetcode;

/**
 * @author Legend
 * @data by on 21-5-18.
 * @description https://leetcode-cn.com/problems/partition-array-for-maximum-sum/
 * idea:
 *      dp[i]表示前i个元素最多分成大小为k的子数组的元素最大和
 *      枚举从i往前的k个元素即可, 假设枚举到位置j, 则此时的元素和为 dp[j-1]+(i-j+1)*max,
 *      即状态转移方程为 dp[i] = max(dp[i], dp[j-1]+(i-j+1)*max)
 *
 */
public class Test1043 {

    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n];
        for (int i = 0;i < n;i++) {
            int l = Math.max(0, i-k+1);
            int max = arr[i];
            for (int j = i;j >= l;j--) {
                max = Math.max(max, arr[j]);
                dp[i] = Math.max(dp[i], (j-1>=0? dp[j-1] : 0) + (i-j+1)*max);
            }
        }
        return dp[n-1];
    }
}
