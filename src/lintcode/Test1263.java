package lintcode;

/**
 * @author Legend
 * @data by on 18-9-12.
 * @description is-subsequence
 * idea:
 *      可以用与Test1024一样的方法 但对于这道题 t有可能长度非常大 可能出现遍历很久才
 *      出现和s匹配的情况 所以 这里可以直接遍历s 使用indexof去到t里面找匹配的情况
 *      并且每次匹配后从上次的位置后面再开始匹配
 */
public class Test1263 {

    public boolean isSubsequence(String s, String t) {
        // Write your code here
        int index = 0;
        for (int i=0;i<s.length();i++) {
            index = t.indexOf(s.charAt(i), index);
            if (index<0) return false;
            index++;
        }
        return true;
    }
}
