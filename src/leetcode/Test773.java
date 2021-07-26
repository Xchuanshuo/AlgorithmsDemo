package leetcode;

import java.util.*;

/**
 * @author Legend
 * @data by on 21-6-26.
 * @description https://leetcode-cn.com/problems/sliding-puzzle/submissions/
 */
public class Test773 {

    public int slidingPuzzle(int[][] board) {
        int m = board.length, n = board[0].length;
        char[] chs = new char[m*n];
        int k = 0;
        for (int i = 0;i < m;i++) {
            for (int j = 0;j < n;j++) chs[k++] = (char)(board[i][j] + '0');
        }
        String start = new String(chs), end = "123450";
        if (start.equals(end)) return 0;
        Set<String> set = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        set.add(start); q.offer(start);
        int step = 0;
        while (!q.isEmpty()) {
            step++;
            int size = q.size();
            for (int i = 0;i < size;i++) {
                String src = q.poll();
                List<String> nextList = getNext(m, n, src, set);
                for (String next : nextList) {
                    if (next.equals(end)) return step;
                    q.offer(next);
                }
            }
        }
        return -1;
    }

    int[][] dirs = {{0, 1}, {1, 0}, {0, - 1}, {-1, 0}};

    private List<String> getNext(int m, int n, String src, Set<String> set) {
        int idx = src.indexOf("0");
        List<String> list = new ArrayList<>();
        for (int i = 0;i < 4;i++) {
            int x = idx / n, y = idx%n;
            int nx = x + dirs[i][0];
            int ny = y + dirs[i][1];
            if (nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
            char[] chs = src.toCharArray();
            chs[x*n + y] = chs[nx*n + ny];
            chs[nx*n + ny] = '0';
            String str = new String(chs);
            if (set.contains(str)) continue;
            set.add(str);
            list.add(str);
        }
        return list;
    }
}
