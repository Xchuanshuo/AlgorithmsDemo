package leetcode;


/**
 * @author Legend
 * @data by on 21-4-16.
 * @description https://leetcode-cn.com/problems/maximum-product-subarray/
 * idea:
 *      负数可能出现偶数个或奇数个,偶数个则最大乘积为全部数相乘
 *                             奇数个则一定会有偶数个存在连续的一边
 *      所以前后各遍历一遍 遇到0重新开始计算
 */
public class Test152 {

    public int maxProduct(int[] nums) {
        if (nums.length == 0) return 0;
        int max = nums[0], cur = 1;
        for (int i = 0;i < nums.length;i++) {
            cur *= nums[i];
            max = Math.max(max, cur);
            if (nums[i] == 0) cur = 1;
        }
        cur = 1;
        for (int i = nums.length - 1;i >= 0;i--) {
            cur *= nums[i];
            max = Math.max(max, cur);
            if (nums[i] == 0) cur = 1;
        }
        return max;
    }
}
