package lintcode;

/**
 * @author Legend
 * @data by on 18-10-1.
 * @description rotate-string
 */
public class Test8 {

    public void rotateString(char[] str, int offset) {
        // write your code here

        if (str == null || str.length == 0) {
            return;
        }

        offset = offset%str.length;

        reverse(str, 0, str.length-offset-1);
        reverse(str, str.length-offset, str.length-1);
        reverse(str, 0, str.length-1);
    }

    private void reverse(char[] str, int start, int end) {
        for (int i=start,j=end;i<j;i++,j--) {
            char temp = str[i];
            str[i] = str[j];
            str[j] = temp;
        }
    }
}
