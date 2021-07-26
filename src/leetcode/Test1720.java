package leetcode;

/**
 * @author Legend
 * @data by on 21-5-6.
 * @description https://leetcode-cn.com/problems/decode-xored-array/
 */
public class Test1720 {

    public int[] decode(int[] encoded, int first) {
        int n = encoded.length;
        int[] src = new int[n+1];
        src[0] = first;
        int k = 1;
        for (int i = 0;i < n;i++) {
            src[k] = src[k-1]^encoded[i];
            k++;
        }
        return src;
    }
}
