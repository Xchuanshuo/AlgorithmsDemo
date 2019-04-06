package lintcode;

import java.util.List;
import java.util.Stack;

/**
 * @author Legend
 * @data by on 19-4-6.
 * @description exclusive-time-of-functions
 */
public class Test1116 {

    public int[] exclusiveTime(int n, List<String> logs) {
        // write your code here
        int[] result = new int[n];
        Stack<Task> stack = new Stack<>();
        for (String log : logs) {
            Task cur = new Task(log);
            if (cur.isFinished) {
                Task pre = stack.pop();
                int time = cur.time - pre.time;
                result[pre.id] += time;
                if (!stack.isEmpty()) {
                    result[stack.peek().id] -= time;
                }
                continue;
            }
            stack.push(cur);
        }
        return result;
    }

    class Task {
        int id, time;
        boolean isFinished;
        Task(String log) {
            String[] strings = log.split(":");
            this.id = Integer.parseInt(strings[0]);
            this.isFinished = !strings[1].equals("start");
            this.time = Integer.parseInt(strings[2]);
        }
    }
}
