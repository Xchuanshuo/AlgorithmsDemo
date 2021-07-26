package leetcode;

/**
 * @author Legend
 * @data by on 21-7-18.
 * @description https://leetcode-cn.com/problems/minimum-deletion-cost-to-avoid-repeating-letters
 * idea:
 *      累计连续重复字符串的总花费, 累计所有重复中最大的值(作为删除保留) 相减即可
 */
public class Test1578 {

    public int minCost(String s, int[] cost) {
        char[] chs = s.toCharArray();
        int last = chs[0], delete = 0;
        int total = 0, t = cost[0];
        int max = cost[0], cnt = 1;
        for (int i = 1;i <= chs.length;i++) {
            if (i == chs.length || chs[i] != last) {
                if (cnt > 1) {
                    delete += max; total += t;
                }
                if (i == chs.length) break;
                cnt = 1; t = cost[i];
                max = cost[i];
            } else {
                t += cost[i];
                max = Math.max(max, cost[i]);
                cnt++;
            }
            last = chs[i];
        }
        return total - delete;
    }
}
