package leetcode;

/**
 * @author Legend
 * @data by on 21-4-28.
 * @description https://leetcode-cn.com/problems/sum-of-square-numbers/
 */
public class Test633 {

    public boolean judgeSquareSum(int c) {
        int l = 0, r = (int)Math.sqrt(c);
        while (l <= r) {
            int v = l*l + r*r;
            if (v == c) return true;
            if (v > c) {
                r--;
            } else {
                l++;
            }
        }
        return false;
    }
}
