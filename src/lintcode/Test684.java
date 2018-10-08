package lintcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Legend
 * @data by on 18-10-8.
 * @description missing-string
 */
public class Test684 {

    public List<String> missingString(String str1, String str2) {
        // Write your code here
        Set<String> set = new HashSet<>();
        List<String> result = new ArrayList<>();
        String[] strings1 = str1.split(" ");
        String[] strings2 = str2.split(" ");
        for (String str: strings2) set.add(str.trim());
        for (String str: strings1) {
            if (!set.contains(str)) result.add(str);
        }
        return result;
    }
}
