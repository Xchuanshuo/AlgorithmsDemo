package lintcode;

/**
 * @author Legend
 * @data by on 18-6-28.
 * @description n-queens-ii
 */
public class Test34 {

    private static int result=0;

    public int totalNQueens(int n) {
        // write your code here
        if (n<=0) return 0;
        int[] cols = new int[n];
        helper(cols, 0);
        return result;
    }

    private void helper(int[] cols, int row) {
        if (row == cols.length) {
            result++;
            return;
        }
        for (int i=0;i<cols.length;i++) {
            if (isValid(cols, row, i)) {
                cols[row] = i;
                helper(cols, row+1);
            }
        }
    }

    private boolean isValid(int[] cols, int row, int column) {
        for (int i=0;i<row;i++) {
            if (cols[i] == column) return false;
            if ((row-i)==Math.abs(cols[i]-column)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Test34 test = new Test34();
        System.out.println(test.totalNQueens(17));
    }
}
