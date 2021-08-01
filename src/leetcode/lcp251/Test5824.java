package leetcode.lcp251;

/**
 * @author Legend
 * @data by on 21-7-25.
 * @description https://leetcode-cn.com/contest/weekly-contest-251/problems/largest-number-after-mutating-substring/
 */
public class Test5824 {

    public String maximumNumber(String num, int[] change) {
        char[] chs = num.toCharArray();
        boolean start = false;
        for (int i = 0;i < chs.length;i++) {
            int cur = chs[i] - '0';
            if ((start && change[cur] >= cur) || change[cur] > cur) {
                chs[i] = (char) (change[cur] + '0');
                start = true;
            } else if (start) {
                break;
            }
        }
        return new String(chs);
    }
}
