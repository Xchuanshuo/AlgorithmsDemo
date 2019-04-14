package lintcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Legend
 * @data by on 19-4-14.
 * @description search-subarray
 */
public class Test1457 {

    public int searchSubarray(int[] arr, int k) {
        // Write your code here
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        for (int i=0;i<arr.length;i++) {
            sum += arr[i];
            if (sum == k) {
                return i+1;
            } else if (map.containsKey(sum-k)) {
                return i-map.get(sum-k);
            }
            map.put(sum, i);
        }
        return -1;
    }
}
