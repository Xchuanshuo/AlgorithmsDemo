package lintcode;

import java.util.*;

/**
 * @author Legend
 * @data by on 18-8-23.
 * @description word-break-ii
 * idea:
 *      取了前缀后 递归的遍历后缀 需要用一个map来存储搜索的结果
 *      进行记忆化搜索 不然极端情况不能ac
 */
public class Test582 {

    private final Map<String, List<String>> map = new HashMap<>();
    public List<String> wordBreak(String s, Set<String> wordDict) {
        // write your code here
        if (map.containsKey(s)) return map.get(s);
        List<String> result = new ArrayList<>();
        if (wordDict.contains(s)) result.add(s);
        for (int i=1;i<=s.length();i++) {
            String left = s.substring(0, i);
            if (!wordDict.contains(left)) continue;
            String right = s.substring(i);
            for (String str: wordBreak(right, wordDict)) {
                result.add(left+" "+str);
            }
        }
        map.put(s, result);
        return result;
    }
}
