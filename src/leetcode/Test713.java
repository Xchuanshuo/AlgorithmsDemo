package leetcode;

/**
 * @author Legend
 * @data by on 21-4-24.
 * @description https://leetcode-cn.com/problems/subarray-product-less-than-k/
 * idea:
 *      求乘积小于k的子数组 如果子数组小于k, 那么该子数组内的任意子数组都小于k
 *      所以只需要维护一个窗口, 使得窗口内的乘积小于k 以窗口 1,2,3 k = 7为例
 *      包含的以右端点开头的子数组 有 [3,2,1] [3,2] [3] 刚好为窗口的大小
 *      而以 2,1开头的 在前面已经算过了 无需重复计算 只需要每次累加[当前右端点开始的子数组即可]
 */
public class Test713 {

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int res = 0;
        int l = 0, mul = 1;
        for (int i = 0;i < nums.length;i++) {
            mul *= nums[i];
            while (mul >= k && l < nums.length) {
                mul /= nums[l++];
            }
            res += i - l + 1;
        }
        return Math.max(res, 0);
    }
}
