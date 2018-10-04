package lintcode;

/**
 * @author Legend
 * @data by on 18-10-4.
 * @description shortest-phrase
 * idea:
 *      在满足k和lim的条件下 可以转化为求数组的前缀和
 */
public class Test1474 {

    public int getLength(int k, int lim, String[] str) {
        // Write your code here
        int n = str.length;
        int end=0, sum=0, result=Integer.MAX_VALUE;
        for (int start=0;start<n;start++) {
            while (end<n && (end-start<k || sum<lim)) {
                sum += str[end++].length();
            }
            if (end-start>=k && sum>=lim) {
                result = Math.min(result, sum);
            }
            sum -= str[start].length();
        }
        return result;
    }
}
