package lintcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Legend
 * @data by on 18-10-4.
 * @description maximum-association-set
 * idea:
 *      并查集
 */
public class Test805 {

    private Map<String, String> parent;
    private Map<String, Integer> counts;
    public List<String> maximumAssociationSet(String[] ListA, String[] ListB) {
        // Write your code here
        List<String> result = new ArrayList<>();
        if (ListA.length==0 || ListB.length==0) return result;
        parent = new HashMap<>();
        counts = new HashMap<>();
        for (int i=0;i<ListA.length;i++) {
            parent.put(ListA[i], ListA[i]);
            parent.put(ListB[i], ListB[i]);
            counts.put(ListA[i], 1);
            counts.put(ListB[i], 1);
        }
        for (int i=0;i<ListA.length;i++) {
            union(ListA[i], ListB[i]);
        }
        int max = 0;
        String maxParent = null;
        for (String str: counts.keySet()) {
            Integer value = counts.get(str);
            if (value > max) {
                max = value;
                maxParent = str;
            }
            System.out.println(str+":"+value);
        }
        for (String str: parent.keySet()) {
            if (find(str).equals(maxParent)) {
                result.add(str);
            }
        }
        return result;
    }

    private void union(String p, String q) {
        String pRoot = find(p);
        String qRoot = find(q);
        if (pRoot.equals(qRoot)) return;
        parent.put(pRoot, qRoot);
        counts.put(qRoot, counts.get(pRoot)+counts.get(qRoot));
    }

    private String find(String str) {
        // System.out.println(str+" parent is "+ parent.get(str));
        while (!str.equals(parent.get(str))) {
            parent.put(parent.get(str), parent.get(parent.get(str)));
            str = parent.get(str);
        }
        return parent.get(str);
    }
}
