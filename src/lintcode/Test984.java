package lintcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Legend
 * @data by on 19-5-5.
 * @description arithmetic-slices-ii-subsequence
 */
public class Test984 {

    public int numberOfArithmeticSlices(int[] A) {
        if (A == null || A.length < 3) return 0;
        int result = 0;
        Map<Long, Integer>[] maps = new HashMap[A.length];
        for (int i = 0;i < A.length;i++) {
            maps[i] = new HashMap<>();
            for (int j = i-1;j >= 0;j--) {
                long d = A[i] - A[j];
                int sequence = maps[j].getOrDefault(d, 0);
                int origin = maps[i].getOrDefault(d, 0);
                maps[i].put(d, origin+sequence + 1);
                result += sequence;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] A = {2, 4, 6, 8, 10};
        Test984 test = new Test984();
        System.out.println(test.numberOfArithmeticSlices(A));
    }
}
