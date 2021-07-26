package leetcode;

/**
 * @author Legend
 * @data by on 21-5-28.
 * @description https://leetcode-cn.com/problems/total-hamming-distance/submissions/
 */
public class Test477 {

    public int totalHammingDistance(int[] nums) {
        int res = 0;
        for (int i = 31;i >= 0;i--) {
            int zero = 0;
            for (int n : nums) {
                int val = (1<<i)&n;
                if (val == 0) zero++;
            }
            res += (nums.length - zero)*zero;
        }
        return res;
    }
}
