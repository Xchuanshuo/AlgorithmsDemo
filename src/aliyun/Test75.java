package aliyun;

/**
 * @author Legend
 * @data by on 21-4-7.
 * @description https://developer.aliyun.com/coding/75
 * idea:
 *      模拟法
 */
public class Test75 {

    public int solution(int n, int m, int w, int[] a, int[] b) {
        int ans1 = helper(n, m, w, a, b);
        int ans2 = helper(m, n, w, b, a);
        return Math.max(ans1, ans2);
    }

    private int helper(int n, int m, int w, int[] a, int[] b) {
        int i, sumA = 0;
        for (i = 0;i < a.length;i++) {
            sumA += a[i];
            if (sumA > w) {
                sumA -= a[i];
                i = i - 1;
                break;
            }
        }
        if (i == n) i--;
        int res = 0;
        while (i >= 0) {
            int k = 0, sum = sumA;
            while (k < m && sum + b[k] <= w) {
                sum += b[k];
                k++;
            }
            res = Math.max(res, i + k + 1);
            sumA -= a[i--];
        }
        return res;
    }

    public static void main(String[] args) {
        int n = 3, m = 4;
        int w = 10;
        int[] a = {1, 2, 3};
        int[] b = {4, 3, 2, 1};
        Test75 test75 = new Test75();
        int res = test75.solution(n, m, w, a, b);
        System.out.println(res);
    }
}
