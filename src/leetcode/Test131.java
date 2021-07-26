package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Legend
 * @data by on 21-4-16.
 * @description https://leetcode-cn.com/problems/palindrome-partitioning/
 * idea:
 *      dp + 回溯
 *      对于字符串 首先标记任意区间哪些字符串为回文串 dp[i][j]表示字符串中(i,j)的子串是否是回文串
 *      初始条件: 任意单个字符都是回文串 即dp[i][i]=true
 *      状态: dp[i][j] = s[i]==s[j] && dp[i+1][j-1]
 *      枚举所有长度的区间, 即可得出任意区间是否为回文串
 *
 *      回溯: 查看所有区间, 若左边区间为回文串, 即dp[l][i]=true 则继续往后查看
 *           直到查看完所有字符
 */
public class Test131 {

    List<List<String>> result = new ArrayList<>();
    public List<List<String>> partition(String s) {
        int n = s.length();
        if (n == 0) return result;
        boolean[][] dp = new boolean[n][n];
        for (int i = 0;i < n;i++) dp[i][i] = true;
        for (int len = 2;len <= n;len++) {
            for (int i = 0;i <= n-len;i++) {
                int j = i + len - 1;
                if (s.charAt(i) == s.charAt(j) && (len == 2 || dp[i+1][j-1])) {
                    dp[i][j] = true;
                }
            }
        }
        helper(s, 0, new ArrayList<>(), dp);
        return result;
    }

    private void helper(String s, int l, List<String> list, boolean[][] dp) {
        if (l == s.length()) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = l;i < s.length();i++) {
            if (dp[l][i]) {
                list.add(s.substring(l, i + 1));
                helper(s, i + 1, list, dp);
                list.remove(list.size() - 1);
            }
        }
    }
}
