package leetcode;

/**
 * @author Legend
 * @data by on 21-4-21.
 * @description https://leetcode-cn.com/problems/find-pivot-index/
 */
public class Test724 {

    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int[] preSum = new int[n + 1];
        int sum = 0;
        for (int i = 0;i < nums.length;i++) {
            preSum[i+1] = preSum[i] + nums[i];
        }
        for (int i = 0;i < nums.length;i++) {
            int l = preSum[i], r = preSum[n] - preSum[i + 1];
            if (l == r) return i;
        }
        return -1;
    }
}
