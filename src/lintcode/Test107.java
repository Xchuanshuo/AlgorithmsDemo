package lintcode;

import java.util.Set;

/**
 * @author Legend
 * @data by on 18-8-23.
 * @description word-break
 * idea:
 *      dp 可以看Test683的解答 道理一样 只是这里只需要判断能否拆分
 */
public class Test107 {

    public boolean wordBreak(String s, Set<String> dict) {
        // write your code here
        int maxLength = getMaxLength(dict);
        boolean[] res = new boolean[s.length()+1];
        res[0] = true;

        for (int i=1;i<=s.length();i++) {
            for (int j=1;j<=maxLength && j<=i;j++) {
                String cur = s.substring(i-j, i);
                // 如果当前字符串在字典中　并且之前是可拆分的
                if (dict.contains(cur) && res[i-j]) {
                    res[i] = true;
                    break;
                }
            }
        }

        return res[s.length()];
    }

    private int getMaxLength(Set<String> dict) {
        int max = 0;
        for (String str : dict) {
            max = Math.max(max, str.length());
        }
        return max;
    }
}
