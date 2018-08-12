package lintcode;

/**
 * @author Legend
 * @data by on 18-7-16.
 * @description super-ugly-number
 */
public class Test518 {

    public int nthSuperUglyNumber(int n, int[] primes) {
        // write your code here
        int[] times = new int[primes.length];
        int[] result = new int[n];
        result[0] = 1;
        int minIndex = 0;
        for (int i=1;i<n;i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < primes.length; j++) {
                min = Math.min(min, primes[j] * result[times[j]]);
            }
            result[i] = min;
            System.out.print(min+", ");
            for (int j = 0; j < times.length; j++) {
                if (result[times[j]] * primes[j] == min) {
                    times[j]++;

                }
            }
        }
        return result[n-1];
    }

    public static void main(String[] args) {
        Test518 test = new Test518();
        System.out.println(test.nthSuperUglyNumber(11, new int[]{2, 3, 5}));
    }
}
