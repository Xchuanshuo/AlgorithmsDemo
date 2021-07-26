package leetcode;

/**
 * @author Legend
 * @data by on 21-5-5.
 * @description https://leetcode-cn.com/problems/stone-game-iii/
 * idea:
 *      dfs + 记忆化搜索
 *      每次保证对手取得的分数尽可能小, 则当前的分数才能较大
 *      结果: 先手的最大的分数 - 对手最小的分数
 */
public class Test1406 {

    int res = 0;
    public String stoneGameIII(int[] stones) {
        int n = stones.length;
        int[] sum = new int[n+1];
        for (int i = n - 1;i >= 0;i--) {
            sum[i] = sum[i+1] + stones[i];
        }
        int[] mem = new int[n];
        dfs(0, sum, mem);
        if (res == 0) return "Tie";
        return res > 0 ? "Alice" : "Bob";
    }

    private int dfs(int l, int[] sum, int[] mem) {
        if (l >= mem.length) return 0;
        if (mem[l] != 0) return mem[l];
        int r = Math.min(l + 3, mem.length);
        int min = (int)1e9 + 7;
        for (int i = l;i < r;i++) {
            min = Math.min(min, dfs(i + 1, sum, mem));
        }
        int d = sum[l] - min;
        res = d - min;
        return mem[l] = d;
    }
}
