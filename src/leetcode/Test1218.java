package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Legend
 * @data by on 21-5-18.
 * @description https://leetcode-cn.com/problems/longest-arithmetic-subsequence-of-given-difference/
 */
public class Test1218 {

    public int longestSubsequence(int[] arr, int d) {
        int n = arr.length;
        Map<Integer, Integer> dp = new HashMap<>();
        int max = 0;
        for (int i = 0;i < n;i++) {
            int val = dp.getOrDefault(arr[i]-d, 0) + 1;
            dp.put(arr[i], val);
            max = Math.max(max, dp.get(arr[i]));
        }
        return max;
    }

}
