package leetcode;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author Legend
 * @data by on 21-4-26.
 * @description https://leetcode-cn.com/problems/maximum-number-of-eaten-apples/
 * idea:
 *      模拟法 使用堆 按过期时间从小到大排序
 */
public class Test1705 {

    public int eatenApples(int[] apples, int[] days) {
        Queue<int[]> q = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        int res = 0, i = 0;
        for (i = 0;i < apples.length;i++) {
            int cnt = apples[i];
            int day = i + days[i];
            if (cnt >= 1) {
                q.offer(new int[]{cnt, day});
            }
            boolean flag = false;
            while (!q.isEmpty()) {
                int[] eat = q.poll();
                if (eat[1] > i) {
                    res++; eat[0]--;
                    if (eat[0] > 0) q.offer(eat);
                    flag = true;
                }
                if (flag) break;
            }
        }
        while (!q.isEmpty()) {
            int[] eat = q.poll();
            if (eat[1] > i) {
                i++; res++;
                eat[0]--;
                if (eat[0] > 0) q.offer(eat);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] apples = {3,0,0,0,0,2};
        int[] days = {3,0,0,0,0,2};
        Test1705 test = new Test1705();
        int res = test.eatenApples(apples, days);
        System.out.println(res);
    }
}
