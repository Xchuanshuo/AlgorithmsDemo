package leetcode;

/**
 * @author Legend
 * @data by on 21-7-11.
 * @description https://leetcode-cn.com/problems/sum-game/
 */
public class Test5794 {

    public boolean sumGame(String num) {
        int lc = 0, rc = 0;
        int sum = 0, n = num.length();
        char[] chs = num.toCharArray();
        for (int i = 0;i < n/2;i++) {
            if (chs[i] == '?') lc++;
            else sum += chs[i] - '0';
        }
        for (int i = n/2;i < n;i++) {
            if (chs[i] == '?') rc++;
            else sum -= chs[i] - '0';
        }
        if ((lc + rc)%2 == 1) return true;
        return sum != (rc-lc)/2 * 9;
    }
}
