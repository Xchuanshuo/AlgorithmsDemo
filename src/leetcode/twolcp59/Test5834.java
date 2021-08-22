package leetcode.twolcp59;

/**
 * @author Legend
 * @data by on 21-8-21.
 * @description https://leetcode-cn.com/contest/biweekly-contest-59/problems/minimum-time-to-type-word-using-special-typewriter/
 */
public class Test5834 {

    public int minTimeToType(String word) {
        char[] chs = word.toCharArray();
        int res = 0, last = 'a';
        for (int i = 0;i < chs.length;i++) {
            int cur = Math.min(Math.abs(chs[i]-last), 26-Math.abs(chs[i]-last)) + 1;
            res += cur;
            last = chs[i];
        }
        return res;
    }
}
