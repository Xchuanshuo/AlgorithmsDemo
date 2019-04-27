package lintcode;

import java.util.Arrays;

/**
 * @author Legend
 * @data by on 19-4-26.
 * @description minimal-distance-in-the-array
 */
public class Test1623 {

    public int[] minimalDistance(int[] a, int[] b) {
        int[] result = new int[b.length];
        Arrays.sort(a);
        for (int i = 0;i < b.length;i++) {
            boolean flag = false;
            int l = 0, r = a.length - 1;
            while (l+1 < r) {
                int mid = l + (r-l) / 2;
                if (a[mid] == b[i]) {
                    flag = true;
                    result[i] = a[mid];
                    break;
                } else if (a[mid] > b[i]){
                    r = mid;
                } else {
                    l = mid;
                }
            }
            if (!flag) {
                if (Math.abs(a[l] - b[i]) == Math.abs(a[r] - b[i])) {
                    result[i] = Math.min(a[l], a[r]);
                } else if (Math.abs(a[l] - b[i]) < Math.abs(a[r] - b[i])) {
                    result[i] = a[l];
                } else {
                    result[i] = a[r];
                }
            }
        }
        return result;
    }
}
