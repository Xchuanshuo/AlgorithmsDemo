package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Legend
 * @data by on 21-4-25.
 * @description https://leetcode-cn.com/problems/arithmetic-slices/
 * idea:
 *      dp[i]表示以位置i元素结尾的等差数列个数
 *      若a[i]-a[i-1] = a[i-1]-a[i-2] 则 dp[i] = dp[i-1] + 1
 */
public class Test413 {

    public int numberOfArithmeticSlices(int[] nums) {
        int n =  nums.length;
        if (n < 3) return 0;
        int[] dp = new int[n];
        int res = 0;
        for (int i = 2;i < n;i++) {
            if (nums[i] + nums[i-2] == 2*nums[i-1]) {
                dp[i] = dp[i-1] + 1;
            }
            res += dp[i];
        }
        return res;
    }
}
