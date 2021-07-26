package leetcode;

/**
 * @author Legend
 * @data by on 21-5-27.
 * @description https://leetcode-cn.com/problems/hamming-distance/
 */
public class Test461 {

    public int hammingDistance(int x, int y) {
        int xor = x^y;
        int cnt = 0;
        while (xor != 0) {
            xor &= (xor-1);
            cnt++;
        }
        return cnt;
    }
}
