package lintcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Legend
 * @data by on 19-5-10.
 * @description matrix-zigzag-traversal
 * idea:
 *      看似简单的题目还是挺容易出错的 注意边界条件！!
 */
public class Test185 {

    private int i = 0;
    public int[] printZMatrix(int[][] matrix) {
        int x1 = 0, y1 = 0, x2 = 0, y2 = 0;
        int endX = matrix.length - 1, endY = matrix[0].length - 1;
        int[] result = new int[(endX+1) * (endY+1)];
        boolean dir = true;
        while (x2 != endX + 1) {
            helper(matrix, x1, y1, x2, y2, dir, result);
            y1 = x1 == endX ? y1 + 1 : 0;
            x1 = x1 == endX ? x1 : x1 + 1;
            x2 = y2 == endY ? x2 + 1: 0;
            y2 = y2 == endY ? y2 : y2 + 1;
            dir = !dir;
        }
        return result;
    }

    private void helper(int[][] matrix, int x1, int y1, int x2, int y2,
                        boolean dir, int[] result) {
        System.out.println("p1: " + x1 + ":" + y1 + ", p2: "+ x2 + ":" + y2);
        if (dir) {
            while (y1 != y2+1) result[i++] = matrix[x1--][y1++];
        } else {
            while (x2 != x1+1) result[i++] = matrix[x2++][y2--];
        }
    }

    public static void main(String[] args) {
        int[][] matrix = { {1, 2, 3, 4},
                           {5, 6, 7, 8},
                           {9, 10, 11, 12}};
        Test185 test = new Test185();
        int[] result = test.printZMatrix(matrix);
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}
