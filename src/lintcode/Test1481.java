package lintcode;

import java.util.*;

/**
 * @author Legend
 * @data by on 18-10-3.
 * @description unique-substring
 */
public class Test1481 {

    public List<String> uniqueSubstring(String s, int k) {
        // Write your code here
        List<String> result = new ArrayList<>();
        Set<String> set = new HashSet<>();
        for (int i=0;i<=s.length()-k;i++) {
            set.add(s.substring(i, i+k));
        }
        for (String str: set) {
            result.add(str);
        }
        Collections.sort(result);
        return result;
    }
}
