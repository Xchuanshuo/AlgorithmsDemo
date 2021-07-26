package leetcode;

/**
 * @author Legend
 * @data by on 21-6-18.
 * @description https://leetcode-cn.com/problems/smallest-good-base/
 */
public class Test483 {

    public String smallestGoodBase(String target) {
        long n = Long.parseLong(target);
        for (int s = 2;s <= 59;s++) {
            long k = (long)Math.pow(n, 1.0 / s);
            if (k == 1) continue;
            long sum = 1, base = 1;
            for (int i = 1;i <= s;i++) {
                base *= k;
                sum += base;
            }
            if (sum == n) return String.valueOf(k);
        }
        return String.valueOf(n - 1);
    }
}
