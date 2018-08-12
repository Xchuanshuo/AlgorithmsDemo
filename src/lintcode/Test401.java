package lintcode;

/**
 * @author Legend
 * @data by on 18-7-7.
 * @description kth-smallest-number-in-sorted-matrix
 */
public class Test401 {

    public int kthSmallest(int[][] matrix, int k) {
        // write your code here
        if (null==matrix || matrix.length==0) {
            return -1;
        }
        int row=matrix.length-1, col=matrix[0].length-1;
        int lo=matrix[0][0], hi=matrix[row][col];
        while (lo < hi) {
            int mid = lo + (hi-lo)/2;
            int count=0, j=col;
            for (int i=0;i<=row;i++) {
                while (j>=0 && matrix[i][j]>mid) j--;
                count += j+1;
            }
            if (count < k) {
                lo = mid +1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }

    public static void main(String[] args) {
        Test401 test = new Test401();
        int[][] nums = {{1 ,5 ,7},
                        {3 ,7 ,8},
                        {4 ,8 ,9}};
        System.out.println(test.kthSmallest(nums, 4));
    }
}
