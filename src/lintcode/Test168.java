package lintcode;

/**
 * @author Legend
 * @data by on 18-8-20.
 * @description burst-balloons
 * idea:
 *      dp 这个题目与stone-game(Test476)类似 dp[i][j]表示吹破i到j之间的气球
 *      可获得的最大分数 这里有一种情况 就是如果能吹的气球只剩下1个了 那么吹破这个
 *      气球可获得的分数就是本身 因为前面和后面都没有气球了 所以这里可以先对数据做
 *      一下预处理 把原来表示气球分数的数组 插入首尾两个分数为1的气球 这里对于dp[i][j]
 *      而言 在区间i..j任何一个地方k都有可能吹破气球 所以遍历可能存在的k 计算k点与其
 *      左右的乘积 取最大值 得出状态转移方程
 *      dp[i][j]=max(dp[i][j],dp[i][k]+dp[k][j]+nums[i]*nums[k]*nums[j])
 *       ----------------------
 *       也可以用分治+记忆化搜索来做 假设当前burst的是最后一个气球
 */
public class Test168 {

    public int maxCoins(int[] nums) {
        // write your code here
        nums = deal(nums);
        int n = nums.length;
        int[][] dp = new int[n][n];
        for (int i=n-1;i>=0;i--) {
            for (int j=i+2;j<n;j++) {
                for (int k=i+1;k<j;k++) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][k]+dp[k][j]+nums[i]*nums[k]*nums[j]);
                }
            }
        }
        return dp[0][n-1];
    }

    private int[] deal(int[] nums) {
        int[] newArray = new int[nums.length+2];
        newArray[0] = 1;
        newArray[newArray.length-1] = 1;
        for (int i=1;i<=nums.length;i++) {
            newArray[i] = nums[i-1];
        }
        return newArray;
    }

    int[][] memo;
    public int maxCoins2(int[] nums) {
        // write your code here
        nums = deal(nums);
        int n = nums.length;
        memo = new int[n][n];
        return helper(nums, 1, n-2);
    }

    private int helper(int[] nums, int i, int j) {
        if (i > j) return 0;
        if (memo[i][j] != 0) return memo[i][j];
        int max = 0;
        for (int k=i;k<=j;k++) {
            int left = helper(nums, i, k-1);
            int right = helper(nums, k+1, j);
            max = Math.max(max, left+right+nums[i-1]*nums[k]*nums[j+1]);
        }
        memo[i][j] = max;
        return max;
    }
}
