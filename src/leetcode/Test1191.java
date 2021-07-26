package leetcode;

/**
 * @author Legend
 * @data by on 21-4-21.
 * @description https://leetcode-cn.com/problems/k-concatenation-maximum-sum/
 * idea:
 *      https://leetcode-cn.com/problems/k-concatenation-maximum-sum/solution/dong-tai-gui-hua-by-jason-2-36mr/
 */
public class Test1191 {

    public int kConcatenationMaxSum(int[] arr, int k) {
        int n = arr.length;
        if (n == 0) return 0;
        int M = 1000000007;
        int cur = arr[0], sum = arr[0];
        int max = Math.max(0, cur);
        for (int i = 1;i < Math.min(k, 2) * n;i++) {
            cur = Math.max(cur + arr[i%n], arr[i%n]);
            max = Math.max(max, cur);
            if (i < n) sum += arr[i];
        }
        while (sum > 0 && --k >= 2) {
            max = (max + sum) %M;
        }
        return (int)max%M;
    }
}
