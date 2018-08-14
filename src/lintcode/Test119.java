package lintcode;

/**
 * @author Legend
 * @data by on 18-8-14.
 * @description edit-distance
 * idea:
 *      与LCS基本差不多 只是这里是相等时不做处理
 */
public class Test119 {

    public int minDistance(String word1, String word2) {
        // write your code here
        int m = word1.length();
        int n = word2.length();
        int res[][] = new int[m+1][n+1];
        // 初始化　直接全部删除的情况
        for (int i=1;i <= m;i++) {
            res[i][0] = i;
        }
        for (int j=1;j <= n;j++) {
            res[0][j] = j;
        }

        for (int i=1;i <= m;i++) {
            for (int j=1;j <= n;j++) {
                int insertion = res[i][j-1]+1;
                int deletion = res[i-1][j]+1;
                int replace = res[i-1][j-1]+(word1.charAt(i-1)==word2.charAt(j-1)?0:1);
                res[i][j] = Math.min(replace, Math.min(insertion, deletion));
            }
        }

        return res[m][n];
    }
}
