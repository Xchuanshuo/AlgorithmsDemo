package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Legend
 * @data by on 21-7-17.
 * @description https://leetcode-cn.com/problems/number-of-good-ways-to-split-a-string/
 */
public class Test1525 {

    public int numSplits(String s) {
        char[] chs = s.toCharArray();
        int n = chs.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Set<Character> set = new HashSet<>();
        for (int i = 0;i < n;i++) {
            set.add(chs[i]);
            left[i] = set.size();
        }
        set.clear();
        int res = 0;
        for (int i = n - 1;i >= 0;i--) {
            set.add(chs[i]);
            right[i] = set.size();
            if (i >=1 && left[i-1] == right[i]) res++;
        }
        return res;
    }
}
