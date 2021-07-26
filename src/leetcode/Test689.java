package leetcode;

/**
 * @author Legend
 * @data by on 21-6-22.
 * @description https://leetcode-cn.com/problems/maximum-sum-of-3-non-overlapping-subarrays/
 * idea:
 *      dp[i][j]表示前i个元素, 分隔成j个不重叠子数组最大值为多少
 *      对于dp[i][j]有两种情况 1.不包括当前元素, 前i-1个元素 分隔成j个数组
 *                          2.包括当前元素, 前i-k个元素分隔成 j-1个数组 + 当前元素结尾的大小为k的子数组
 *      两者取最大值 即 dp[i][j] = max(dp[i-1][j], dp[i-k][j-1] + cur)
 *
 *      要求最大子数组的开始索引, 且按字典序排序, 从前往后查找,
 *      若当前dp[i][j]=max, 说明找到了索引开始的位置i-k, 加上sum(i-k,i)后 使得dp[i][j]最大
 *      当前max减去这部分和, 继续查找
 */
public class Test689 {

    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int n = nums.length;
        int[] sum = new int[n+1];
        for (int i = 0;i < n;i++) sum[i+1] = sum[i] + nums[i];
        int[][] dp = new int[n+1][4];
        int max = 0;
        for (int j = 1;j <= 3;j++) {
            for (int i = j*k;i <= n;i++) {
                int cur = sum[i] - sum[i-k];
                dp[i][j] = Math.max(dp[i-1][j], dp[i-k][j-1] + cur);
                if (j == 3) max = Math.max(max, dp[i][j]);
            }
        }
        int[] res = new int[3];
        for (int j = 3;j >= 1;j--) {
            for (int i = 1;i <= n;i++) {
                if (dp[i][j] == max) {
                    res[j-1] = i - k;
                    max -= sum[i] - sum[i-k];
                    break;
                }
            }
        }
        return res;
    }
}
