package lintcode;

/**
 * @author Legend
 * @data by on 18-10-2.
 * @description coin-problem
 * idea:
 *      贪心
 */
public class Test1546 {

    public int coinProblem(int n, int m) {
        // Write your code here
        int money = n - m;
        int[] category = {100,50,20,10,5,2,1};
        int count = 0;
        for (int i=0;i<category.length;i++) {
            while (money>=category[i]) {
                count++;
                money -= category[i];
            }
        }
        return count;
    }
}
