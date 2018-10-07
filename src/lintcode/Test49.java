package lintcode;

/**
 * @author Legend
 * @data by on 18-10-7.
 * @description sort-letters-by-case
 * idea:
 *      使用双指针 扫描一遍即可
 */
public class Test49 {

    public void sortLetters(char[] chars) {
        // write your code here
        if (null == chars || chars.length == 0) return;
        int i=0, j=chars.length-1;
        while (i < j) {
            while (i<j && chars[i]-26>'A') {
                i++;
            }
            while (i<j && chars[j]-26<='A') {
                j--;
            }
            if (i<j) {
                swap(chars, i, j);
            }
        }
    }

    private void swap(char[] chars, int a, int b) {
        char temp = chars[a];
        chars[a] = chars[b];
        chars[b] = temp;
    }
}
