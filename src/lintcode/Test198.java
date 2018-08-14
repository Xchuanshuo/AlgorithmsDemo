package lintcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Legend
 * @data by on 18-8-14.
 * @description permutation-index-ii
 * idea:
 *      与题permutation-index(Test197)解法一样 但由于这里有重复元素
 *      所以需要去重 这里的做法是计算到某位时除以重复个数的阶乘
 *
 */
public class Test198 {

    public long permutationIndexII(int[] A) {
        // write your code here
        if (A==null || A.length==0) return 0;
        int n = A.length;
        long result = 1, fac = 1, dup = 1;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=n-1;i>=0;i--) {
            if (!map.containsKey(A[i])) {
                map.put(A[i], 1);
            } else {
                map.put(A[i], map.get(A[i])+1);
                dup *= map.get(A[i]);
            }
            int count = 0;
            for (int j=i;j<n;j++) {
                if (A[j]<A[i]) count++;
            }
            result += count*fac/dup;
            fac *= n - i;
        }
        return result;
    }
}
