package leetcode;

/**
 * @author Legend
 * @data by on 21-7-7.
 * @description https://leetcode-cn.com/problems/minimum-number-of-increments-on-subarrays-to-form-a-target-array/
 */
public class Test1526 {

    public int minNumberOperations(int[] target) {
        int res = target[0];
        for (int i = 1;i <  target.length;i++) {
            res += Math.max(target[i] - target[i-1], 0);
        }
        return res;
    }
}
