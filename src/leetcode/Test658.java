package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Legend
 * @data by on 21-5-3.
 * @description https://leetcode-cn.com/problems/find-k-closest-elements/
 * idea:
 *      双指针
 */
public class Test658 {

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int l = 0, r = arr.length -1;
        while (r-l >= k) {
            if (Math.abs(arr[l] - x) > Math.abs(arr[r] - x)) {
                l++;
            } else {
                r--;
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int i = l;i <= r;i++) {
            list.add(arr[i]);
        }
        return list;
    }
}
