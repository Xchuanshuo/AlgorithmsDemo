package lintcode;

import java.util.Arrays;
import java.util.Collections;

/**
 * @author Legend
 * @data by on 18-8-25.
 * @description spring-tour
 * idea:
 *      双指针
 */
public class Test1575 {

    public int getAnswer(int[] a) {
        // Write your code here
        Arrays.sort(a);
        int l=0, r = a.length-1, result=0;
        while (l<=r) {
            int cur = a[r--];
            while (l<=r && cur+a[l]<=4) {
                cur += a[l++];
            }
            result++;
        }
        return result;
    }
}
