package leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Legend
 * @data by on 21-5-17.
 * @description https://leetcode-cn.com/problems/longest-string-chain/
 */
public class Test1048 {

    public int longestStrChain(String[] words) {
        int n = words.length;
        Arrays.sort(words, Comparator.comparingInt(String::length));
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int max = 0;
        for (int i = 1;i < n;i++) {
            for (int j = 0;j < i;j++) {
                if (words[i].length() - words[j].length() != 1) continue;
                if (isPrev(words[j], words[i])) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    private boolean isPrev(String w1, String w2) {
        boolean flag = true;
        int i = 0, j = 0;
        while (i < w1.length()) {
            char c1 = w1.charAt(i);
            char c2 = w2.charAt(j);
            if (c1 == c2) {
                i++; j++; continue;
            }
            if (!flag) return false;
            flag = false;
            j++;
        }
        return true;
    }
}
