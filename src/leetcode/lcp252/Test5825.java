package leetcode.lcp252;

import java.util.*;

/**
 * @author Legend
 * @data by on 21-7-25.
 * @description https://leetcode-cn.com/contest/weekly-contest-251/problems/maximum-compatibility-score-sum/
 */
public class Test5825 {

    int res = 0;
    public int maxCompatibilitySum(int[][] students, int[][] mentors) {
        int m = students.length, n = students[0].length;
        int[][] scores = new int[m][m];
        for (int i = 0;i < m;i++) {
            for (int j = 0;j < m;j++) {
                for (int k = 0;k < n;k++) {
                    if (mentors[j][k] == students[i][k]) scores[i][j]++;
                }
            }
        }
        dfs(m, new boolean[m], scores, new LinkedList<>());
        return res;
    }

    private void dfs(int m, boolean[] visited, int[][] scores, List<Integer> list) {
        if (list.size() == m) {
            int sum = 0;
            for (int i = 0;i < m;i++) {
                sum += scores[i][list.get(i)];
            }
            res = Math.max(res, sum);
            return;
        }
        for (int i = 0;i < m;i++) {
            if (visited[i]) continue;
            visited[i] = true;
            list.add(i);
            dfs(m, visited, scores, list);
            visited[i] = false;
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        Test5825 test = new Test5825();
//        int[][] stus = {{1,1,0},{1,0,1},{0,0,1}};
//        int[][] mes = {{1,0,0},{0,0,1},{1,1,0}};
        int[][] stus = {{1,1,1},{0,0,1},{0,0,1},{0,1,0}};
        int[][] mes = {{1,0,1},{0,1,1},{0,1,0},{1,1,0}};
        System.out.println(test.maxCompatibilitySum(stus, mes));
    }
}
