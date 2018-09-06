package lintcode;

/**
 * @author Legend
 * @data by on 18-9-6.
 * @description calculate-maximum-value
 * idea:
 *      贪心算法
 */
public class Test719 {

    public int calcMaxValue(String str) {
        // write your code here
        int result = 0;
        for (char c: str.toCharArray()) {
            int cur = c-'0';
            result = Math.max(cur*result, cur+result);
        }
        return result;
    }
}
