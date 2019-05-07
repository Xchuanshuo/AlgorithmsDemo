package lintcode;

/**
 * @author Legend
 * @data by on 19-5-6.
 * @description digital-flip
 * idea:
 *      dp 分别保存flip为1或者0的情况 用dp[i][0]表示当前位置flip->0需要的总次数 dp[i][1]表示该位置flip->1需要的总次数
 *      当前位置flip为0时 前面的数为1或者0都满足条件 取最小 即dp[i][0]=min(dp[i-1][0],dp[i-1][1]) + (cur==0? 0 : 1)
 *      当前位置flip为1时 前面的数必须为1才满足条件 即 dp[i][1] = dp[i-1][1] + (cur==1? 0 : 1)
 *                      最后直接比较flip为1还是为0需要的次数更加少
 */
public class Test843 {

    public int flipDigit(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int n = nums.length;
        int[][] dp = new int[n+1][2];
        for (int i = 1;i <= n;i++) {
            dp[i][0] = Math.min(dp[i-1][0], dp[i-1][1]) + (nums[i-1]==0 ? 0 : 1);
            dp[i][1] = dp[i-1][1] + (nums[i-1]==1 ? 0 : 1);
        }
        return Math.min(dp[n][0], dp[n][1]);
    }

    public static void main(String[] args) {
        int[] nums = {1,0,0,1,1,1};
        Test843 test = new Test843();
        System.out.println(test.flipDigit(nums));
    }
}
