package lintcode;

/**
 * @author Legend
 * @data by on 18-9-28.
 * @description valid-tic-tac-toe-state
 * idea:
 *      依次过滤掉不合法的状态即可
 */
public class Test1022 {

    private static final char X = 'X';
    private static final char O = 'O';

    public boolean validTicTacToe(String[] board) {
        // Write your code
        int oCount = 0, xCount = 0;
        for (String b: board) {
            for (char c: b.toCharArray()) {
                if (c == X) xCount++;
                if (c == O) oCount++;
            }
        }
        if (oCount != xCount && oCount != xCount-1) return false;
        if (win(board, X) &&  oCount != xCount - 1) return false;
        if (win(board, O) && oCount != xCount) return false;
        return true;
    }

    private boolean win(String[] b, int p) {
        for (int i=0;i<3;i++) {
            if (p==b[0].charAt(i) && p==b[1].charAt(i) && p==b[2].charAt(i)) {
                return true;
            }
            if (p==b[i].charAt(0) && p==b[i].charAt(1) && p==b[i].charAt(2)) {
                return true;
            }
        }
        if (p==b[0].charAt(0) && p==b[1].charAt(1) && p==b[2].charAt(2)) {
            return true;
        }
        if (p==b[0].charAt(2) && p==b[1].charAt(1) && p==b[2].charAt(0)) {
            return true;
        }
        return false;
    }
}
