package lintcode;

/**
 * @author Legend
 * @data by on 19-4-22.
 * @description least-substring
 */
public class Test1638 {

    public int getAns(String s, int k) {
        if (s == null || s.length() == 0) return 0;
        int count = 1, cur = 1;
        for (int i = 0;i < s.length()-1;i++) {
            if (s.charAt(i) == s.charAt(i+1) && cur < k) {
                cur++;
                continue;
            }
            cur = 1;
            count++;
        }
        return count;
    }
}
