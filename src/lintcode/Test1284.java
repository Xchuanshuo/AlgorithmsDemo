package lintcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Legend
 * @data by on 18-9-11.
 * @description integer-break
 * idea:
 *      这道题方法很多 这里使用递归+记忆化搜索来做 和使用dp道理是一样的，每遍历到一个数时
 *      计算当前的数与当前的数拆分后结果的乘积最大值 最后用map来保存n经拆分后求出的最大值
 */
public class Test1284 {

    private Map<Integer, Integer> map = new HashMap<>();
    public int integerBreak(int n) {
        // Write your code here
        if (map.containsKey(n)) {
            return map.get(n);
        }
        int max = 0;
        for (int i=1;i<=n/2;i++) {
            int left = Math.max(i, integerBreak(i));
            int right = Math.max(n-i, integerBreak(n-i));
            max = Math.max(max, left*right);
        }
        map.put(n, max);
        return max;
    }
}
