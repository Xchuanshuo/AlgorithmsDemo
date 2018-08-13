package lintcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @author Legend
 * @data by on 18-8-13.
 * @description open-the-lock
 * idea:nn
 *      用一个Set保存deadends, 以及访问过的锁(当作死锁处理，无需浪费多余的空间), bfs
 *      一共4个字符，每个字符有两种改变方案
 */
public class Test796 {

    public int openLock(String[] deadends, String target) {
        // Write your code here
        String start = "0000";
        int result = 0;
        Set<String> deadLockSet = new HashSet<>();
        for (String str: deadends) deadLockSet.add(str);
        if (deadLockSet.contains(start)) return -1;
        if (start.equals(target)) return 0;
        Queue<String> queue = new LinkedList<>();
        queue.offer(start);
        while (!queue.isEmpty()) {
            result++;
            int count =  queue.size();
            for (int i=0;i<count;i++) {
                String cur = queue.poll();
                for (int j=0;j<4;j++) {
                    for (int diff=1;diff<=9;diff+=8) {
                        char[] chars = cur.toCharArray();
                        chars[j] = (char) ((chars[j]-'0'+diff)%10+'0');
                        String str = new String(chars);
                        if (target.equals(str)) return result;
                        if (!deadLockSet.contains(str)) {
                            deadLockSet.add(str);
                            queue.offer(str);
                        }
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Test796 test = new Test796();
        String[] deadends = {"0201","0101","0102","1212","2002","0202"};
        String target = "0202";
        System.out.println(test.openLock(deadends, target));
    }
}
