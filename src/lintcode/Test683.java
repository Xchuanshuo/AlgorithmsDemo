package lintcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Legend
 * @data by on 18-8-22.
 * @description word-break-iii
 * idea:
 *      明显有问题的题目 之前同样的dfs暴力查找 ac了 不管这些了 说说使用dp的做法
 *      dp[i]表示第i个位置时可以用0..i全部的字符拆分成dict中存在的单词能构成多少条句子
 *      其实这个问题也就可以转换为完全背包问题(Test562) 如果i-j..i的字符组成的字符串在dict中
 *      就说明i位置刚好可以符合“装满”的条件 在这里就是指匹配 此时就把i位置添加i-j这种情况, 也就是统计i
 *      一共有多少构成句子的方法；如果不存在，就不做任何处理 也就是说 都不存在这个大小大物品 刚好能让
 *      背包装满
 */
public class Test683 {

    public int wordBreak3(String s, Set<String> dict) {
        if (s==null || s.length()==0) return 0;
        s = s.toLowerCase();
        int m = s.length();
        Set<String> newDict = new HashSet<>();
        for (String str: dict) {
            newDict.add(str.toLowerCase());
        }
        int[] dp = new int[m+1];
        dp[0] = 1;
        for (int i=1;i<=m;i++) {
            for (int j=1;j<=i;j++) {
                if (dp[i-j] == 0) continue;
                String cur = s.substring(i-j, i);
                if (newDict.contains(cur)) {
                    dp[i] += dp[i-j];
                }
            }
        }
        return dp[m];
    }

    public int wordBreak3two(String s, Set<String> dict) {
        // Write your code here
        if (s==null || s.length()==0) return 0;
        Set<String> newDict = new HashSet<>();
        for (String str: dict) {
            newDict.add(str.toLowerCase());
        }
        return dfs(s.toLowerCase(), 0, dict);
    }

    private int dfs(String s, int start, Set<String> dict) {
        if (s.length() == start) return 1;
        int count = 0;
        for (int i=start+1;i<=s.length();i++) {
            String str = s.substring(start, i);
            if (!dict.contains(str)) continue;
            count += dfs(s, i, dict);
        }
        return count;
    }
}
