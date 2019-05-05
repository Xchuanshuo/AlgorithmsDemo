package lintcode;

import java.util.Arrays;

/**
 * @author Legend
 * @data by on 19-5-5.
 * @description arithmetic-slices
 * idea:
 *      dp 用dp[i]表示以A[i]结尾的最长的等差数列长度 只要不满足等差数列的条件就将该位置的长度设为2
 *      也就是相邻两个数  统计 每个位置的长度后再计算每个长度新增的切片数量求和 就可得出最后结果
 *      而每个长度新增的切片数量实际就是l-2 表示从第1个数开始一直到 倒数第三个 都是新增的切片数量
 */
public class Test982 {

    public int numberOfArithmeticSlices(int[] A) {
        if (A==null || A.length<3) return 0;
        int[] dp = new int[A.length];
        Arrays.fill(dp, 2);
        for (int i = 2;i < A.length;i++) {
            if (A[i]-A[i-1] == A[i-1] - A[i-2]) {
                dp[i] = dp[i-1] + 1;
            }
        }
        int result = 0;
        for (int l : dp) {
            if (l > 2) result += l - 2;
        }
        return result;
    }
}
