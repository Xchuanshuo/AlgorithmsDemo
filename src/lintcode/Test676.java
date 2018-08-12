package lintcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Legend
 * @data by on 18-6-16.
 * @description
 */
public class Test676 {

    private static final Map<String, Integer> maps = new HashMap<>();
    private static final List<Integer> star = Arrays.asList(1,2,3,4,5,6,7,8,9);

    public int numDecodings(String s) {
        char[] c = s.toCharArray();
        long[] result = new long[s.length()+1];
        int MOD = 1000000007;
        result[0] = 1;
        for (int i=1;i <= s.length();i++) {
            int cnt1 = cnt1(c[i-1]);
            if (i == 1) {
                result[i] = cnt1;
            } else {
                int cnt2 = cnt2(c[i-2], c[i-1]);
                result[i] += (cnt1*result[i-1]+ cnt2*result[i-2])%MOD;
            }
            if (result[i] == 0) return 0;
        }
        return (int)result[s.length()];
    }

    private int cnt2(char c1, char c2) {
        String key = ""+c1+c2;
        if (maps.containsKey(key)) {
            return maps.get(key);
        }
        List<Integer> A = c1=='*'?star: Arrays.asList(c1-'0');
        List<Integer> B = c2=='*'?star: Arrays.asList(c2-'0');
        int result = 0;
        for (int i=0;i < A.size();i++) {
            for (int j=0;j < B.size();j++) {
                int temp = A.get(i)*10+B.get(j);
                if (temp>=10 && temp<=26) {
                    result++;
                }
                if (temp >= 26) {
                    maps.put(key, result);
                    return result;
                }
            }
        }
        maps.put(key, result);
        return result;
    }

    private int cnt1(char c) {
        if (c == '0') return 0;
        if (c != '*') return 1;
        return 9;
    }

    public static void main(String[] args) {
        Test676 test = new Test676();
        System.out.println(test.numDecodings("**1**"));
    }
}
