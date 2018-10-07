package lintcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Legend
 * @data by on 18-6-12.
 * @description
 */
public class Test139 {
    public int[] subarraySumClosest(int[] nums) {
        int[] result = new int[2];
        int len = nums.length;
        Helper[] helpers = new Helper[len];
        int sum = 0;
        for (int i=0;i < len;i++) {
            sum += nums[i];
            helpers[i] = new Helper(i, sum);
        }
        Arrays.sort(helpers, Comparator.comparingInt(o -> o.sum));
        return result;
    }

    class Helper {
        int index;
        int sum;
        public Helper(int index, int sum) {
            this.index = index;
            this.sum = sum;
        }
    }
}
