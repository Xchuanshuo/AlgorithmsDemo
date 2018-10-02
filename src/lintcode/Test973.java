package lintcode;

/**
 * @author Legend
 * @data by on 18-10-2.
 * @description 1-bit-and-2-bit-characters
 * idea:
 *      与Test1459一样
 */
public class Test973 {

    public boolean isOneBitCharacter(int[] bits) {
        // Write your code here
        int k = 0;
        while (k < bits.length-1) {
            if (bits[k] == 1) {
                k += 2;
            } else {
                k++;
            }
        }
        return k>=bits.length?false:true;
    }
}
