package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Legend
 * @data by on 21-6-16.
 * @description https://leetcode-cn.com/problems/concatenated-words/
 * idea:
 *      要判断某个字符串是否由words中的多个单词构成, 只需要满足对于某一切分点
 *      两边的字符串均由words的单词构成, 所以用dp[i]表示单词word的前i个字符
 *      是否由words中的单词构成, 只需要找到一个i前面某个位置j, 使得两边都满足条件,
 *      那么字符串前i个字符即满足条件, 最后dp[n]表示字符串的前n个字符是否满足题意
 *      满足则加入到结果集
 */
public class Test472 {

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Set<String> set = new HashSet<>();
        for (String w : words) set.add(w);
        List<String> list = new ArrayList<>();
        for (String word : words) {
            char[] c = word.toCharArray();
            int n = c.length, cnt = 0;
            boolean[] dp = new boolean[n+1];
            dp[0] = true;
            for (int i = 1;i <= n;i++) {
                for (int j = i-1;j >= 0;j--) {
                    String str = new String(c, j, i - j);
                    if (dp[j] && set.contains(str)) {
                        if (i == n && j != 0) cnt++;
                        dp[i] = true; break;
                    }
                }
            }
            if (dp[n] && cnt >= 1) list.add(word);
        }
        return list;
    }
}
