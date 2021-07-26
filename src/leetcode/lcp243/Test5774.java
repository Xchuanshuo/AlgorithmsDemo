package leetcode.lcp243;

import java.util.*;

/**
 * @author Legend
 * @data by on 21-5-30.
 * @description
 */
public class Test5774 {

    public int[] assignTasks(int[] servers, int[] tasks) {
        Queue<Integer> worker = new PriorityQueue<>((o1, o2) -> {
            if (servers[o1] == servers[o2]) return o1 - o2;
            return servers[o1] - servers[o2];
        });
        for (int i = 0;i < servers.length;i++) {
            worker.offer(i);
        }
        Queue<int[]> running = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);
        int n = tasks.length;
        int[] ans = new int[n];
        int seconds = 0, idx = 0;
        while (true) {
            if (idx == n) break;
            while (!running.isEmpty() && running.peek()[0]<=seconds) {
                worker.offer(running.remove()[1]);
            }
            if (worker.isEmpty()) {
                seconds = running.peek()[0];
                continue;
            }
            while (!worker.isEmpty() && idx < n && seconds >= idx) {
                int server = worker.remove();
                ans[idx] = server;
                running.offer(new int[]{seconds + tasks[idx], server});
                idx++;
            }
            seconds++;
        }
        return ans;
    }

    public static void main(String[] args) {
        Test5774 test = new Test5774();
        int[] servers = {3,3,2};
        int[] tasks = {1,2,3,2,1,2};
        int[] ans = test.assignTasks(servers, tasks);
        System.out.println(Arrays.toString(ans));
    }
}
