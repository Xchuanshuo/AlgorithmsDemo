package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Legend
 * @data by on 21-4-19.
 * @description https://leetcode-cn.com/problems/numbers-at-most-n-given-digit-set/
 * idea:
 *      数位dp dp[i]表示对于数字前i位(从低位到高位)的数字组合个数
 *      对于n位的数字, 前n-1位是可以使用digits中的数任意组合的, 组合个数为lenD^(n-1)
 *      以 digits={1,2,3,4} n = 2345 为例 n总共有4位            2 3 4 5
 *                                                        位: 4 3 2 1
 *    ------------------------------------------------------------------------------
 *      总方案数包括两部分 1.当前位i不动 前i-1位任意取 2.当前位改变(digits的数 小于 或 等于当前位两种情况)
 *
 *      先看第1位, digits中有4个数小于5的, 则前1位有[4]种方案
 *      再看第2位, digits中有3个小于4的, 取这三个数后 则前1位可以任意取 方案数为 [3*4^1=12]
 *               digits中有1数个等于4, 取这1个数后, 则方案数实际为2 dp[1]得到方案数 两种情况累加即可
 *      接下来看第3位, 有2个数小于3, 当前位取这两个数后, 前2位可以任意组合 即 [2*4^2=32]
 *                   有1个数等于3, 当前位取3后, 方案数为dp[2] 两种情况累加
 *      最后看第4位, 有1个数小于2, 则当前位取这一个数后, 方案为 [1*4^3=64]
 *                 有1个数等于2, 则当前位取2后, 方案为dp[3] 两种情况累加
 *      则dp[1] = 4, dp[2]=12 + 4 = 16, dp[3]= 32 + 16 = 48
 *      前4位方案数为 dp[4] = dp[3] + 64 = 112
 *      还需要考虑[当前位不动] 前n-1位任意取的情况  4^1 + 4^2 + 4^3 = 84
 *      则方案总数为 dp[4] + 84 = 196
 */
public class Test902 {

    public int atMostNGivenDigitSet(String[] digits, int n) {
        List<Integer> list  = new ArrayList<>();
        int f = n;
        while (f != 0) {
            list.add(f%10); f/=10;
        }
        int len = list.size(), lenD = digits.length;
        int[] dp = new int[len + 1];
        dp[0] = 1;
        for (int i = 1;i <= len;i++) {
            int cur = list.get(i - 1);
            for (String digit : digits) {
                int t = Integer.parseInt(digit);
                if (t < cur) {
                    dp[i] += (int)Math.pow(lenD, i - 1);
                } else if (t == cur) {
                    dp[i] += dp[i - 1];
                }
            }
        }
        for (int i = 1;i < len;i++) {
            dp[len] += (int) Math.pow(lenD, i);
        }
        return dp[len];
    }
}
