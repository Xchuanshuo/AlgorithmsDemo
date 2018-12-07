package lintcode;

/**
 * @author Legend
 * @data by on 18-12-5.
 * @description range-sum-query-mutable
 * idea:
 *      Binary Indexed Tree
 */
public class Test840 {

    class NumArray {

        private int[] bit, arr;
        private int n;

        public NumArray(int[] nums) {
            this.n = nums.length;
            this.arr = new int[n];
            this.bit = new int[n+1];

            for (int i=0;i<n;i++) {
                update(i, nums[i]);
            }
        }

        public void update(int i, int val) {
            int delta = val - arr[i];
            arr[i] = val;
            for (int k=i+1;k<=n;k += lowbit(k)) {
                bit[k] += delta;
            }
        }

        public int sumRange(int i, int j) {
            return prefixSum(j) - prefixSum(i-1);
        }

        private int prefixSum(int i) {
            int sum = 0;
            for (int k=i+1;k>0;k -= lowbit(k)) {
                sum += bit[k];
            }
            return sum;
        }

        public int lowbit(int x) {
            return x & (-x);
        }
    }
}
