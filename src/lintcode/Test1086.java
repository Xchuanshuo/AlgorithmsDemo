package lintcode;

/**
 * @author Legend
 * @data by on 19-5-10.
 * @description repeating-string-match
 */
public class Test1086 {

    public int repeatedStringMatch(String A, String B) {
        if (A == null || A.length() == 0) return -1;
        int count = 1;
        StringBuilder builder = new StringBuilder(A);
        while (builder.length() < B.length()) {
            count++;
            builder.append(A);
        }
        if (builder.indexOf(B) != -1) return count;
        if (builder.append(A).indexOf(B) != -1) return count+1;
        return -1;
    }
}
