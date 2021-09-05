package leetcode;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Legend
 * @data by on 21-9-4.
 * @description https://leetcode-cn.com/problems/cracking-the-safe/
 * idea:
 *      以n-1位数组成的序列作为节点, [0,k-1]作为边 找到一条欧拉路径
 */
public class Test753 {

    int k = 0;
    public String crackSafe(int n, int k) {
        int h = (int)Math.pow(10, n-1);
        this.k = k;
        StringBuilder sb = new StringBuilder();
        dfs(0, h, sb);
        for (int i = 0;i < n - 1;i++) {
            sb.append('0');
        }
        return sb.toString();
    }

    Set<Integer> set = new HashSet<>();
    private void dfs(int cur, int h, StringBuilder sb) {
        for (int i = 0;i < k;i++) {
            int val = cur * 10 + i;
            if (set.contains(val)) continue;
            set.add(val);
            dfs(val%h, h, sb);
            sb.append(i);
        }
    }
}
