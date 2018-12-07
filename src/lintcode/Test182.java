package lintcode;

/**
 * @author Legend
 * @data by on 18-12-5.
 * @description delete-digits
 * idea:
 *      greedy 注意可能存在前几位为0的情况
 */
public class Test182 {

    public String DeleteDigits(String A, int k) {
        StringBuilder builder = new StringBuilder(A);
        for (int i=0;i<k;i++) {
            int j = 0;
            while (j<builder.length()-1 &&
                    builder.charAt(j)<=builder.charAt(j+1)) {
                j++;
            }
            builder.delete(j, j+1);
        }
        while (builder.length()>1 && builder.charAt(0) == '0') {
            builder.deleteCharAt(0);
        }
        return builder.toString();
    }
}
