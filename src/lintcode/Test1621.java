package lintcode;

/**
 * @author Legend
 * @data by on 19-5-3.
 * @description cut-connection
 */
public class Test1621 {

    public int[][] removeOne(int[][] matrix, int x, int y) {
        while (x < matrix.length) {
            if (matrix[x][y] == 1) {
                matrix[x][y] = 0;
            }
            x++;
        }
        return matrix;
    }
}
