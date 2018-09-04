package lintcode;

/**
 * @author Legend
 * @data by on 18-9-1.
 * @description minimum-number-of-keystrokes
 * idea:
 *      dp 用两个表 分别表示大写和小写需要的次数
 */
public class Test1586 {

    public int getAns(String s) {
        // Write your code here
        int n = s.length();
        int[] lower = new int[n+1];
        int[] upper = new int[n+1];
        upper[0] = 1;
        for (int i=0, j=1;i<n;i++, j++) {
            if (Character.isUpperCase(s.charAt(i))) {
                upper[j] = Math.min(upper[j-1]+1, lower[j-1]+2);
                lower[j] = Math.min(lower[j-1]+2, upper[j-1]+3);
            } else {
                lower[j] = Math.min(lower[j-1]+1, upper[j-1]+2);
                upper[j] = Math.min(upper[j-1]+2, lower[j-1]+3);
            }
        }
        return Math.min(lower[n], upper[n]);
    }
}
