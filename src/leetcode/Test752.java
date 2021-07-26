package leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @author Legend
 * @data by on 21-6-25.
 * @description https://leetcode-cn.com/problems/open-the-lock/
 */
public class Test752 {

    public int openLock(String[] deadends, String target) {
        Set<String> set = new HashSet<>();
        for (String d : deadends) set.add(d);
        String start = "0000";
        if (start.equals(target)) return 0;
        Queue<String> q = new LinkedList<>();
        if (!set.contains(start)) q.offer(start);
        set.add(start);
        int step = 0;
        while (!q.isEmpty()) {
            step++;
            int size = q.size();
            for (int k = 0;k < size;k++) {
                String cur = q.poll();
                for (int i = 0;i < 4;i++) {
                    String s1 = plus(cur, i);
                    if (s1.equals(target)) return step;
                    if (!set.contains(s1)) {
                        set.add(s1); q.offer(s1);
                    }
                    String s2 = minus(cur, i);
                    if (s2.equals(target)) return step;
                    if (!set.contains(s2)) {
                        set.add(s2); q.offer(s2);
                    }
                }
            }
        }
        return -1;
    }

    private String minus(String origin, int i) {
        char[] chs = origin.toCharArray();
        if (chs[i] == '0') {
            chs[i] = '9';
        } else {
            chs[i] -= 1;
        }
        return new String(chs);
    }

    private String plus(String origin, int i) {
        char[] chs = origin.toCharArray();
        if (chs[i] == '9') {
            chs[i] = '0';
        } else {
            chs[i] += 1;
        }
        return new String(chs);
    }
}
