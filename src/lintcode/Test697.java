package lintcode;

/**
 * @author Legend
 * @data by on 18-8-16.
 * @description sum-of-square-numbers
 * idea:
 *      这道题直接从0遍历到sqrt(sum) 然后计算num与i^2的差开方
 *      如果这个数能写成这两个数的平方和形式 开方后与取整的值就为0
 *
 */
public class Test697 {

    public boolean checkSumOfSquareNumbers(int num) {
        // write your code here
        int n = (int) Math.sqrt(num);
        for (int i=1;i<=n;i++) {
            double sqrt = Math.sqrt(num-i*i);
            int j = (int) sqrt;
            if (sqrt-j == 0) return true;
        }
        return false;
    }

    public static void main(String[] args) {
    }
}
