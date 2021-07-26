package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Legend
 * @data by on 21-4-18.
 * @description https://leetcode-cn.com/problems/number-of-digit-one/submissions/
 * idea:
 *      数位dp模板题 dp[i]表示数字n前i位的1的个数(从低位到高位)
 *      用f(n)表示0..n内1的个数 分情况讨论
 *      对于数字 233 第3位变成(0..1),1、2位可取(00..99) 则1的个数为 2*f(99)
 *                  第3位取2, 则2、3位可取(00..33) 则1的个数为 f(33)
 *                  第3位取1, 则1的个数为f(99) 所以总数为 2*f(99) + f(33) + f(99) + dp[2]
 *
 *      对于数字 133 第3位变成0 1、2位可取(00..99) 则1的个数为 1*f(99)
 *                  第3位取1 1、2位可取(00..33) 则1的个数为 34
 *                  此时无需考虑上述第三种情况 所以总数为 1*f(99) + 34 + dp[2]
 */
public class Test233 {

    public int countDigitOne(int n) {
        if (n < 1) return 0;
        int f =n;
        List<Integer> list = new ArrayList<>();
        while (f != 0) {
            list.add(f%10); f /= 10;
        }
        int len = list.size();
        int[] dp = new int[len+1];
        dp[1] = n%10 >= 1 ? 1 : 0;
        int last = 1;
        for (int i = 2;i <= len;i++) {
            int cur = list.get(i-1);
            dp[i] = last * cur + dp[i-1];
            if (cur > 1) {
                dp[i] += (int)Math.pow(10, i-1);
            } else if (cur == 1) {
                dp[i] += n%((int)Math.pow(10, i-1)) + 1;
            }
            last = 10 * last + (int)Math.pow(10, i-1);
        }
        return dp[len];
    }
}
