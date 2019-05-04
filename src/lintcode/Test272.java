package lintcode;

/**
 * @author Legend
 * @data by on 19-5-4.
 * @description climbing-stairs-ii
 */
public class Test272 {

    public int climbStairs2(int n) {
        // write your code here
        if(n == 0) return 1;
        if (n < 3) return n;
        int first = 1, second = 1;
        int third = 2, result = 0;
        for (int i = 3;i <= n;i++) {
            result = first + second + third;
            first = second;
            second = third;
            third = result;
        }
        return result;
    }
}
