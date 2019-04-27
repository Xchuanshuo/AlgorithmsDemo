package lintcode;

/**
 * @author Legend
 * @data by on 19-4-26.
 * @description interesting-string
 */
public class Test1630 {

    public String check(String s) {
        if (s == null || s.length()==0) return "no";
        return dfs(0, s) ? "yes" : "no";
    }

    private boolean dfs(int start, String s) {
        if (start == s.length()) return true;
        int len = 0;
        for (int i = start;i < s.length();i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                len = len * 10 + c - 48;
                if (dfs(i + len + 1, s)) return true;
            } else {
                break;
            }
        }
        return false;
    }

}
