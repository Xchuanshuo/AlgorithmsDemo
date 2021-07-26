package leetcode;

/**
 * @author Legend
 * @data by on 21-5-8.
 * @description https://leetcode-cn.com/problems/beautiful-arrangement/
 * idea:
 *      解法1. 回溯
 *      解法2. 状压dp 题目是求满足要求的排列数,可以使用一个二进制数来表示状态
 *            假设二进制数i有n个1 就表示前1..n的数被放在了该二进制数中 位为1的位置
 *            接下来依次考察该二进制数中不为1的位置, 能否存放数 n+1, 设找到一个位置为j
 *            即 满足 (j+1)%(n+1)==0 || (n+1)%(j+1)==0 满足的情况下对于将当前位置
 *            j置为1的状态找到了一个新的方案 即 dp[i | 1<<j] += dp[i]
 *
 *            初始化: 对于每个只存放一个位的情况都可以放1  总的方案数为1 dp[1<<i] = 1
 *            最后结果: dp[1<<(n-1)]即所有二进制位都为1(所有位置均放了不同的数)的情况下的排列数
 */
public class Test526 {

    // 解法1
    int res = 0;
    public int countArrangement1(int n) {
        boolean[] visited = new boolean[n+1];
        helper(visited, 1,  n);
        return res;
    }

    private void helper(boolean[] visited, int pos, int n) {
        if (pos >= visited.length) {
            res++;
        }
        for (int i = 1;i <= n;i++) {
            if (!visited[i] && (pos%i==0 || i%pos == 0)) {
                visited[i] = true;
                helper(visited, pos + 1, n);
                visited[i] = false;
            }
        }
    }

    // 解法2
    public int countArrangement2(int n) {
        int[] dp = new int[1<<n];
        for (int i = 0;i < n;i++) {
            dp[1 << i] = 1;
        }
        for (int i = 1;i < (1<<n);i++) {
            int pos = count(i);
            for (int j = 0;j < n;j++) {
                if ((i&(1<<j)) != 0) continue;
                if ((j+1)%(pos+1) != 0 && (pos+1)%(j+1)!=0) continue;
                dp[i | 1<<j] += dp[i];
            }
        }
        return dp[(1<<n)-1];
    }

    private int count(int n) {
        int cnt = 0;
        while (n != 0) {
            n &= n - 1;
            cnt++;
        }
        return cnt;
    }
}
