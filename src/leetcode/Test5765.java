package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Legend
 * @data by on 21-5-23.
 * @description
 */
public class Test5765 {

    public boolean canReach(String s, int minJump, int maxJump) {
        char[] chs = s.toCharArray();
        int n = chs.length;
        if(chs[n-1] == '1')return false;
        Queue<Integer> q = new LinkedList<>();
        q.offer(minJump);
        int dif = maxJump - minJump;
        for (int i = 1;i < n;i++) {
            if (chs[i] == '1') continue;
            while (!q.isEmpty() && q.peek() + dif < i) {
                q.poll();
            }
            if (q.isEmpty()) return false;
            if (i + minJump < n && q.peek() <= i) {
                q.offer(i + minJump);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Test5765 test = new Test5765();
        String s = "01101110";
        int min = 2, max = 3;
        boolean res = test.canReach(s, min, max);
        System.out.println(res);
    }
}
