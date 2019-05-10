package lintcode;

/**
 * @author Legend
 * @data by on 19-5-11.
 * @description maximum-and-minimum
 */
public class Test770 {

    public int[] maxAndMin(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return new int[]{};
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int[] arr : matrix) {
            for (int a : arr) {
                min = Math.min(min, a);
                max = Math.max(max, a);
            }
        }
        return new int[]{max, min};
    }
}
