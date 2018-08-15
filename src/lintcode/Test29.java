package lintcode;

/**
 * @author Legend
 * @data by on 18-8-15.
 * @description interleaving-string
 * idea:
 *      dp问题 dp[i][j]表示s3[1,i+j] 是否由字符s1[1,i]和s2[1,j]组成
 *      所以 如果s1[i]==s3[i+j] 且 dp[i-1][j]=true;
 *          或者s2[j]==s3[i+j] 且 dp[i][j-1]=true;
 *      满足以上条件之一，dp[i][j]就为true，也就是说当前取到的s3里面的字符
 *      肯定来自s1或者s2 并且之前的字符也满足该条件
 */
public class Test29 {

    public boolean isInterleave(String s1, String s2, String s3) {
        // write your code here
        int l1=s1.length(), l2=s2.length(), l3=s3.length();
        if (l1+l2 != l3) return false;
        boolean[][] dp = new boolean[l1+1][l2+1];
        dp[0][0] = true;
        // 初始化
        for (int i=1;i<=l1;i++) {
            dp[i][0] = (dp[i-1][0] && s1.charAt(i-1)==s3.charAt(i-1));
        }
        for (int i=1;i<=l2;i++) {
            dp[0][i] = (dp[0][i-1] && s2.charAt(i-1)==s3.charAt(i-1));
        }
        for (int i=1;i<=l1;i++) {
            for (int j=1;j<=l2;j++) {
                dp[i][j] = (dp[i-1][j] && s1.charAt(i-1)==s3.charAt(i+j-1))
                        || (dp[i][j-1] && s2.charAt(j-1)==s3.charAt(i+j-1));
            }
        }
        return dp[l1][l2];
    }
}
