package lintcode;

/**
 * @author Legend
 * @data by on 18-12-5.
 * @description plane-maximum-rectangle
 */
public class Test1644 {

    public int getMaximum(int[][] a) {
        // write your code here
        boolean[][] grid = new boolean[1001][1001];
        for (int[] arr: a) {
            grid[arr[0]][arr[1]] = true;
        }
        int max = Integer.MIN_VALUE;
        for (int i=0;i<a.length;i++) {
            int x1 = a[i][0];
            int y1 = a[i][1];
            for (int j=i+1;j<a.length;j++) {
                int x2 = a[j][0];
                int y2 = a[j][1];
                if (grid[x2][y1] == grid[x1][y2]) {
                    max = Math.max(max, Math.abs(x2-x1)*(y2-y1));
                }
            }
        }
        return max;
    }
}
