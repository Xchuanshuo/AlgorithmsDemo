package leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author Legend
 * @data by on 21-5-3.
 * @description https://leetcode-cn.com/problems/split-array-largest-sum/
 * idea:
 *      解法1. 动态规划 dp[i][k]表示前[0,i]个元素,切分成k个子数组 所有情况下,最大子数组和的最小值为多少
 *            因为是求每种不同切分方式最大和的最小值, 所有要枚举每种切分方式, 计算在一种切分方式中的最大值
 *            对于当前位置 切分k次的所有方式则取最小值即可 要快速求出一个区间内子数组的和 直接使用前缀和
 *            这里设j为i前面的某个位置 可以得出状态转移方程
 *            dp[i][k] = min(dp[i][k], max(dp[j][k-1], sum[i]-sum[j]))
 *     解法2. 二分查找 查找满足条件的左边界
 */
public class Test410 {

    public int splitArray(int[] nums, int m) {
        int n = nums.length, INF = (int)1e9 + 7;
        int[] sum = new int[n+1];
        for (int i = 0;i < nums.length;i++) sum[i+1] = sum[i] + nums[i];
        int[][] dp = new int[n][m+1];
        for (int[] d : dp) Arrays.fill(d, INF);
        for (int i = 0;i < n;i++) {
            dp[i][1] = sum[i+1];
            for (int k = 2;k <= m;k++) {
                for (int j = 0;j < i;j++) {
                    dp[i][k] = Math.min(dp[i][k], Math.max(dp[j][k-1], sum[i+1] - sum[j+1]));
                }
            }
        }
        return dp[n-1][m];
    }

    public int splitArray1(int[] nums, int m) {
        int l = 0, r = 0;
        for (int n : nums) {
            l = Math.max(l, n);
            r += n;
        }
        while (l <= r) {
            int mid = l + (r-l)/2;
            if (!canFinish(nums, m, mid)) {
                l = mid + 1;
            } else {
                if (mid == l || !canFinish(nums, m, mid - 1)) {
                    return mid;
                } else {
                    r = mid - 1;
                }
            }
        }
        return l;
    }

    private boolean canFinish(int[] nums, int m, int target) {
        int cnt = 1, sum = 0;
        for (int n : nums) {
            if (sum + n > target) {
                cnt++;
                sum = 0;
            }
            sum += n;
        }
        return cnt <= m;
    }

    public static void main(String[] args) {
        Test410 test = new Test410();
        int[] nums = {7,2,5,10,8};
        int m = 2;
        int res = test.splitArray1(nums, m);
        System.out.println(res);
    }
}
