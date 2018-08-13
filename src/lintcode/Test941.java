package lintcode;

import java.util.*;

/**
 * @author Legend
 * @data by on 18-8-13.
 * @description sliding-puzzle
 * idea:
 *      与sliding-puzzle(Test794)没多大区别
 */
public class Test941 {

    private int row, col;
    private static final int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int slidingPuzzle(int[][] board) {
        // # write your code here
        row = board.length;
        col = board[0].length;
        int[][] final_state = {{1, 2, 3}, {4, 5, 0}};
        int result = 0;
        String start = matrixToString(board);
        String end = matrixToString(final_state);
        Set<String> visitedSet = new HashSet<>();
        visitedSet.add(start);
        Queue<String> queue = new LinkedList<>();
        queue.offer(start);
        while (!queue.isEmpty()) {
            result++;
            int count = queue.size();
            for (int i=0;i<count;i++) {
                String cur = queue.poll();
                List<String> nextList = getNext(cur, visitedSet);
                for (String next: nextList) {
                    if (end.equals(next)) return result;
                    queue.offer(next);
                }
            }
        }
        return -1;
    }

    // 下一步可能移动的位置
    private List<String> getNext(String next, Set<String> visitedSet) {
        List<String> nextList = new ArrayList<>();
        int index = next.indexOf('0');
        int x = index/col, y = index%col;
        for (int i=0;i<4;i++) {
            int newX = x+dirs[i][0];
            int newY = y+dirs[i][1];
            if (newX>=0 && newX<row && newY>=0 && newY<col) {
                char[] chars = next.toCharArray();
                chars[x*col+y] = chars[newX*col+newY];
                chars[newX*col+newY] = '0';
                String cur = new String(chars);
                if (!visitedSet.contains(cur)) {
                    visitedSet.add(cur);
                    nextList.add(cur);
                }
            }
        }
        return nextList;
    }

    private String matrixToString(int[][] matrix) {
        StringBuilder builder = new StringBuilder();
        for (int i=0;i<row;i++) {
            for (int j=0;j<col;j++) {
                builder.append(matrix[i][j]+"");
            }
        }
        return builder.toString();
    }
}
