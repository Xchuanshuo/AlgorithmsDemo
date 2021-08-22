package leetcode;

/**
 * @author Legend
 * @data by on 21-8-22.
 * @description https://leetcode-cn.com/problems/corporate-flight-bookings/
 */
public class Test1109 {

    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] dif = new int[n];
        for (int i = 0;i <  bookings.length;i++) {
            int l = bookings[i][0]-1, r = bookings[i][1]-1, v = bookings[i][2];
            dif[l] += v;
            if (r + 1 < n) {
                dif[r+1] -= v;
            }
        }
        int[] result = new int[dif.length];
        result[0] = dif[0];
        for (int i = 1;i < dif.length;i++) {
            result[i] = result[i-1] + dif[i];
        }
        return result;
    }

    private void change(int i, int j, int val, int[] dif) {
        dif[i] += val;
        if (j + 1 < dif.length) {
            dif[j+1] -= val;
        }
    }

    private int[] getRes(int[] dif) {
        int[] result = new int[dif.length];
        result[0] = dif[0];
        for (int i = 1;i < dif.length;i++) {
            result[i] = result[i-1] + dif[i];
        }
        return result;
    }
}
