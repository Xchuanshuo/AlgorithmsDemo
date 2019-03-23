package lintcode;

/**
 * @author Legend
 * @data by on 18-12-22.
 * @description
 */
public class Test1666 {

    private Integer count = 0;
    public int getWays(int[] a, int k) {
        // Write your code here
        dfs(a, k, 0, 0);
        return count;
    }

    private void dfs(int[] a, int k, int idx, int sum) {
        if (k == 0) {
            if (isPrime(sum)) count++;
            return;
        }
        for (int i=idx;i<a.length-k+1;i++) {
            k--;
            dfs(a, k, i+1, sum+a[i]);
            k++;
        }
    }

    private boolean isPrime(int sum) {
        if (sum<=1) return true;
        for (int i=2;i<=Math.sqrt(sum);i++) {
            if (sum%i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int a[] = {1,2,3,4,5,6,7,8};
        int k = 3;
        Test1666 test = new Test1666();
        System.out.println(test.getWays(a, k));
    }
}
