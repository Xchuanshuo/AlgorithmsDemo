package lintcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Legend
 * @data by on 18-10-8.
 * @description find-elements-in-matrix
 */
public class Test737 {

    public int FindElements(int[][] Matrix) {
        // write your code here
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] arr: Matrix) {
            for (int i: arr) {
                map.put(i, map.getOrDefault(i, 0)+1);
            }
        }
        for (Map.Entry<Integer, Integer> e: map.entrySet()) {
            if (e.getValue() >= Matrix.length) {
                return e.getKey();
            }
        }
        return -1;
    }
}
