package leetcode;


import java.util.Stack;

/**
 * @author Legend
 * @data by on 21-4-13.
 * @description https://leetcode-cn.com/problems/longest-valid-parentheses/
 * idea:
 *      解法1 栈模拟
 *      解法2 dp[i]表示以位置i的字符结尾的字符串的最长有效括号为多少
 *           只需要看到i-1位置最长的有效括号为多少
 *           并且当前字符(')')如果和i-1最大长度的前一个字符匹配('(')
 *           那么 dp[i] = dp[i-1] + 2
 *           还存在一种情况 ()(()) 处理完i=5位置的字符后 最大长度为4
 *           但前面还有匹配成功的 直接累加上前面匹配成功得到即是最后的结果
 */
public class Test32 {

    public int longestValidParentheses1(String s) {
        if (s == null || s.length() < 2) return 0;
        char[] chars = s.toCharArray();
        int[] mark = new int[chars.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0;i < chars.length;i++) {
            if (chars[i] == '(') {
                stack.push(i);
            } else {
                if (stack.isEmpty()) mark[i] = 1;
                else stack.pop();
            }
        }
        while (!stack.isEmpty()) {
            mark[stack.pop()] = 1;
        }
        int res = 0, t = 0;
        for (int i = 0;i < mark.length;i++) {
            t++;
            if (mark[i] == 1) t = 0;
            res = Math.max(res, t);
        }
        return res;
    }

    public int longestValidParentheses(String s) {
        if (s == null || s.length() < 2) return 0;
        char[] chars = s.toCharArray();
        int[] dp = new int[chars.length];
        int max = 0;
        for (int i = 1;i < chars.length;i++) {
            if (chars[i] == '(') continue;
            int len = dp[i-1];
            int pre = i - len - 1;
            if (pre >= 0 && chars[pre] == '(') {
                dp[i] = dp[i-1] + 2;
                if (pre - 1 >= 0) dp[i] += dp[pre - 1];
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
