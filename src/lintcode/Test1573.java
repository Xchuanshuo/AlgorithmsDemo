package lintcode;

import java.util.Arrays;

/**
 * @author Legend
 * @data by on 18-8-25.
 * @description legal-string
 * idea:
 * 给定S="AABACCDCD",k=3,返回[0,2,0,1,0,2,0,1,0]
 * 给定S = "ABBA",k = 2, 返回[0,0,1,0]
 */
public class Test1573 {

    public int[] getAns(int k, String S) {
        // Write your code here.
        int n = S.length();
        int[] result = new int[n];
        long[] hash = new long[26];
        Arrays.fill(hash, -n);
        long cur = 0;
        for (int i=0;i<n;i++) {
            int index = S.charAt(i)-'A';
            cur++;
            if (hash[index]+k > cur) {
                result[i] = (int)(hash[index]+k-cur);
                cur = hash[index]+k;
            }
            hash[index] = cur;
        }
        return result;
    }
}
