package lintcode;

/**
 * @author Legend
 * @data by on 18-8-24.
 * @description ones-and-zeroes
 * idea:
 *      dp 类似0-1背包问题 不过这里相当于有两个背包 一个装0的 一个装1的
 *      用dp[i][j]表示由i个0和j个1构成的字符串的最大个数 这里首先需要计算每个
 *      字符串中0和1的数量 这里以背包问题来讲 每个物品是占用空间A[i] 而这道题
 *      每个字符串就相当于一个物品 不过是装有0和1的物品 所以对于i个0和j个1大小的
 *      空间 可以构成的字符最大个数取决于 是否取当前这个装有0和1的物品 如果取的话
 *      就是前面的大小为i-count[0]和j-count[1]的空间可以构成的最大字符串个数+当前这1个物品(字符串)
 *      所以得到状态转移方程 dp[i][j]=max(dp[i][j], dp[i-count[0]][j-count[1]]+1);
 */
public class Test668 {

    public int findMaxForm(String[] strs, int m, int n) {
        // write your code here
        int[][] dp = new int[m+1][n+1];
        for (String str: strs) {
            int[] count = count(str);
            for (int i=m;i>=count[0];i--) {
                for (int j=n;j>=count[1];j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i-count[0]][j-count[1]]+1);
                }
            }
        }
        return dp[m][n];
    }

    private int[] count(String str) {
        int[] count = new int[2];
        for (int i=0;i<str.length();i++) {
            count[str.charAt(i)-'0']++;
        }
        return count;
    }
}
