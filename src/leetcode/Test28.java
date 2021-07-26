package leetcode;

/**
 * @author Legend
 * @data by on 21-4-20.
 * @description https://leetcode-cn.com/problems/implement-strstr/
 * idea:
 *      kmp模板题
 */
public class Test28 {

    public int strStr(String haystack, String needle) {
        char[] chars = haystack.toCharArray();
        char[] pattern = needle.toCharArray();
        if (pattern.length == 0) return 0;
        int[] next = getNext(pattern);
        int j = 0;
        for (int i = 0;i < chars.length;i++) {
            while (j > 0 && pattern[j] != chars[i]) {
                j = next[j - 1] + 1;
            }
            if (pattern[j] == chars[i]) j++;
            if (j == needle.length()) {
                return i - j + 1;
            }
        }
        return -1;
    }

    private int[] getNext(char[] pattern) {
        int n = pattern.length;
        int[] next = new int[n];
        int k = -1;
        next[0] = -1;
        for (int i = 1;i < n;i++) {
            while (k != -1 && pattern[k+1] != pattern[i]) {
                k = next[k];
            }
            if (pattern[k+1] == pattern[i]) k++;
            next[i] = k;
        }
        return next;
    }
}
