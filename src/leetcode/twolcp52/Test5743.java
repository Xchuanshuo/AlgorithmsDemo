package leetcode.twolcp52;

/**
 * @author Legend
 * @data by on 21-5-15.
 * @description
 */
public class Test5743 {

    public int[] memLeak(int memory1, int memory2) {
        int s = 1;
        while (s <= memory1 || s <= memory2) {
            int max = Math.max(memory1, memory2);
            if (max < s) break;
            if (max == memory1) {
                memory1 -= s;
            } else {
                memory2 -= s;
            }
            s++;
        }
        return new int[]{s, memory1, memory2};
    }
}
