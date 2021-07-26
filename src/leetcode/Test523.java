package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Legend
 * @data by on 21-5-4.
 * @description https://leetcode-cn.com/problems/continuous-subarray-sum/
 * idea:
 *      (sum[j] - sum[i])%k=0 ==> sum[j]%k == sum[i]%k
 */
public class Test523 {

    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        map.put(sum, -1);
        for (int i = 0;i < nums.length;i++) {
            sum += nums[i];
            int mod = sum%k;
            if (i > 0 && nums[i-1] == 0 && nums[i] == 0) {
                return true;
            }
            if (!map.containsKey(mod)) {
                map.put(mod, i);
            } else if (i - map.get(mod) >= 2) {
                return true;
            }
        }
        return false;
    }
}
