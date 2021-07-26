package leetcode;

/**
 * @author Legend
 * @data by on 21-7-24.
 * @description https://leetcode-cn.com/problems/latest-time-by-replacing-hidden-digits/
 */
public class Test1736 {

    public String maximumTime(String time) {
        char[] chs = time.toCharArray();
        chs[0] = chs[0] != '?' ? chs[0] : (chs[1] < '4' || chs[1] == '?')? '2' : '1';
        chs[1] = chs[1] != '?' ? chs[1] : chs[0] == '2' ? '3' : '9';
        chs[3] = chs[3] != '?' ? chs[3] : '5';
        chs[4] = chs[4] != '?' ? chs[4] : '9';
        return new String(chs);
    }
}
