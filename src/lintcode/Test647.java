package lintcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Legend
 * @data by on 18-7-15.
 * @description find-all-anagrams-in-a-string
 */
public class Test647 {

    public List<Integer> findAnagrams(String s, String p) {
        // write your code here
        List<Integer> result = new ArrayList<>();
        if (s.length()==0 || p.length()>s.length()) return result;
        int[] chars = new int[26];
        for (char c: p.toCharArray()) chars[c-'a']++;
        int count = p.length(), l = 0, r = 0;
        while (r < s.length()) {
            if (chars[s.charAt(r++)-'a']-- > 0) count--;
            if (count == 0) result.add(l);
            if (r-l == p.length()) {
                if (chars[s.charAt(l++)-'a']++ >= 0) count++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Test647 test = new Test647();
        System.out.println(test.findAnagrams("cbaebabacd", "abc"));
    }
}
