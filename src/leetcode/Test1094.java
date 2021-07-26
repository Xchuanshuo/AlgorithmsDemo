package leetcode;

/**
 * @author Legend
 * @data by on 21-6-26.
 * @description https://leetcode-cn.com/problems/car-pooling/
 * idea:
 *      差分数组, 注意右边界
 */
public class Test1094 {

    public boolean carPooling(int[][] trips, int capacity) {
        int n = trips.length;
        int maxL = 0;
        for (int[] trip : trips)  maxL = Math.max(maxL, trip[2]);
        int[] dif = new int[maxL+ 1];
        for (int i = 0;i < n;i++) {
            dif[trips[i][1]] += trips[i][0];
            dif[trips[i][2]] -= trips[i][0];
        }
        for (int i = 1;i <= maxL;i++) {
            dif[i] += dif[i-1];
            if (dif[i] > capacity) return false;
        }
        return true;
    }
}
