package leetcode;

import java.util.Arrays;
import java.util.TreeSet;

/**
 * @author Legend
 * @data by on 21-6-26.
 * @description https://leetcode-cn.com/problems/minimum-moves-to-make-array-complementary/
 * idea:
 *      对于每个数对A-B 和有3种情况
 *      1. 当两个都修改时,数对和为 [2,2*limit]
 *      2. 当只修改一个时, 数对和为 [1+min(A,B), limit + max(A,B)]
 *      3. 当一个都不修改时, 和为[A+B,A+B]
 *
 *      所以要将所有的数对和修改为相等, 实际问题为将和修改为这几个区间的和,
 *      看修改为哪个数时总花费最少, 所以可以使用差分数组 来求每个和需要的修改次数
 *      情况1 区间次数+2          情况2 区间次数-1
 *      情况3 区间次数-1
 */
public class Test1674 {

    public int minMoves(int[] nums, int limit) {
        int n = nums.length;
        int[] dif = new int[2*limit + 2];
        for (int i = 0;i < n / 2;i++) {
            int a = nums[i], b = nums[n-i-1];
            int l = 2, r = 2*limit;
            dif[l] += 2; dif[r + 1] -= 2;

            l = 1 + Math.min(a,b); r = limit + Math.max(a, b);
            dif[l] -= 1; dif[r + 1] += 1;

            l = a + b; r = a + b;
            dif[l] -= 1; dif[r + 1] += 1;
        }
        int res = n, sum = 0;
        for (int i = 2;i <= 2*limit;i++) {
            sum += dif[i];
            res = Math.min(res, sum);
        }
        return res;
    }

}
