package lintcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Legend
 * @data by on 18-8-7.
 * @description parser
 */
public class Test790 {

    public boolean canBeGenerated(String[] generator, char startSymbol, String symbolString) {
        // Write  your code here.
        Map<Character, List<String>> map = new HashMap<>();
        for (int i=0;i<generator.length;i++) {
            char symbol = generator[i].charAt(0);
            if (!map.containsKey(symbol)) {
                map.put(symbol, new ArrayList<>());
            }
            map.get(symbol).add(generator[i].substring(5));
        }
        if (!map.containsKey(startSymbol)) return false;
        return dfs(map, startSymbol+"", symbolString);
    }

    private boolean dfs(Map<Character, List<String>> map, String start, String end) {
        if (start.length() > end.length()) return false;
        if (end.equals(start)) return true;
        for (int i=0;i<start.length();i++) {
            char c = start.charAt(i);
            if (c>='A' && c<='Z') {
                for (String s: map.get(c)) {
                    String str = start.substring(0, i)+s+start.substring(i+1);
                    if (dfs(map, str, end)) return true;
                }
            }
        }
        return false;
    }
}
