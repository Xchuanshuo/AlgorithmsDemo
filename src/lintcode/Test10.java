package lintcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Legend
 * @data by on 18-8-10.
 * @description string-permutation-ii
 */
public class Test10 {

    public List<String> stringPermutation2(String str) {
        // write your code here
        List<String> result = new ArrayList<>();
        if (str==null || str.length()==0) return result;
        char[] chars = str.toCharArray();
        helper("", chars, new boolean[chars.length], result);
        return result;
    }

    private void helper(String cur, char[] chars, boolean[] visited, List<String> result) {
        if (cur.length() == chars.length) {
            result.add(cur);
            return;
        }
        for (int i=0;i<chars.length;i++) {
            if (visited[i] || i!=0 && chars[i]==chars[i-1] && !visited[i-1]) continue;
            visited[i] = true;
            helper(cur+chars[i], chars, visited, result);
            visited[i] = false;
        }
    }
}
