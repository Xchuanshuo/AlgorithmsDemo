package leetcode;

/**
 * @author Legend
 * @data by on 21-6-15.
 * @description https://leetcode-cn.com/problems/form-largest-integer-with-digits-that-add-up-to-target/
 * idea:
 *      完全背包问题, 将数值比较变成字符串表示的数字大小比较
 *      1.长度大的数值大
 *      2.长度相等的情况按ascii顺序比较
 */
public class Test1449 {

    public String largestNumber(int[] cost, int target) {
        String[] dp = new String[target + 1];
        dp[0] = "";
        for (int i = 1;i <= 9;i++) {
            int u = cost[i-1];
            for (int j = u;j <= target;j++) {
                if (dp[j-u] != null) {
                    dp[j] = max(dp[j], i + dp[j-u]);
                }
            }
        }
        return dp[target] == null ? "0" : dp[target];
    }

    public String max(String str1, String str2) {
        if (str1 == null) return str2;
        if (str2 == null) return str1;
        if (str1.length() > str2.length()) return str1;
        if (str2.length() > str1.length()) return str2;
        if (str1.compareTo(str2) < 0) {
            return str2;
        }
        return str1;
    }

    public static void main(String[] args) {
        Test1449 test = new Test1449();
        int[] cost = {4,3,2,5,6,7,2,5,5};
        int target = 9;
        System.out.println(test.largestNumber(cost, target));
    }
}
