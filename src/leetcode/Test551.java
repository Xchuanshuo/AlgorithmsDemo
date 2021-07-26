package leetcode;

/**
 * @author Legend
 * @data by on 21-6-23.
 * @description https://leetcode-cn.com/problems/student-attendance-record-i/
 */
public class Test551 {

    public boolean checkRecord(String s) {
        char[] chs = s.toCharArray();
        int cnt = chs[0] == 'A' ? 1 : 0;
        for (int i = 1;i < chs.length;i++) {
            if (chs[i] == 'A') cnt++;
            else if (i >= 2 && chs[i] == 'L'  && chs[i-1] == 'L' && chs[i-2] == 'L') {
                return false;
            }
            if (cnt > 1) return false;
        }
        return true;
    }
}
