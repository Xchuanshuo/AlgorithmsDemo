package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Legend
 * @data by on 21-5-15.
 * @description https://leetcode-cn.com/problems/push-dominoes/
 * idea:
 *      模拟法 使用bfs来模拟该操作, 当前是L则左移1步, 当前是R则右移动一步
 *      记录到每个点时一共走了多少步, 如果到一个位置花费的步数与当前位置走到后的的步数相等
 *      说明之前有一个相反方向的也走到了这里 此时应当将该位置变为. 表示受力平衡
 */
public class Test838 {

    public String pushDominoes(String dominoes) {
        char[] d = dominoes.toCharArray();
        int[] dirs = new int[128];
        int[] step = new int[d.length];
        dirs['R'] = 1; dirs['L'] = -1;
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0;i < d.length;i++) {
            if (d[i] != '.') {
                q.offer(i);
                step[i] = 1;
            }
        }
        while (!q.isEmpty()) {
            int cur = q.poll();
            if (d[cur] == '.') continue;
            int next = cur + dirs[d[cur]];
            if (next < 0 || next >= d.length) continue;
            if (step[next] == 0) {
                step[next] = step[cur] + 1;
                d[next] = d[cur];
                q.offer(next);
            } else if (step[next] == step[cur] + 1) {
                d[next] = '.';
            }
        }
        return new String(d);
    }
}
