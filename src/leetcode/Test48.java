package leetcode;

/**
 * @author Legend
 * @data by on 21-6-6.
 * @description https://leetcode-cn.com/problems/rotate-image/
 */
public class Test48 {

    public void rotate(int[][] a) {
        int n = a.length;
        for (int i = 0;i  < n;i++) {
            for (int j = 0;j < i;j++) {
                int t = a[i][j];
                a[i][j]  = a[j][i];
                a[j][i] = t;
            }
        }
        for (int i = 0;i < n;i++) {
            for (int j = 0;j < n / 2;j++) {
                int t = a[i][j];
                a[i][j] = a[i][n-j-1];
                a[i][n-j-1] = t;
            }
        }
    }
}
