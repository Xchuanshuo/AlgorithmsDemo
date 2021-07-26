package leetcode;

import java.util.Stack;

/**
 * @author Legend
 * @data by on 21-6-29.
 * @description https://leetcode-cn.com/problems/excel-sheet-column-title/
 */
public class Test168 {

    public String convertToTitle(int n) {
        Stack<Character> s = new Stack<>();
        while (n > 0) {
            n -= 1;
            s.push((char)((n%26)+ 'A' ));
            n /= 26;
        }
        StringBuilder sb = new StringBuilder();
        while (!s.isEmpty()) {
            sb.append(s.pop());
        }
        return sb.toString();
    }
}
