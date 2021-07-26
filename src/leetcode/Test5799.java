package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Legend
 * @data by on 21-6-27.
 * @description https://leetcode-cn.com/problems/number-of-wonderful-substrings/
 */
public class Test5799 {

    public long wonderfulSubstrings(String word) {
        char[] chs = word.toCharArray();
        List<Integer> list = new ArrayList<>();
        list.add(0);
        for (int i = 0;i < 10;i++) {
            list.add(1 << i);
        }
        int[] cnt = new int[(1<<10) + 1];
        cnt[0] = 1; long res = 0;
        int state = 0;
        for (char c : chs) {
            state ^= 1 << (c - 'a');
            for (int good : list) {
                res += cnt[state ^ good];
            }
            cnt[state]++;
        }
        return res;
    }
}
