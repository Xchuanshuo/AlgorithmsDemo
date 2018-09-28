package lintcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Legend
 * @data by on 18-9-28.
 * @description factorization
 * idea:
 *      dfs+回溯
 */
public class Test652 {

    private List<List<Integer>> result;

    public List<List<Integer>> getFactors(int n) {
        // write your code here
        result = new ArrayList<>();
        dfs(new ArrayList<>(), 2, n);
        return result;
    }

    private void dfs(List<Integer> list, int start, int n) {
        if (start > n) return;
        if (list.size() > 0) {
            list.add(n);
            result.add(new ArrayList<>(list));
            list.remove(list.size()- 1);
        }
        for (int i=start;i<=Math.sqrt(n);i++) {
            if (n % i == 0) {
                list.add(i);
                dfs(list, i, n/i);
                list.remove(list.size()-1);
            }
        }
    }
}
