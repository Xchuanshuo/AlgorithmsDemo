package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Legend
 * @data by on 21-5-4.
 * @description https://leetcode-cn.com/problems/subarray-sums-divisible-by-k/
 * idea:
 *      注意处理前缀和为负数的情况 取模结果转换正数应该是 (负数%K + K)%K
 */
public class Test974 {

    public int subarraysDivByK(int[] A, int K) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0, res = 0;
        for (int i = 0;i < A.length;i++) {
            sum +=  A[i];
            int mod = (sum % K + K) % K;
            if (map.containsKey(mod)) {
                res += map.get(mod);
            }
            map.put(mod, map.getOrDefault(mod, 0) + 1);
        }
        return res;
    }
}
