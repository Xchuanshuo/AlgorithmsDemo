package lintcode;

import java.util.*;

/**
 * @author Legend
 * @data by on 18-8-13.
 * @description sliding-puzzle-ii
 * idea:
 *      类似于拼图游戏 用bfs 需要在注意的是 每次移动时都需要与移动位置的值进行交换
 *      每次移动后要与最终结果进行比较 如果每次都遍历整个数组 复杂度也未免太高了
 *      所以一个好的办法是把board转化为字符串 然后进行操作 每次移动后的结果
 *      保存到Set进行去重 比较的时候只需要比较与所求结果转化的字符串是否相等
 */
public class Test794 {

    private int row, col;
    private static final int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int minMoveStep(int[][] init_state, int[][] final_state) {
        // # write your code here
        row = init_state.length;
        col = init_state[0].length;
        int result = 0;
        String start = matrixToString(init_state);
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

    public static void main(String[] args) {
        Test794 test = new Test794();
        int[][] init_state = {{2, 8, 3}, {1, 0, 4}, {7, 6, 5}};
        int[][] final_state = {{1, 2, 3}, {8, 0, 4}, {7, 6, 5}};
        System.out.println(test.minMoveStep(init_state, final_state));
    }
}
