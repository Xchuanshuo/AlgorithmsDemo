package lintcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Legend
 * @data by on 19-4-21.
 * @description bank-system
 */
public class Test1785 {

    class BankSystem {

        private Map<Integer, List<Helper>> map;

        public BankSystem(){
            this.map = new HashMap<>();
        }

        public void deposite(int id, int amount, long timestamp) {
            if (!map.containsKey(id)) map.put(id, new ArrayList<>());
            List<Helper> list = map.get(id);
            Helper helper = new Helper(amount, timestamp);
            if (!list.isEmpty()) {
                helper.money += list.get(list.size()-1).money;
            }
            list.add(helper);
        }

        public boolean withdraw(int id, int amount , long timestamp) {
            if (!map.containsKey(id)) map.put(id, new ArrayList<>());
            List<Helper> list = map.get(id);
            if (list.isEmpty()) return false;
            Helper helper = new Helper(amount, timestamp);
            helper.money = list.get(list.size()-1).money - helper.money;
            if (helper.money < 0) return false;
            list.add(helper);
            return true;
        }

        public int[] check(int id, long startTime, long endTime) {
            if (!map.containsKey(id)) map.put(id, new ArrayList<>());
            List<Helper> list = map.get(id);
            if (list.size() == 0) return new int[]{};
            int v1 = find(list, startTime);
            int v2 = find(list, endTime);
            return new int[]{v1, v2};
        }

        private int find(List<Helper> list, long time) {
            for (int i = list.size()-1;i >= 0;i--) {
                Helper helper = list.get(i);
                if (time >= helper.timestamp) return helper.money;
            }
            return 0;
        }
    }

    class Helper {
        int money;
        long timestamp;
        Helper(int money, long timestamp) {
            this.money = money;
            this.timestamp = timestamp;
        }
    }
}
