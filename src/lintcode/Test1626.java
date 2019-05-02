package lintcode;

/**
 * @author Legend
 * @data by on 19-5-2.
 * @description salary-adjustment
 */
public class Test1626 {

    public int getCap(int[] a, int target) {
        if (a == null || a.length == 0) return 0;
        int l = 0, r = 10000;
        while (l + 1 < r) {
            int mid = l + (r-l) / 2;
            if (getSum(a, mid) > target) {
                r = mid;
            } else {
                l = mid;
            }
        }
        if (getSum(a, l) < target) return r;
        return l;
    }

    private int getSum(int[] a, int cap) {
        int sum = 0;
        for (int i = 0;i < a.length;i++) {
            sum += a[i] < cap ? cap : a[i];
        }
        return sum;
    }

}
