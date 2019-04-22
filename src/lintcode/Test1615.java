package lintcode;

/**
 * @author Legend
 * @data by on 19-4-22.
 * @description the-result-of-investment
 */
public class Test1615 {

    public int[] getAns(int[] funds, int a, int b, int c) {
        // Write your code here
        int[] res = new int[3];
        res[0] = a;
        res[1] = b;
        res[2] = c;
        for (int i = 0;i < funds.length;i++) {
            int id = 0;
            for (int j = 1;j < 3;j++) {
                if (res[j] < res[id]) {
                    id = j;
                }
            }
            res[id] += funds[i];
        }
        return res;
    }
}
