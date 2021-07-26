package leetcode;

import java.util.TreeSet;

/**
 * @author Legend
 * @data by on 21-6-26.
 * @description https://leetcode-cn.com/problems/my-calendar-i
 */
public class Test729 {

    class MyCalendar {

        private TreeSet<int[]> treeSet;
        public MyCalendar() {
            treeSet = new TreeSet<>((o1, o2) -> o1[0] - o2[0]);
        }

        public boolean book(int start, int end) {
            int[] newKey = {start, end - 1};
            int[] key1 = treeSet.floor(newKey);
            int[] key2 = treeSet.ceiling(newKey);
            if (key1 == null && key2 == null) {
                treeSet.add(newKey);
                return true;
            } else {
                boolean flag = true;
                if (key1 != null && start <= key1[1]) flag = false;
                if (key2 != null && key2[0] <= end - 1) flag = false;
                if (!flag) return false;
                treeSet.add(newKey);
                return true;
            }
        }
    }

}
