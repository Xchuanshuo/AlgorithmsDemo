package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Legend
 * @data by on 21-7-26.
 * @description https://leetcode-cn.com/problems/minimum-operations-to-make-a-subsequence/
 * idea:
 *      将arr中的数按照target中的位置重新编号, 对于编号的数组求最长上升子序列
 */
public class Ttest1713 {

    public int minOperations(int[] target, int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        int INF = (int)1e9;
        for (int i = 0;i < target.length;i++) map.put(target[i], i);
        int[] w = new int[arr.length];
        for (int i = 0;i <  arr.length;i++) {
            w[i] = map.getOrDefault(arr[i], INF);
        }
        int n = w.length;
        int[] dp = new int[n];
        dp[0] = w[0]; int len = 1;
        boolean flag = w[0] != INF;
        for (int i = 1;i < n;i++) {
            if (w[i] == INF) continue;
            flag = true;
            if (w[i] > dp[len-1]) {
                dp[len] = w[i]; len++;
            } else {
                int pos = findRight(dp, len - 1, w[i]);
                dp[pos] = w[i];
            }
        }
        if (!flag) return target.length;
        return target.length - len;
    }

    private int findRight(int[] arr, int end, int t) {
        int l = 0, r = end;
        while (l <= r) {
            int mid = l + (r-l)/2;
            if (arr[mid] < t) {
                l = mid + 1;
            } else {
                if (mid == l || arr[mid-1] < t) return mid;
                r = mid - 1;
            }
        }
        return end;
    }
}
