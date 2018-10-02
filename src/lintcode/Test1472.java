package lintcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Legend
 * @data by on 18-10-2.
 * @description twins-strings
 * idea:
 *      只需要比较奇数或偶数位置的字符数量是否相等
 */
public class Test1472 {

    public String isTwin(String s, String t) {
        // Write your code here
        if (s==null && t==null) return "Yes";
        if (s==null || t==null) return "No";
        if (s.length() != t.length()) return "No";
        Map<Character,Integer> map = new HashMap<>();
        for (int i=0;i<s.length();i+=2) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0)+1);
        }
        for (int i=0;i<t.length();i+=2) {
            int count = map.getOrDefault(t.charAt(i), 0);
            if (count == 0) return "No";
            map.put(t.charAt(i), count-1);
        }
        return "Yes";
    }
}
