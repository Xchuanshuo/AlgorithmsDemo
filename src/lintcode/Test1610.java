package lintcode;

/**
 * @author Legend
 * @data by on 19-4-20.
 * @description find-the-numbers
 */
public class Test1610 {

    public int[] getNumbers(int n) {
        // Write your code here
        if (n < 0) return new int[]{};
        if (n == 0) return new int[]{1};
        if (n == 1) return new int[]{2};
        int first = 0, second = 1;
        int third = first + second;
        while (third < n) {
            first = second;
            second = third;
            third = first + second;
        }
        if (third == n) third += second;
        return new int[]{second, third};
    }
}
