package leetcode;

/**
 * @author Legend
 * @data by on 21-6-17.
 * @description https://leetcode-cn.com/problems/valid-number/
 */
public class Test65 {

    private int idx = 0;
    private boolean isValid = true;
    public boolean isNumber(String s) {
        char[] chs = s.toCharArray();
        if (chs[idx] == '.') {
            matchDotNumE(chs, 1);
            return isValid && idx == chs.length;
        }
        if (chs[idx] == '+' || chs[idx] == '-') idx++;
        matchNum(chs);
        if (idx == chs.length) return true;
        if (idx != 0 && chs[idx] == '.') {
            matchDotNumE(chs, 2);
        } else if (idx != 0 && isNum(chs[idx-1]) && (chs[idx] == 'e' || chs[idx] == 'E')) {
            matchDotNumE(chs, 2);
        }
        return isValid && idx == chs.length;
    }

    private void matchNum(char[] chs) {
        isValid = false;
        while (idx < chs.length) {
            if (!isNum(chs[idx])) break;
            isValid = true;
            idx++;
        }
    }

    private boolean isNum(char c) {
        return c >= '0' && c <= '9';
    }

    private void matchDotNumE(char[] chs, int state) {
        idx++;
        if (idx != 1 && idx == chs.length) return;
        matchNum(chs);
        if (state == 1 && !isValid) return;
        if (idx < chs.length && (chs[idx] == 'e' || chs[idx] == 'E')) {
            idx++;
            if (idx < chs.length && (chs[idx] == '+' || chs[idx] == '-')) idx++;
            matchNum(chs);
        }
    }

}
