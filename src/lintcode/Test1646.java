package lintcode;

import tree.heap.Array;

import java.util.*;

/**
 * @author Legend
 * @data by on 19-4-21.
 * @description checkwords
 */
public class Test1646 {

    public boolean checkWord(String s, String[] str) {
        // Write your code here
        if (str == null || str.length == 0) return false;
        Map<String, Boolean> map = new HashMap<>();
        for (String cur : str) map.put(cur, false);
        if (!map.containsKey(s)) return false;
        map.put(s, true);
        return dfs(s, 1, s.length(), map);
    }

    private boolean dfs(String s, int count, int len, Map<String, Boolean> map) {
        if (count == len) {
            return true;
        } else {
            for (int i = 0;i <s.length();i++) {
                String cur = s.substring(0, i) + s.substring(i+1);
                if (map.containsKey(cur) && !map.get(cur)) {
                    map.put(cur, true);
                    if (dfs(cur, count + 1, len, map)) return true;
                    map.put(cur, false);
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Test1646 test1646 = new Test1646();
        String str = "abcd";
        String[] arr = {"abcd","abc","abd","ac","ad","c"};
        System.out.println(test1646.checkWord(str, arr));
        System.out.println(str.substring(4) + "ss");
    }
}
