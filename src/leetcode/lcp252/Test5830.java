package leetcode.lcp252;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Legend
 * @data by on 21-8-1.
 * @description
 */
public class Test5830 {

    public boolean isThree(int n) {
        Set<Integer> set = new HashSet<>();
        for (int i = 1;i <= Math.sqrt(n);i++) {
            if (n % i == 0) set.add(i); set.add(n/i);
            if (set.size() > 3) return false;
        }
        return set.size() == 3;
    }
}
