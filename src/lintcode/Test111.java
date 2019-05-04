package lintcode;

/**
 * @author Legend
 * @data by on 19-5-4.
 * @description climbing-stairs
 */
public class Test111 {

    // public int climbStairs(int n) {
    //     // write your code here
    //     if (n < 3) {
    //         return n;
    //     }
    //     int[] res = new int[n+1];
    //     res[1] = 1;
    //     res[2] = 2;
    //     for (int i=3;i <= n;i++) {
    //         res[i] = res[i-2] + res[i-1];
    //     }
    //     return res[n];
    //     // return climbStairs(n-1)+climbStairs(n-2);
    // }

    public int climbStairs(int n) {
        // write your code here
        if (n < 3) {
            return n;
        }
        int first = 1, second = 2;
        int result = 0;
        for (int i=2;i < n;i++) {
            result = first + second;
            first = second;
            second = result;
        }
        return result;
    }
}
