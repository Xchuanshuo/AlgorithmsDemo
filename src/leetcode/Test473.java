package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Legend
 * @data by on 21-6-25.
 * @description https://leetcode-cn.com/problems/matchsticks-to-square/
 * idea:
 *      状态压缩 使用二进制位来保存某个排列是否已经被选择过
 */
public class Test473 {

    public boolean makesquare(int[] sticks) {
        int total = 0;
        for (int m : sticks) total += m;
        if (total%4 != 0) return false;
        int len = total / 4;
        int[] boxes = new int[4];
        Arrays.fill(boxes, len);
        int state = 0;
        return dfs(sticks, boxes, state, 0);
    }

    Map<Integer, Boolean> map = new HashMap<>();
    private boolean dfs(int[] sticks, int[] boxes, int state, int cur) {
        if (map.containsKey(state)) return map.get(state);
        if (boxes[cur] < 0) return false;
        if (boxes[cur] == 0) cur++;
        if (cur > 3) return true;
        boolean res = false;
        for (int i = 0;i < sticks.length;i++) {
            if ((state & (1<<i)) >= 1) continue;
            state |= 1 << i;
            boxes[cur] -= sticks[i];
            res = dfs(sticks, boxes, state, cur);
            map.put(state, res);
            if (res) break;
            boxes[cur] += sticks[i];
            state &= ~(1<<i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] sticks = {5,5,5,5,16,4,4,4,4,4,3,3,3,3,4};
        Test473 test = new Test473();
        System.out.println(test.makesquare(sticks));
    }
}
