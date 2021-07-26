package leetcode;

/**
 * @author Legend
 * @data by on 21-5-11.
 * @description https://leetcode-cn.com/problems/decode-xored-permutation/
 */
public class Test1734 {

    public int[] decode(int[] encoded) {
        int total = 0;
        int n = encoded.length + 1;
        for (int i = 1;i <= n;i++) total ^= i;
        int t = 0;
        for (int i = 1;i < encoded.length;i+=2) {
            t ^= encoded[i];
        }
        int[] res = new int[n];
        int first = total^t;
        res[0] = first;
        for (int i = 0;i < encoded.length;i++) {
            res[i+1] = encoded[i]^res[i];
        }
        return res;
    }
}
