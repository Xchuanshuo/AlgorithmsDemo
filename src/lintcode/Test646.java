package lintcode;

/**
 * @author Legend
 * @data by on 18-10-9.
 * @description first-position-unique-character
 */
public class Test646 {

    public int firstUniqChar(String s) {
        // write your code here
        char[] chars = new char[128];
        for (char c: s.toCharArray()) {
            chars[c]++;
        }
        for (int i=0;i<s.length();i++) {
            if (chars[s.charAt(i)] == 1) {
                return i;
            }
        }
        return -1;
    }
}
