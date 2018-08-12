package lintcode;

/**
 * @author Legend
 * @data by on 18-6-29.
 * @description merge-two-sorted-arrays
 */
public class Test6 {

    public int[] mergeSortedArray(int[] A, int[] B) {
        // write your code here
        int[] result = new int[A.length+B.length];
        int a=0, b=0, curr=0;
        while (a<A.length && b<B.length) {
            if (A[a]<B[b]) {
                result[curr++] = A[a++];
            } else {
                result[curr++] = B[b++];
            }
        }
        while (a<A.length) {
            result[curr++] = A[a++];
        }
        while (b<B.length) {
            result[curr++] = B[b++];
        }
        return result;
    }

    public static void main(String[] args) {
        Test6 test = new Test6();
        int[] A = {1, 2, 5, 6,88};
        int[] B = {3, 4, 7, 9};
        int[] result = test.mergeSortedArray(A, B);
        for (int i: result) {
            System.out.print(i+" ");
        }
    }
}
