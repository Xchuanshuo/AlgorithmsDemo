package lintcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Legend
 * @data by on 18-8-16.
 * @description palindrome-partitioning
 * idea:
 *      递归 + 回溯
 *
 */
public class Test136 {

    private List<List<String>> res = new ArrayList<>();

    public List<List<String>> partition(String s) {
        // write your code here

        if (s == null || s.length() == 0) {
            return res;
        }

        List<String> partition = new ArrayList<>();
        solve(s,0,partition);

        return res;
    }

    private void solve(String s,int startIndex,List<String> partition) {

        if (startIndex == s.length()) {
            res.add(new ArrayList<String>(partition));
            return;
        }

        for (int i=startIndex;i < s.length();i++) {
            String str = s.substring(startIndex,i+1);
            if (!isPalindrome(str)) {
                continue;
            }
            partition.add(str);
            solve(s,i+1,partition);
            partition.remove(partition.size()-1);
        }
        return;
    }

    private  boolean isPalindrome(String s) {
        for (int i=0,j=s.length()-1;i < j;i++,j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}
