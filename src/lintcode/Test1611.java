package lintcode;

/**
 * @author Legend
 * @data by on 19-4-20.
 * @description shortest-subarray
 */
public class Test1611 {

    public int smallestLength(int[] nums, int k) {
        // Write your code here
        if (nums == null || nums.length == 0) return -1;
        int sum = 0, j = 0, res = Integer.MAX_VALUE;
        for (int i = 0;i < nums.length;i++) {
            if (nums[i] >= k) return 1;
            sum += nums[i];
            while (sum >= k && j < i) {
                res = Math.min(res, i - j + 1);
                sum -= nums[j++];
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}
