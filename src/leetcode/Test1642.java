package leetcode;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author Legend
 * @data by on 21-4-26.
 * @description https://leetcode-cn.com/problems/furthest-building-you-can-reach/
 * idea:
 *      堆 + 贪心 优先使用梯子 梯子不够 将较小的高度差使用砖块 砖块小于0则不能继续走了
 */
public class Test1642 {

    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        int l = 0;
        Queue<Integer> q = new PriorityQueue<>();
        while (l < heights.length - 1) {
            if (heights[l] >= heights[l+1]) {
                l++;
            } else {
                int d = heights[l+1] - heights[l];
                q.offer(d);
                if (q.size() > ladders) bricks -= q.poll();
                if (bricks < 0) return l;
                l++;
            }
        }
        return l;
    }
}
