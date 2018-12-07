package lintcode;

import java.util.Arrays;

/**
 * @author Legend
 * @data by on 18-12-7.
 * @description monotone-increasing-digits
 */
public class Test743 {

    public int monotoneDigits(int num) {
        // write your code here
        char[] chars = String.valueOf(num).toCharArray();
        if (chars.length == 1) return num;
        int point = -1;
        for (int i=chars.length-1;i>0;i--) {
            if (chars[i] < chars[i-1]) {
                chars[i-1]--;
                point = i;
            }
        }
        if (point != -1) {
            Arrays.fill(chars, point, chars.length, '9');
        }
        return Integer.parseInt(String.valueOf(chars));
    }
}
