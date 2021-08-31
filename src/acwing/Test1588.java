package acwing;

/**
 * @author Legend
 * @data by on 21-8-29.
 * @description https://leetcode-cn.com/problems/sum-of-all-odd-length-subarrays/
 */
public class Test1588 {

    public int sumOddLengthSubarrays(int[] arr) {
        int n = arr.length, res = 0;
        for (int i = 0;i < n;i++) {
            int l = i + 1, r = n - i;
            int le = (l+1)/2, lo = (r+1)/2;
            int re = l/2, ro = r/2;
            res += (le*ro + lo*re) * arr[i];
        }
        return res;
    }

    public int sumOddLengthSubarrays1(int[] arr) {
        int n = arr.length;
        int[] sum = new int[n+1];
        for (int i = 0;i < n;i++) sum[i+1] = sum[i] + arr[i];
        int res = 0;
        for (int len = 1;len <= n;len+=2) {
            for (int i = 0;i <= n - len;i++) {
                int j = i + len - 1;
                res += sum[j+1] - sum[i];
            }
        }
        return res;
    }
}
