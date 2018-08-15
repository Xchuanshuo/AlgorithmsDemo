package lintcode;

/**
 * @author Legend
 * @data by on 18-8-15.
 * @description distinct-subsequences
 * idea:
 *      dp问题 与LCS的思想类似 dp[i][j]表示S[i]在T[j]中出现的次数
 *      所以 如果S[i]!=S[j] dp[i][j]就等效于dp[i-1][j]
 *          如果S[i]==S[j] 则dp[i][j]=dp[i-1][j-1]+dp[i-1][j]
 *          也就是 dp[i][j]可以直接用前面的i-1,j-1来表达
 *                也可以用当作不相等的处理一样
 *      T: rab | rab ra 当遍历到结尾的时候 不去掉T和S结尾的b的话 dp[4][3]=dp[3][3]
 *      S: rabb| rab rab 去掉时 则 dp[4][3]=dp[3][2]
 *      初始化条件是当每个字符与自身匹配的时候
 */
public class Test118 {

    public int numDistinct(String S, String T) {
        // write your code here
        if (null == S || null == T) {
            return 0;
        }
        int res[][] = new int[S.length()+1][T.length()+1];
        for (int i=0;i <= S.length();i++) {
            res[i][0] = 1;
        }

        for (int i=1;i<=S.length();i++) {
            for (int j=1;j<=T.length();j++) {
                res[i][j] = res[i-1][j];
                if (S.charAt(i-1) == T.charAt(j-1)) {
                    res[i][j] += res[i-1][j-1];
                }
            }
        }
        return res[S.length()][T.length()];
    }
}
