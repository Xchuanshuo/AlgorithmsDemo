package leetcode;

/**
 * @author Legend
 * @data by on 21-4-24.
 * @description https://leetcode-cn.com/problems/distinct-subsequences-ii/
 * idea:
 *      对于每个位置i的字符c, 只需要统计以c结尾的所有不同子序列
 *      即把之前任意字符结尾的子序列 + 当前的字符
 *      最后还需要将当前字符与前面所有的字符组成1个新的序列
 */
public class Test940 {

    public int distinctSubseqII(String S) {
        char[] chars = S.toCharArray();
        int n = chars.length;
        int M = (int)1e9 + 7;
        int[] dp = new int[26];
        int res = 0;
        for (int i = 0;i < n;i++) {
            int sum = 0;
            for (int j = 0;j < 26;j++) {
                sum = (sum + dp[j])%M;
            }
            dp[chars[i] - 'a'] = sum + 1;
        }
        for (int i = 0;i < 26;i++) res = (res + dp[i])%M;
        return res;
    }
}
