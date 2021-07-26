package leetcode;

import java.util.*;

/**
 * @author Legend
 * @data by on 21-7-25.
 * @description https://leetcode-cn.com/problems/find-the-shortest-superstring/
 */
public class Test943 {

    public String shortestSuperstring(String[] words) {
        int n = words.length;
        int len = 1 << n;
        Map<Integer, Set<String>> dp = new HashMap<>();
        Map<Integer, Integer> minMap = new HashMap<>();
//        String[] dp = new String[len];
//        Arrays.fill(dp, "");
        for (int i = 0;i < len;i++) {
            for (int j = 0;j < n;j++) {
                if ((i& (1<<j)) != 0) continue;
                int next = i | (1<<j);
                if (!dp.containsKey(i)) {
                    dp.put(i, new HashSet<>(Collections.singletonList("")));
                }
                if (!dp.containsKey(next)) {
                    dp.put(next, new HashSet<>(Collections.singletonList("")));
                }
                Set<String> preList = dp.get(i);
                for (String pre : preList) {
                    if (pre.length() == 0 && preList.size() != 1) continue;
                    String[] cur = helper(pre, words[j]);
                    int min = minMap.getOrDefault(next, Integer.MAX_VALUE);
                    for (String str : cur) {
                        if (str.length() > min) continue;
                        min = Math.min(min, str.length());
                        dp.get(next).add(str);
                    }
                    minMap.put(next, min);
                }
            }
        }
        String res = "";
        for (String cur : dp.get(len - 1)) {
            if (res.length() == 0 || res.length() > cur.length()) {
                res = cur;
            }
        }
        return res;
    }

    private String[] helper(String a, String b) {
        String res1 =  calc(a, b);
        String res2 =  calc(b, a);
        if (res1.length() == res2.length() && !res1.equals(res2)) return new String[]{res1, res2};
        if (res1.length() < res2.length()) return new String[]{res1};
        return new String[]{res2};
    }

    private String calc(String a, String b) {
        char[] ch1 = a.toCharArray();
        char[] ch2 = b.toCharArray();
        int n1 = ch1.length, n2 = ch2.length;
        int max = 0;
        for (int i = n1 - 1;i >= 0;i--) {
            int l = i, cnt = 0;
            for (int j = 0;j < n2 && l < n1;j++) {
                if (ch1[l] != ch2[j]) break;
                l++; cnt++;
            }
            if (l + n2 < n1) {
                if (cnt != n2) continue;
            }
            if (l == n1) max = Math.max(max, cnt);
            if (max == n2) return a;
        }
        return a + b.substring(max);
    }

    public static void main(String[] args) {
        Test943 test = new Test943();
//        String[] words = {"alex","loves", "leetcode"};
        String[] words = {"catg","ctaagt","gcta","ttca","atgcatc"};
//        String[] words = {"cb","dbc","bcd","ca"};
        String res = test.shortestSuperstring(words);
        System.out.println(res);
    }
}
