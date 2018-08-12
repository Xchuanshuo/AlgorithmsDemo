package lintcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Legend
 * @data by on 18-8-8.
 * @description pacific-atlantic-water-flow
 */
public class Test778 {

    private int row, col;
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        // write your code here
        List<List<Integer>> result = new ArrayList<>();
        if (matrix==null || matrix.length==0) return result;
        row = matrix.length;
        col = matrix[0].length;
        boolean[][] toP = new boolean[row][col];
        boolean[][] toA = new boolean[row][col];
        for (int i=0;i<row;i++) {
            dfs(matrix, toP, i, 0, matrix[i][0]);
            dfs(matrix, toA, i, col-1, matrix[i][col-1]);
        }
        for (int i=0;i<col;i++) {
            dfs(matrix, toP, 0, i, matrix[0][i]);
            dfs(matrix, toA, row-1, i, matrix[row-1][i]);
        }
        for (int i=0;i<row;i++) {
            for (int j=0;j<col;j++) {
                if (toA[i][j] && toP[i][j]) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }
        return result;
    }

    private void dfs(int[][] matrix, boolean[][] visited, int i, int j, int preHeight) {
        if (i>=0 && i<row && j>=0 && j<col && !visited[i][j]
                && matrix[i][j]>=preHeight) {
            visited[i][j] = true;
            dfs(matrix, visited, i+1, j, matrix[i][j]);
            dfs(matrix, visited, i-1, j, matrix[i][j]);
            dfs(matrix, visited, i, j+1, matrix[i][j]);
            dfs(matrix, visited, i, j-1, matrix[i][j]);
        }
    }
}
