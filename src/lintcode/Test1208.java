package lintcode;

/**
 * @author Legend
 * @data by on 18-9-13.
 * @description target-sum
 * idea:
 *      可以用dfs，也可以用dp dp[i][j]表示前i个数目标值为j的总数 而dp[i]只与dp[i-1]和
 *      nums[i]有关 所以可以优化成一维矩阵 题目中说明了和的总值不超过1000 因此目标值在
 *      -1000..1000之间 为了方便计算 可以进行偏移 使目标值位于0..2000之间 所以计算时
 *      就是看 目标值为i的总数加上当前是+或者-的情况，最后的结果也需要在s的基础上偏移
 *      offset(nums总和)个单位 其实这里的状态转移方程应该是有两种不同的写法的
 *            1.dp[i][j]=dp[i-1][j-num]+dp[i-1][j+num]
 *       2.dp[i][j-num]+=dp[i-1][j], dp[i][j+num]+=dp[i-1][j]
 *      最后还需要注意下初始条件 dp[offset]=1 相当于目标值为0的情况
 *          这道用dfs的解法还是比较通俗易懂
 */
public class Test1208 {

    public int findTargetSumWays(int[] nums, int s) {
        int sum = 0;
        for (int num: nums) sum += num;
        if (sum < s) return 0;
        int offset = sum;
        int maxN = sum*2 + 1;
        int[] dp = new int[maxN];
        dp[offset] = 1;
        for (int num: nums) {
            int[] temp = new int[maxN];
            for (int i=num;i<maxN-num;i++) {
                temp[i+num] += dp[i];
                temp[i-num] += dp[i];
            }
            dp = temp;
        }
        return dp[s+offset];
    }

    private int count = 0;
    public int findTargetSumWays2(int[] nums, int s) {
        // Write your code here
        if (nums==null || nums.length==0) return 0;
        dfs(nums, s, 0, 0);
        return count;
    }

    private void dfs(int[] nums, int s, int index, int result) {
        if (index == nums.length) {
            if (result == s) {
                count++;
            }
            return;
        }
        int current = nums[index];
        dfs(nums, s, index+1, result+current);
        dfs(nums, s, index+1, result-current);
    }
}
