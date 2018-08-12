package lintcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Legend
 * @data by on 18-8-7.
 * @description split-string
 */
public class Test680 {

    private List<List<String>> result = new ArrayList<>();
    public List<List<String>> splitString(String s) {
        // write your code here
        if (s==null || s.length()==0) {
            result.add(new ArrayList<>());
            return result;
        }
        helper(s, 0, new ArrayList<>());
        return result;
    }

    private void helper(String s, int startIndex, List<String> list) {
        if (startIndex == s.length()) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i=startIndex;i<startIndex+2 && i<s.length();i++) {
            list.add(s.substring(startIndex, i+1));
            helper(s, i+1, list);
            list.remove(list.size()-1);
        }
    }
}
