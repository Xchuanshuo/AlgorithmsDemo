package leetcode;

import java.util.*;

/**
 * @author Legend
 * @data by on 21-6-20.
 * @description https://leetcode-cn.com/problems/throne-inheritance/
 */
public class Test1600 {

    class ThroneInheritance {

        private String king = "";
        private Map<String, List<String>> map = new HashMap<>();
        private Set<String> deadSet = new HashSet<>();

        public ThroneInheritance(String kingName) {
            this.king = kingName;
            map.put(king, new LinkedList<>());
        }

        public void birth(String parentName, String childName) {
            if (!map.containsKey(parentName)) {
                map.put(parentName, new LinkedList<>());
            }
            map.get(parentName).add(childName);
        }

        public void death(String name) {
            deadSet.add(name);
        }

        public List<String> getInheritanceOrder() {
            List<String> result = new LinkedList<>();
            successor(king, result);
            return result;
        }

        private void successor(String cur, List<String> order) {
            if (!deadSet.contains(cur)) order.add(cur);
            List<String> children = map.get(cur);
            if (children != null) {
                for (String child : children) {
                    successor(child, order);
                }
            }
        }
    }
}
