package lintcode;

/**
 * @author Legend
 * @data by on 18-9-12.
 * @description number-of-matching-subsequences
 * idea:
 *      只需要统计每个word的匹配的次数看是否与word的长度相等
 */
public class Test1024 {

    public int numMatchingSubseq(String S, String[] words) {
        // Write your code here
        int count = 0;
        for (String word: words) {
            if (isMatch(S, word)) count++;
        }
        return count;
    }

    private boolean isMatch(String S, String word) {
        int p1 = 0, p2 = 0;
        while (p1<S.length() && p2<word.length()) {
            if (S.charAt(p1++) == word.charAt(p2)){
                p2++;
            }
        }
        return p2 == word.length();
    }
}
