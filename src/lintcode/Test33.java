package lintcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Legend
 * @data by on 18-6-28.
 * @description n-queens
 */
public class Test33 {

    private final List<List<String>> results = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        // write your code here
        if (n<=0) return results;
        search(new ArrayList<>(), n);
        return results;
    }

    private void search(List<Integer> cols, int n) {
        if (cols.size()==n) {
            results.add(generateBoard(cols));
            return;
        }
        for (int colIndex=0;colIndex<n;colIndex++) {
            if (!isValid(cols, colIndex)) continue;
            cols.add(colIndex);
            search(cols, n);
            cols.remove(cols.size()-1);
        }
    }

    // 生产对应的棋盘
    private List<String> generateBoard(List<Integer> cols) {
        List<String> board = new ArrayList<>();
        for (int i=0;i<cols.size();i++) {
            StringBuilder builder = new StringBuilder();
            for (int j=0;j<cols.size();j++) {
                builder.append(j==cols.get(i)?'Q':'.');
            }
            board.add(builder.toString());
        }
        return board;
    }

    // 验证皇后的位置是否满足行、列、对角线都只有一个
    private boolean isValid(List<Integer> cols, int column) {
        int row = cols.size();
        for (int rowIndex=0;rowIndex<cols.size();rowIndex++) {
            if (cols.get(rowIndex) == column) {
                return false;
            }
            //　/右斜对角线
            if (rowIndex+cols.get(rowIndex) == row+column) {
                return false;
            }
            // \左斜对角线
            if (rowIndex-cols.get(rowIndex) == row-column) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Test33 test = new Test33();
        System.out.println(test.solveNQueens(4));
    }
}
