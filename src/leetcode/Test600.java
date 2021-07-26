package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Legend
 * @data by on 21-3-28.
 * @description 600. 不含连续1的非负整数
 * idea:
 *      数位dp 要满足小于num 且不含连续的1的总数量
 *      n为数的位数 找规律: n=1  0 1
 *                       n=2  00 01 10
 *                       n=3  100 101 000 001 010
 *      对于一个n位的数 一定是n-1位数前面加上1或0 加1可能不满足条件 所以全部+0
 *      但可能遗漏满足条件的情况, 所以在n-2位数前+10  刚好满足斐波拉契数列 即dp[n] = dp[n-1] + dp[n-2]
 *
 *      现在得到了每个不同位数为不含连续1的总数量 然后将给定的数转化为二进制
 *      例: 如一个数10101 先将第1位置0 考虑后面4位 0000-1111 res += dp[4]
 *          继续往后考虑 为0直接跳过 继续考察 将第3位置0 考虑后两位00-11
 *          如果存在连续两个1 直接返回结果, 不存在最后的结果加上这个数本身算1个 即+1
 */
public class Test600 {

    public int findIntegers(int num) {
        int[] dp = new int[32];
        dp[0] = 1;
        dp[1] = 2;
        for (int i =  2;i < 32;i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        int res = 0;
        List<Integer> list = new ArrayList<>();
        while (num != 0) {
            list.add(num%2);
            num /= 2;
        }
        Collections.reverse(list);
        int len = list.size();
        for (int i = 0;i < len;i++) {
            if (list.get(i) == 0) continue;
            res += dp[len - i - 1];
            if (i>=1 && list.get(i-1) == 1) {
                return res;
            }
        }
        return res + 1;
    }
}
