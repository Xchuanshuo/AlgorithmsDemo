package lintcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Legend
 * @data by on 18-6-29.
 * @description matrix-finding-number
 */
public class Test1409 {

    public int findingNumber(int[][] mat) {
        // Write your code here
        if (null==mat || mat.length==0) return -1;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i: mat[0]) {
            map.put(i, 0);
        }
        int m = mat.length;
        for (int i=1;i<m;i++) {
            for (int v: mat[i]) {
                if (map.containsKey(v)) {
                    if (map.get(v)<i-1) {
                        map.remove(v);
                    } else {
                        map.put(v, i);
                    }
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i: map.keySet()) {
            if (map.get(i)==m-1 && i<min) min = i;
        }
        if (min == Integer.MAX_VALUE) return -1;
        return min;
    }

    public static void main(String[] args) {
        Test1409 test = new Test1409();
        int[][] nums = {{1,2,3}, {3,4,1}, {2,1,3}};
        System.out.println(test.findingNumber(nums));
    }
}
