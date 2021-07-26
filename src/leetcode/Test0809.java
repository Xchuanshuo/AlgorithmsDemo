package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Legend
 * @data by on 21-7-19.
 * @description https://leetcode-cn.com/problems/bracket-lcci/
 */
public class Test0809 {

    List<String> result = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        dfs(0, 0, n, "");
        return result;
    }

    private void dfs(int l, int r, int n,String cur) {
        if (r > l || l > n) return;
        if (l == n && r == n) {
            result.add(cur);
        }
        l += 1;
        dfs(l, r, n, cur + "(");
        l -= 1;
        dfs(l, ++r, n,cur + ")");
    }

    public static void main(String[] args) {
        Test0809 test = new Test0809();
        System.out.println(test.generateParenthesis(3));
    }
}
