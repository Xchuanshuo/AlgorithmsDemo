package lintcode;

/**
 * @author Legend
 * @data by on 20-3-16.
 * @description longest-valid-parentheses
 *  https://leetcode-cn.com/problems/longest-valid-parentheses/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-w-7/
 *  idea:
 *   这道题有多种解法 这里主要说下dp的思路 用dp[i]表示以位置i所在字符结尾的最大合法括号序列的长度
 *   如果当前字符是右括号 有两种情况
 *   1.当前字符i的前一个字符是左括号 形如()()...()这种, 那么算当前最大长度时应该用该位置
 *   前面两个位置的最大长度 + 2 即 dp[i] = dp[i-2] + 2 (i-2 >= 0)
 *   2.当前字符i的前一个字符是右括号, 形如((.....))这种 那么就要查看i-dp[i-1]-1位置是否是左括号, 是左括号
 *   则要用它前一个位置的结尾字符的最大长度 + 2 + 当前位置的前一个位置的最大长度
 *   即 dp[i] = dp[i-1] + dp[i-dp[i-1]-2] + 2 (i-dp[i-1]-2 >= 0)
 */
public class Test193 {

    public int longestValidParentheses(String s) {
        // write your code here
        int[] dp = new int[s.length()];
        int max = 0;
        for (int i = 1;i < s.length();i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i-1) == '(') {
                    dp[i] = (i - 2 >= 0 ? dp[i-2] : 0) + 2;
                } else if (i-dp[i-1]-1>= 0 && s.charAt(i-dp[i-1]-1) == '(') {
                    dp[i] = dp[i-1] + (i-dp[i-1] - 2 >= 0 ? dp[i-dp[i-1]-2] : 0) + 2;
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
