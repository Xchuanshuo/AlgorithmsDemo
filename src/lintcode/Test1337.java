package lintcode;

/**
 * @author Legend
 * @data by on 19-11-4.
 * @description maximum-possible-value
 */
public class Test1337 {

    public int MaximumPossibleValue(int N) {
        // write your code here
        String str = String.valueOf(N);
        boolean isNegative = N < 0;
        str = str.replace("-","");
        int index = str.length();
        for (int i = 0;i < str.length(); i++) {
            char c = str.charAt(i);
            if (isNegative) {
                if (c - '0' > 5) {
                    index = i;
                    break;
                }
            } else {
                if (c - '0' < 5) index = i;
            }
        }
        String val = str.substring(0, index) + "5" + str.substring(index);
        return Integer.valueOf(isNegative ? "-" + val : val);
    }
}
