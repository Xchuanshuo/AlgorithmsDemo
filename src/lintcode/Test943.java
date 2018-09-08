package lintcode;

/**
 * @author Legend
 * @data by on 18-9-8.
 * @description range-sum-query-immutable
 * idea:
 *      前缀和
 */
public class Test943 {

    class NumArray {

        private int[] prefixSum;
        public NumArray(int[] nums) {
            prefixSum = new int[nums.length+1];
            for (int i=1;i<=nums.length;i++) {
                prefixSum[i] = prefixSum[i-1] + nums[i-1];
            }
        }

        public int sumRange(int i, int j) {
            return prefixSum[j+1] - prefixSum[i];
        }
    }
}
