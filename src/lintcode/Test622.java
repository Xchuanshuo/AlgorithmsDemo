package lintcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Legend
 * @data by on 18-9-11.
 * @description frog-jump
 * idea:
 *      类似于jump-game 不过这道题不是一开始就给出了能跳跃距离的表 而是需要根据前一次
 *      跳跃的距离去计算当前能跳的距离 这里只需要求最后能否到达终点 那么只需要记录每一个
 *      石头从上次跳来的步数 因为可以从不同的地方跳过来 所以用set来保存不同的步数 而到最后
 *      一个石头时 如果前面的石头无法到达这里 那么最后一个石头保存步数的set为空 所以只需要
 *      判断它是否为空 即可得出最后的结果
 */
public class Test622 {

    public boolean canCross(int[] stones) {
        // write your code here
        int n = stones.length;
        Set<Integer>[] steps = new Set[n];
        for (int i=0;i<n;i++) {
            steps[i] = new HashSet<>();
        }
        steps[0].add(1);
        for (int i=1;i<n;i++) {
            for (int j=0;j<i;j++) {
                int dist = stones[i] - stones[j];
                if (steps[j].contains(dist)) {
                    steps[i].add(dist-1);
                    steps[i].add(dist);
                    steps[i].add(dist+1);
                }
            }
        }
        return !steps[n-1].isEmpty();
    }
}
