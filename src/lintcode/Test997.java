package lintcode;

import java.util.*;

/**
 * @author Legend
 * @data by on 18-8-2.
 * @description print-organization-chart
 */
public class Test997 {

    private Map<String, List<String>> map = new HashMap<>();
    private Map<String, String> jobs = new HashMap<>();
    private Map<String, String> years = new HashMap<>();
    public List<String> getOrganization(List<List<String>> relationship) {
        // Write your code here
        String ceo = "";
        List<String> result = new ArrayList<>();
        for (List<String> list: relationship) {
            String name = list.get(0);
            String head = list.get(1);
            String job = list.get(2);
            String year = list.get(3);
            jobs.put(name, job);
            years.put(name, year);
            if (head.equals("NULL")) {
                ceo = name;
                continue;
            }
            if (!map.containsKey(head)) {
                map.put(name, new ArrayList<>());
            }
            map.get(head).add(name);
        }
        result.add(ceo+" ("+jobs.get(ceo)+") "+years.get(ceo));
        dfs(ceo, "-", result);
        return result;
    }

    private void dfs(String name, String prefix, List<String> result) {
        if (!map.containsKey(name))  {
            return;
        }
        List<String> list = map.get(name);
        Collections.sort(list);
        for (String junior: list) {
            result.add(prefix+junior+" ("+jobs.get(junior)+") "+years.get(junior));
            dfs(junior, prefix+"-", result);
        }
    }
}
