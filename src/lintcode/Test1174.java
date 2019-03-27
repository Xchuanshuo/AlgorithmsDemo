package lintcode;

import java.util.Arrays;

/**
 * @author Legend
 * @data by on 19-3-27.
 * @description next-greater-element-iii
 * idea:
 *      和下一个排列基本差不多(Test52) 唯一注意的是数值不能超出Integer.MAX_VALUE
 */
public class Test1174 {

    public int nextGreaterElement(int n) {
        // Write your code here
        char[] chars = String.valueOf(n).toCharArray();
        int len = chars.length, pos = len - 2;
        while (pos >= 0 && chars[pos] >= chars[pos+1]) {
            pos--;
        }
        if (pos < 0) return -1;
        int i = len - 1;
        while (i>0 && chars[i] <= chars[pos]) i--;
        swap(chars, i, pos);
        Arrays.sort(chars, pos+1, len);
        long res = Long.valueOf(String.valueOf(chars));
        if (res > Integer.MAX_VALUE) {
            return -1;
        }
        return (int)res;
    }

    private void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
}
