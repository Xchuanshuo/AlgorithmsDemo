package lintcode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Legend
 * @data by on 18-10-4.
 * @description paper-review
 * idea:
 *      并查集+dp
 */
public class Test1463 {

    private Map<String, String> parent = new HashMap<>();

    public float getSimilarity(List<String> words1, List<String> words2, List<List<String>> pairs) {
        // Write your code here
        int m=words1.size(), n=words2.size(), k=pairs.size();
        for (int i=0;i<m;i++) {
            parent.put(words1.get(i), words1.get(i));
        }
        for (int i=0;i<n;i++) {
            parent.put(words2.get(i), words2.get(i));
        }
        for (int i=0;i<k;i++) {
            String str1 = pairs.get(i).get(0);
            if (!parent.containsKey(str1)) {
                parent.put(str1, str1);
            }
            String str2 = pairs.get(i).get(1);
            if (!parent.containsKey(str2)) {
                parent.put(str2, str2);
            }
            union(str1, str2);
        }
        int[][] dp = new int[m+1][n+1];
        for (int i=1;i<=m;i++) {
            String str1 = find(words1.get(i-1));
            for (int j=1;j<=n;j++) {
                String str2 = find(words2.get(j-1));
                if (str1.equals(str2)) {
                    dp[i][j] = Math.max(dp[i-1][j-1]+1, dp[i][j]);
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return (float) (2.0*dp[m][n]/(m+n));
    }

    private String find(String str) {
        while (!str.equals(parent.get(str))) {
            parent.put(parent.get(str), parent.get(parent.get(str)));
            str = parent.get(str);
        }
        return parent.get(str);
    }

    private void union(String p, String q) {
        String pRoot = find(p);
        String qRoot = find(q);
        if (pRoot == qRoot) return;
        parent.put(pRoot, qRoot);
    }
}
