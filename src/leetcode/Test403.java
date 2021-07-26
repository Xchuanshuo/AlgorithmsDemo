package leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @author Legend
 * @data by on 21-4-29.
 * @description https://leetcode-cn.com/problems/frog-jump/
 * idea:
 *      解法1 bfs 基于到达每一个石子的位置 以及花费的步骤k, 决定下一步
 *           所能到达的位置, 考虑所有情况, 如果能到达最后一块石子 则青蛙能过河
 *
 *      解法2 dp dp[i]表示对于位置i 青蛙是否能到达,要到达i 枚举i前面的所有位置j
 *           j如果能到达,在看到达j的步数k 根据步数就可以判断是否能到达位置i
 *           到达位置i的所有不同步数都保存下来 用作后续的判断
 */
public class Test403 {

    public boolean canCross(int[] stones) {
        int n = stones.length;
        for (int i = 1;i < n;i++) {
            if (stones[i] - stones[i-1] > i) return false;
        }
        boolean[] dp = new boolean[n];
        Set<Integer>[] sets = new Set[n];
        for (int i = 0;i < n;i++) {
            sets[i] = new HashSet<>();
        }
        dp[0] = true;
        for (int i = 1;i < n;i++) {
            for (int j = i-1;j >= 0;j--) {
                if (!dp[j]) continue;
                for (int k : sets[j]) {
                    if (Math.abs(stones[i] + k - stones[j]) <= 1) {
                        dp[i] = true;
                        sets[i].add(stones[i] - stones[j]);
                    }
                }
            }
        }
        return dp[n-1];
    }

    public boolean canCross1(int[] stones) {
        int n = stones.length;
        Set<Integer> set = new HashSet<>();
        for (int i = 1;i < stones.length;i++) {
            if (stones[i] - stones[i-1] > i) return false;
            set.add(stones[i]);
        }
        Set<String> visited = new HashSet<>();
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{1,1});
        while (!q.isEmpty()) {
            int[] val = q.poll();
            for (int k = val[1] - 1; k <= val[1] + 1; k++) {
                int next = val[0] + k;
                if (next == stones[n-1]) return true;
                String hash = next + "_" + k;
                if (!visited.contains(hash) && set.contains(next)) {
                    visited.add(hash);
                    q.offer(new int[]{next, k});
                }
            }
        }
        return false;
    }
}
