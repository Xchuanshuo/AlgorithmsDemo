package leetcode;

import java.util.Arrays;

/**
 * @author Legend
 * @data by on 21-8-14.
 * @description https://leetcode-cn.com/problems/count-unhappy-friends/
 */
public class Test1583 {

    public int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
        int[][] rel = new int[n][n];
        for (int[] r : rel) Arrays.fill(r, -1);
        for (int i = 0;i < preferences.length;i++) {
            int[] preference = preferences[i];
            int val = preference.length;
            for (int p : preference) rel[i][p] = val--;
        }
        boolean[] noHappy = new boolean[n];
        for (int i = 0;i < pairs.length;i++) {
            int x1 = pairs[i][0], y1 = pairs[i][1];
            for (int j = 0;j < pairs.length;j++) {
                if (j == i) continue;
                int x2 = pairs[j][0], y2 = pairs[j][1];
                if (rel[x1][x2] > rel[x1][y1] && rel[x2][x1] > rel[x2][y2]) {
                    noHappy[x1] = noHappy[x2] = true;
                }
                if (rel[x1][y2] > rel[x1][y1] && rel[y2][x1] > rel[y2][x2]) {
                    noHappy[x1] = noHappy[y2] = true;
                }
                if (rel[y1][x2] > rel[y1][x1] && rel[x2][y1] > rel[x2][y2]) {
                    noHappy[y1]  = noHappy[x2] = true;
                }
                if (rel[y1][y2] > rel[y1][x1] && rel[y2][y1] > rel[y2][x2]) {
                    noHappy[y1] = noHappy[y2] = true;
                }
            }
        }
        int res =  0;
        for (boolean v : noHappy) if (v) res++;
        return res;
    }

}
