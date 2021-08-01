package leetcode.lcp252;


/**
 * @author Legend
 * @data by on 21-8-1.
 * @description
 */
public class Test5187 {

    public long minimumPerimeter(long neededApples) {
        long e = 1, sum = 12;
        while (sum < neededApples) {
            e++;
            sum += 12 * e * e;
        }
        return 8*e;
    }

    public static void main(String[] args) {
        Test5187 test = new Test5187();
        long res = test.minimumPerimeter(100000000);
        System.out.println(res);
    }
}
