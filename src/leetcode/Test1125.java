package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Legend
 * @data by on 21-7-30.
 * @description https://leetcode-cn.com/problems/smallest-sufficient-team/
 * idea:
 *      状压DP
 */
public class Test1125 {

    public int[] smallestSufficientTeam(String[] skills, List<List<String>> people) {
        int n = skills.length;
        HashMap<String, Integer> posMap = new HashMap<>();
        for (int i = 0;i < n;i++) posMap.put(skills[i], i);
        List<Integer> peoples = new ArrayList<>();
        for (List<String> peo : people) {
            int cur = 0;
            for (String p : peo) cur |= 1 << posMap.get(p);
            peoples.add(cur);
        }
        int len = 1 << n;
        List<Integer>[] dp = new List[len];
        dp[0] = new ArrayList<>();
        for (int i = 0;i < len;i++) {
            for (int j = 0;j < peoples.size();j++) {
                int next = i | peoples.get(j);
                if (next == i || dp[i] == null) continue;
                if (dp[next] == null || dp[next].size() > dp[i].size() + 1) {
                    List<Integer> list = new ArrayList<>(dp[i]);
                    list.add(j);
                    dp[next] = list;
                }
            }
        }
        int[] res = new int[dp[len-1].size()];
        for (int i = 0;i < res.length;i++) res[i] = dp[len-1].get(i);
        return res;
    }
}
