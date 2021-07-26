package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Legend
 * @data by on 21-4-16.
 * @description https://leetcode-cn.com/problems/scramble-string/
 * idea:
 *      解法1: 递归 + 记忆化 求1个字符s打乱后能否变成t,需要满足
 *          1.两个字符串长度相等 2.两个字符串由同样数量的多个字符组成
 *      直接枚举所有的字符串[分割]位置, 假设字符被分为(s1,s2) (t1,t2)
 *      两种情况(->代表可以转换为): 1.s1->t1  s2->t2  2.s1->t2, s2->t1
 *      然后使用map保存两个字符串能否进行转换的结果,进行记忆化搜索
 *
 *      解法2: dp, dp[i][j][k]表示字符串[s从i开始的k个长度的字符串] 能转换为[字符串t从j开始的长度为k的字符串]
 *      枚举字符串s与t所有开始的位置, 枚举从2-n长度的所有区间的 枚举区间内的所有点作为分割点
 *      状态同递归解法: 情况1. dp[i][j][k] && dp[i+k][j+k][len-k]
 *                    情况2. dp[i][j+len-k][k] && dp[i+k][j][len-k]
 *       满足一种情况则dp[i][j][len]为true 最后所求结果为 dp[0][0][n]
 */
public class Test87 {

    // 解法1
    private Map<String, Boolean> map = new HashMap<>();
    public boolean isScramble(String s1, String s2) {
        if (s1.equals(s2)) return true;
        String key = s1 + "_" + s2;
        if (map.containsKey(key)) return map.get(key);
        int[] cnt = new int[26];
        for (int i = 0;i < s1.length();i++) {
            cnt[s1.charAt(i) - 'a']++;
            cnt[s2.charAt(i) - 'a']--;
        }
        for (int i = 0;i < 26;i++) {
            if (cnt[i] != 0) return false;
        }
        for (int i = 1;i < s1.length();i++) {
            if (isScramble(s1.substring(0, i), s2.substring(0, i))
                    && isScramble(s1.substring(i), s2.substring(i))) {
                return true;
            }
            if (isScramble(s1.substring(0, i), s2.substring(s1.length() - i))
                    && isScramble(s1.substring(i), s2.substring(0, s1.length() - i))) {
                return true;
            }
        }
        map.put(key, false);
        return false;
    }

    // 解法2
    public boolean isScramble2(String s1, String s2) {
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        int m = c1.length, n = c2.length;
        if (m != n) return false;
        boolean[][][] dp = new boolean[n][n][n + 1];
        for (int i = 0;i < n;i++) {
            for (int j = 0;j < n;j++) {
                dp[i][j][1] = c1[i] == c2[j];
            }
        }
        for (int len = 2; len <=n;len++) {
            for (int i = 0;i <= n - len;i++) {
                for (int j = 0;j <= n - len;j++) {
                    for (int k = 1;k < len;k++) {
                        boolean f1 = dp[i][j][k] && dp[i+k][j+k][len - k];
                        boolean f2 = dp[i][j+len-k][k] && dp[i+k][j][len-k];
                        if (f1 || f2) {
                            dp[i][j][len] = true;
                            break;
                        }
                    }
                }
            }
        }
        return dp[0][0][n];
    }
}
