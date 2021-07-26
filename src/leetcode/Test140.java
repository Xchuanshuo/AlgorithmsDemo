package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Legend
 * @data by on 21-4-16.
 * @description https://leetcode-cn.com/problems/word-break-ii/
 */
public class Test140 {

    private Set<String> set = new HashSet<>();
    private List<String> result = new ArrayList<>();
    public List<String> wordBreak(String s, List<String> wordDict) {
        for (String w : wordDict) set.add(w);
        helper(s, 0, "");
        return result;
    }

    private void helper(String s, int l, String str) {
        if (l == s.length()) {
            result.add(str.trim());
            return;
        }
        for (int i = l;i < s.length();i++) {
            String cur = s.substring(l, i + 1);
            if (!set.contains(cur)) continue;
            helper(s, i + 1, str +" " + cur);
        }
    }
}
