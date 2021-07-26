package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Legend
 * @data by on 21-6-19.
 * @description https://leetcode-cn.com/problems/maximum-length-of-a-concatenated-string-with-unique-characters/
 * idea:
 *      dfs回溯 + 剪枝
 */
public class Test1239 {

    int res = 0, max = 0;
    public int maxLength(List<String> arr) {
        List<String> newArr = new ArrayList<>();
        Set<Character> set = new HashSet<>();
        for (String w : arr) {
            if (isValid(w)) newArr.add(w);
            for (char c : w.toCharArray()) set.add(c);
        }
        max = set.size();
        dfs(newArr, 0,  new boolean[26]);
        return res;
    }

    private void dfs(List<String> arr, int l, boolean[] used) {
        int cnt = 0;
        for (int i = 0;i < 26;i++) if (used[i]) cnt++;
        res = Math.max(res, cnt);
        if (res >= max) return;
        for (int i = l;i < arr.size();i++) {
            String cur = arr.get(i);
            if (isUsed(cur, used)) continue;
            for (char c : cur.toCharArray()) used[c-'a'] = true;
            dfs(arr, l + 1, used);
            for (char c : cur.toCharArray()) used[c-'a'] = false;
        }
    }

    private boolean isValid(String str) {
        boolean[] t = new boolean[26];
        for (char c : str.toCharArray()) {
            if (t[c-'a']) return false;
            t[c-'a'] = true;
        }
        return true;
    }

    private boolean isUsed(String str, boolean[] t) {
        for (char c : str.toCharArray()) {
            if (t[c-'a']) return true;
        }
        return false;
    }
}
