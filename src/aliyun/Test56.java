package aliyun;

import java.util.Arrays;

/**
 * @author Legend
 * @data by on 21-4-5.
 * @description https://developer.aliyun.com/coding/56
 */
public class Test56 {

    public long solution(long n, long k, int[][] nums) {
        Arrays.sort(nums, (o1, o2) -> o1[0] - o2[0]);
        long res = 0, count = 0;
        for (int[] num : nums) {
            int cur = num[1];
            if (count + cur  >= k) {
                res += (k - count) * num[0];
                break;
            }
            count += cur;
            res += cur * num[0];
        }
        return res;
    }
}
