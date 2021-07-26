package leetcode;

import java.util.*;
import java.util.concurrent.locks.LockSupport;

/**
 * @author Legend
 * @data by on 21-4-19.
 * @description https://leetcode-cn.com/problems/numbers-with-repeated-digits/submissions/
 * idea:
 *      组合 求至少重复1次的数 -> N - 求不重复的数
 *      为了处理边界情况 直接将n+1 不影响最终结果
 *
 *      对于一个3位数 874, 分情况讨论
 *      1.当位数小于3时,即00-99范围的数 前2位 不重复情况有第1位取(1-9),第2位取(0-9去掉第1位) 即9*9
 *                                  前1位 可以取9个
 *      2.当位数等于3时 第1位取(1-7), 后面两位可取 7 * A(9,2);
 *                    第1位取8,第二位取(0-6),后1位可取 7 * A(8,1)
 *                    第1位取8,第二位取7,第三位可取0-4, 5*A(6,0)
 *      累计所有结果 不重复总数为 81 + 9 + 7 * 72 + 8 + 5 = 655 则结果为 874 - 655 = 219
 *
 *      特殊情况: 如881, 当遇到第2个8时 说明后面的数都重复了 直接结束
 *               如781, 第1个数为7，那么第二个数就不能为7, 否则出现重复
 */
public class Test1012 {

    public int numDupDigitsAtMostN(int N) {
        List<Integer> list = new ArrayList<>();
        int f = N + 1;
        while (f != 0) {
            list.add(f%10);  f /= 10;
        }
        Collections.reverse(list);
        int cnt = 0;
        int len = list.size();
        // 小于n位时
        for (int i = 1;i  < len;i++) {
            cnt += 9 * A(9, i - 1);
        }
        boolean[] visited = new boolean[10];
        // 等于n位时
        for (int i = 0;i < len;i++) {
            int cur = list.get(i);
            for (int j = i > 0 ? 0 : 1;j < cur;++j) {
                if (visited[j]) continue;
                cnt += A(9 - i, len - i - 1);
            }
            if (visited[cur]) break;
            visited[cur] = true;
        }
        return N - cnt;
    }

    private int A(int m, int n) {
        int res = 1;
        for (int i = 0;i < n;i++) res *= m - i;
        return res;
    }
}
