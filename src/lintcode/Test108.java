package lintcode;

/**
 * @author Legend
 * @data by on 18-8-16.
 * @description palindrome-partitioning-ii
 * idea:
 *      dp问题 这道题和perfect-squares(Test513)类似
 *      这里需要用一个辅助数组来记录isPalindrome[j,i]位置的字符串是否为回文字符串
 *      dp[i] 表示[1,i]位置的回文串最小分割次数
 *      所以dp[i]为i位置前面的字符串最小的分割次数+后面某一次的分割
 *      可以得到状态转移方程 dp[i]=min(dp[i], dp[j]+1)
 *      也就是说遍历到某两个字符时 它中间的字符串也满足回文的条件
 */
public class Test108 {

    public int minCut(String s) {
        // write your code here
        int n = s.length();
        boolean[][] isPalindrome = new boolean[n][n];
        int[] dp = new int[n+1];
        dp[0] = -1;
        for (int i=0;i<n;i++) {
            dp[i+1] = i;
            for (int j=0;j<=i;j++) {
                if (s.charAt(i)==s.charAt(j) && (i-j<2||isPalindrome[j+1][i-1])) {
                    isPalindrome[j][i] = true;
                    dp[i+1] = Math.min(dp[i+1], dp[j]+1);
                }
            }
        }
        return dp[n];
    }
}
