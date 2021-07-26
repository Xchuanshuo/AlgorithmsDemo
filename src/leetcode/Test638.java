package leetcode;

import java.util.*;

/**
 * @author Legend
 * @data by on 21-5-11.
 * @description https://leetcode-cn.com/problems/shopping-offers/
 */
public class Test638 {

    Map<List<Integer>, Integer> map = new HashMap<>();
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        return dfs(price, special, needs);
    }

    public int dfs(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        if (map.containsKey(needs)) {
            return map.get(needs);
        }
        int res = 0;
        for (int i = 0; i < needs.size(); i++) {
            res += needs.get(i) * price.get(i);
        }
        for (List<Integer> pack : special) {
            List<Integer> clone = new ArrayList<>(needs);
            remove(clone, pack);
            if (isMore(clone)) continue;
            res = Math.min(res, pack.get(needs.size()) + dfs(price, special, clone));
        }
        map.put(needs, res);
        return res;
    }

    private void remove(List<Integer> needs, List<Integer> pack) {
        for (int i = 0;i < needs.size();i++) {
            needs.set(i, needs.get(i) - pack.get(i));
        }
    }

    private boolean isMore(List<Integer> needs) {
        for (int need : needs) {
            if (need < 0) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        List<Integer> price = Arrays.asList(4,3,2,9,8,8);
        List<Integer> needs = Arrays.asList(6,5,5,6,4,1);
        List<Integer> p1 = Arrays.asList(1,5,5,1,4,0,18);
        List<Integer> p2 = Arrays.asList(3,3,6,6,4,2,32);
        List<List<Integer>> special = new ArrayList<>();
        special.add(p1);
        special.add(p2);
        Test638 test = new Test638();
        int res = test.shoppingOffers(price, special, needs);
        System.out.println(res);
    }
}
