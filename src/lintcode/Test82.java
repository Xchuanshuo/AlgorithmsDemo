package lintcode;

/**
 * @author Legend
 * @data by on 18-6-17.
 * @description
 */
public class Test82 {
    public int singleNumber(int[] A) {
        // write your code here
        if (null == A || A.length == 0) return -1;
        int result = 0;
        for (int i=0;i < A.length;i++) {
            result ^= A[i];
        }
        return result;
    }

    public static void main(String[] args) {
        Test82 test = new Test82();
        int[] A = {1,1,2,2,3,4,4};
        System.out.println(test.singleNumber(A));
    }
}
