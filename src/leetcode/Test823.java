package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Legend
 * @data by on 21-7-10.
 * @description https://leetcode-cn.com/problems/binary-trees-with-factors/
 * idea:
 *      计算以任何整数为根节点的情况，需要满足 左右节点乘积的数值等于根节点
 *      最后累计所有节点为根节点的二叉树数量
 */
public class Test823 {

    public int numFactoredBinaryTrees(int[] arr) {
        Arrays.sort(arr);
        int M = (int) 1e9 + 7;
        Map<Integer, Long> dp = new HashMap<>();
        for (int a : arr) dp.put(a, 1L);
        for (int i = 0;i < arr.length;i++) {
            int cur = arr[i];
            long cnt = 0;
            for (int j = i - 1;j >= 0;j--) {
                int t = cur/arr[j];
                if (cur%arr[j] == 0 && dp.containsKey(t)) {
                    cnt += dp.get(arr[j]) * dp.get(t);
                }
            }
            dp.put(cur, dp.get(cur) + cnt);
        }
        long res = 0;
        for (long v : dp.values()) res += v;
        return (int) (res%M);
    }
}
