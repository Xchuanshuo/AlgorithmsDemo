package lintcode;

/**
 * @author Legend
 * @data by on 18-9-28.
 * @description
 */
public class Test746 {

    class TicTacToe {
        int[][] board = new int[3][3];
        private static final int X = 1;
        private static final int O = 2;
        int turn = X;
        boolean finished = false;

        public boolean move(int row, int col) throws GameEndException, AlreadyTakenException {
            if (finished) throw new GameEndException();
            if (row<0 || row>2 || col<0 || col>2 || board[row][col] != 0) throw new AlreadyTakenException();
            board[row][col] = turn;
            if (isWin(row, col, turn)) {
                String info = turn==X?"x":"o";
                info += " player wins!";
                System.out.println(info);
                finished = true;
            }
            turn = turn%2 + 1;
            return finished;
        }

        private boolean isWin(int row, int col, int turn) {
            int a=0,b=0,c=0,d=0;
            for (int i=0;i<3;i++) {
                if (board[row][i] == turn) a++;
                if (board[i][col] == turn) b++;
                if (board[i][i] == turn) c++;
                if (board[2-i][i] == turn) d++;
            }
            if (a==3 || b==3 || c==3 || d==3) {
                return true;
            }
            return false;
        }
    }

    class AlreadyTakenException extends Exception {
        public AlreadyTakenException() {
            super();
        }
    }

    class GameEndException extends Exception {
        public GameEndException() {
            super();
        }
    }
}
