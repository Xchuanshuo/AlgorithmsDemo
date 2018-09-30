package lintcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Legend
 * @data by on 18-10-1.
 * @description palindrome-permutation-ii
 * idea:
 *      dfs+回溯 求回文排列 所以给定的字符串必须满足每个字符都为偶数个，最多只能
 *      有1个字符为奇数个 所以首先需要统计每个字符的个数 如果有一个字符为奇数个
 *      则求解排列时需要从这个字符的左右两边去添加其它字符 才能满足回文排列的条件
 *      如果全部为偶数个 就可以直接任意方式进行组合
 */
public class Test917 {

    private int len = 0;
    private Map<Character,Integer> map = new HashMap<>();
    public List<String> generatePalindromes(String s) {
        // write your code here
        List<String> result = new ArrayList<>();
        if (s==null || s.length()==0) {
            return result;
        }
        len = s.length();
        for (Character c: s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        int count = 0;
        char c = ' ';
        for (Map.Entry<Character,Integer> m: map.entrySet()) {
            if (m.getValue()%2 == 1) {
                count++;
                c = m.getKey();
            }
        }
        if (count>1) {
            return result;
        }
        dfs(count==1?String.valueOf(c):"", result);
        return result;
    }

    private void dfs(String str, List<String> result) {
        if (str.length() == len) {
            result.add(str);
            return;
        }
        for (Character c: map.keySet()) {
            if (map.get(c) > 1) {
                map.put(c, map.get(c)-2);
                dfs(c+str+c, result);
                map.put(c, map.get(c)+2);
            }
        }
    }
}
