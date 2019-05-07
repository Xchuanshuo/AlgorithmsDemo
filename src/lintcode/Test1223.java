package lintcode;

import tree.heap.Array;

import java.util.*;

/**
 * @author Legend
 * @data by on 19-5-6.
 * @description unique-substrings-in-wraparound-string
 * idea:
 *      dp 挺trick的一道题 本来想的是把子字符串分组然后再求和 结果去重实在是太麻烦了
 *      好的做法是统计以某个字符结尾的字符串最大的长度是多少 然后统一求和
 */
public class Test1223 {

    public int findSubstringInWraproundString(String p) {
        if (p == null || p.length() == 0) return 0;
        Map<Character, Integer> map = new HashMap<>();
        int[] dp = new int[p.length()];
        char[] chars = p.toCharArray();
        for (int i = 0;i < chars.length;i++) {
            map.put(chars[i], 1);
            dp[i] = 1;
        }
        for (int i = 1;i < chars.length;i++) {
            if ((chars[i-1]-'a'+1)%26 == (chars[i]-'a')%26) {
                dp[i] = dp[i-1] + 1;
                if (dp[i] > map.get(chars[i])) {
                    map.put(chars[i], dp[i]);
                }
            }
        }
        int result = 0;
        for (int val : map.values()) result += val;
        return result;
    }
}
