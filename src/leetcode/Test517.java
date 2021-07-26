package leetcode;

/**
 * @author Legend
 * @data by on 21-6-19.
 * @description https://leetcode-cn.com/problems/super-washing-machines/
 * idea:
 *      贪心, 求最小操作次数 -> 移动过程中需要的最大衣物数量
 *      1.首先计算出每个机器需要的平均衣物数
 *      2.然后算出每个机器还需要被移入需要的衣物数 负数表示还需要几件 正数表示需要移出几件
 *      3.基于2的结果, 可以去比较 当前洗衣机的绝对值, 相邻洗衣机的值;
 *       若相邻洗衣机差值数组的符号相同, 则需要的最大数量是两者相加的绝对值
 *       若相邻洗衣机差值数组符号不同, 则相当于可以直接从相邻的洗衣机去拿
 *       两者直接相加 才是需要移动的次数
 */
public class Test517 {

    public int findMinMoves(int[] machines) {
        int sum = 0, n = machines.length;
        for (int m : machines) sum += m;
        if (sum%n !=  0) return -1;
        int avg = sum / n;
        int[] helper = new int[n];
        for (int i = 0;i < n;i++) {
            helper[i] =  machines[i] - avg;
        }
        int res = Integer.MIN_VALUE;
        for (int i = 0;i < n - 1;i++) {
            res = Math.max(res, Math.abs(helper[i]));
            res = Math.max(res, helper[i+1]);
            helper[i+1] += helper[i];
        }
        return Math.max(res, helper[n-1]);
    }
}
