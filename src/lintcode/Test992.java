package lintcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Legend
 * @data by on 18-9-29.
 * @description beautiful-arrangement-ii
 * idea:
 *      这道题目解法也比较巧妙 求满足不同绝对值的个数的排列 使用两个指针分别
 *      从low=1,high=k+1的位置向前，向后遍历，这样做就能保证不同绝对值的数量能
 *      满足个数k，因为前提条件是k<n, 所以把k不同的绝对值取完后(k减到绝对值为1)
 *      后面的直接按照升序即可
 */
public class Test992 {

    public int[] constructArray(int n, int k) {
        int[] result = new int[n];
        int len=0, low=1, high=k+1;
        while (low < high) {
            result[len++] = low++;
            result[len++] = high--;
        }
        if (low == high) {
            result[len++] = low;
        }
        while (len < n) {
            result[len] = ++len;
        }
        return result;
    }
}
