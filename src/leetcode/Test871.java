package leetcode;


import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author Legend
 * @data by on 21-4-25.
 * @description https://leetcode-cn.com/problems/minimum-number-of-refueling-stops/
 * idea:
 *      解法1: 回溯 超时
 *      解法2: 动态规划 用dp[i][j]表示前i个加油站, 加了j次油 此时的最大油量为多少
 *             状态: 对于第i个加油站 要么加油 要么不加油
 *           加油: dp[i][j] = dp[i-1][j] 直接从前i-1个车站 加了j次油的状态转移过来
 *           不加油 dp[i][j] = dp[i-1][j-1] + stations[i][1] 表示前i-1个车站加了j-1次油的最大油量 + 当前加油量
 *           两者取max, 是否选择加油 应当满足的前提条件为 能正常到达该车站 即前面i-1个车站的最大油量能>=当前的位置
 *           初始条件: 经过任意车站不加油 最大油量为初始油量
 *           优化: 类似背包问题, 每一次的状态只依赖于上一轮的选择 空间复杂度优化到O(n) 计算时需要从后往前
 *
 *     解法3: 优先队列+贪心 当前总油量 >= 车站位置 继续往后走, 小于则从前面经过的车站的油量取最大值
 *            (换个思路 把加油站的油量看成一桶油 每经过一个车站 就把这个桶带上 没有油了取一个桶加油
 *             问 至少需要几桶油? 每次取油量最大的桶即可)
 *            取完之后还是不能到达目标位置 则说明无法到达 返回-1
 */
public class Test871 {

    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        if (stations.length == 0) {
            if (startFuel >= target) return 0;
            else return -1;
        }
        int m = stations.length;
        long[] dp = new long[m+1];
        for (int i = 0;i <= m;i++) {
            dp[i] = startFuel;
        }
        for (int i = 1;i <= m;i++) {
            for (int j = i;j >= 1;j--) {
                int cur = stations[i-1][0];
                if (dp[j-1] >= cur) {
                    dp[j] = Math.max(dp[j], dp[j-1] + stations[i-1][1]);
                }
            }
        }
        for (int i = 0;i <= m;i++) {
            if (dp[i] >= target) {
                return i;
            }
        }
        return -1;
    }

    public int minRefuelStops3(int target, int startFuel, int[][] stations) {
        int n = stations.length;
        if (n == 0) {
            if (startFuel >= target) return 0;
            return -1;
        }
        int sum = startFuel, res = 0;
        Queue<int[]> q = new PriorityQueue<>((o1, o2) -> o2[1] - o1[1]);
        for (int i = 0;i < n;i++) {
            while (sum < stations[i][0]) {
                int[] val = q.poll();
                if (val == null) return -1;
                sum += val[1];
                res++;
            }
            q.offer(stations[i]);
        }
        while (sum < target) {
            int[] val = q.poll();
            if (val == null) return -1;
            sum += val[1];
            res++;
        }
        return res;
    }


    // 回溯 超时
    private int min = Integer.MAX_VALUE;
    public int minRefuelStops1(int target, int startFuel, int[][] stations) {
        helper(target, startFuel, stations, 0, 0, -1);
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    private void helper(int target, int curTotal, int[][] stations,
                        int pos, int cnt, int last) {
        if (last != -1) curTotal = curTotal + stations[last][0];
        if (curTotal >= target) {
            min = Math.min(min, cnt);
            return;
        }
        for (int i = pos;i < stations.length;i++) {
            if (curTotal >= stations[i][0]) {
                int cur = curTotal - stations[i][0] + stations[i][1];
                helper(target, cur , stations, i + 1, cnt+1, i);
            }
        }
    }

    public static void main(String[] args) {
        int t = 100, startFuel = 10;
        int[][] stations = {{10, 60}, {20, 30}, {30, 30}, {60, 40}};
        Test871 test = new Test871();
        int res = test.minRefuelStops(t, startFuel, stations);
        System.out.println(res);
    }
}
