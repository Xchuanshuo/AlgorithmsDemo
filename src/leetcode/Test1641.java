package leetcode;

import java.util.Arrays;

/**
 * @author Legend
 * @data by on 21-5-23.
 * @description https://leetcode-cn.com/problems/count-sorted-vowel-strings/
 * idea:
 *      用dp[i]表示以第i个字符结尾的方案总数, 累加字典序小于等于字符i的方案即可
 */
public class Test1641 {

    public int countVowelStrings(int n) {
        int[] dp = new int[5];
        Arrays.fill(dp, 1);
        for (int k = 2;k <= n;k++) {
            for (int i = 4;i >= 0;i--) {
                for (int j = 0;j < i;j++) {
                    dp[i] += dp[j];
                }
            }
        }
        return Arrays.stream(dp).sum();
    }
}
