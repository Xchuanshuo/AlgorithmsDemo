package lintcode;

/**
 * @author Legend
 * @data by on 18-12-13.
 * @description maximum-swap
 */
public class Test1095 {

    public int maximumSwap(int num) {
        // Write your code here
        char[] c = String.valueOf(num).toCharArray();
        int n = c.length - 1;
        int l = n, r = n, idx=n;
        for (int i=n-1;i>=0;i--) {
            if (c[i] > c[idx]) {
                idx = i;
            } else {
                r = idx;
                l = i;
            }
        }
        char temp = c[l];
        c[l] = c[r];
        c[r] = temp;
        return Integer.parseInt(String.valueOf(c));
    }
}
