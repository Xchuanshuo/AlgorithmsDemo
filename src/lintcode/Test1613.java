package lintcode;

import tree.Set;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Legend
 * @data by on 19-4-20.
 * @description highest-frequency-ip
 */
public class Test1613 {

    public String highestFrequency(String[] ipLines) {
        // Write your code here
        if (ipLines == null || ipLines.length==0) return null;
        Map<String, Integer> map = new HashMap<>();
        String maxStr = ipLines[0];
        int max = 0;
        for (String str : ipLines) {
            map.put(str, map.getOrDefault(str, 0) + 1);
            if(map.get(str) > max) {
                max = map.get(str);
                maxStr = str;
            }
        }
        return maxStr;
    }
}
