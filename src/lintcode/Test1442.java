package lintcode;

/**
 * @author Legend
 * @data by on 18-10-7.
 * @description order-problem
 * idea:
 *      dfs 这里需要注意的是 要求不超过任意一种商品的需求 所以需要先计算出不超出的
 *      情况下最多能使用某生产模式的次数 用order[i]/pattern[id][i]即可得出
 *      若商品的需求已经达到了 那么order[i]就变为了0 那么下次选用生产模式时 肯定
 *      不能选用能够生产出商品i的生产模式了 这里使用递归来进行求解 那么
 *      终止条件就是 当几种生产模式都遍历完成
 */
public class Test1442 {

    private int result = 0;
    public int getMinRemaining(int[] order, int[][] pattern) {
        // Write your code here
        for (int i=0;i<order.length;i++) {
            result += order[i];
        }
        dfs(0, order, pattern);
        return result;
    }

    private void dfs(int id, int[] order, int[][] pattern) {
        if (id >= pattern.length) {
            int curRes = 0;
            for (int i=0;i<order.length;i++) {
                curRes += order[i];
            }
            result = Math.min(result, curRes);
            return;
        }
        int count = 10;
        for (int i=0;i<order.length;i++) {
            if (pattern[id][i] != 0) {
                count = Math.min(count, order[i]/pattern[id][i]);
            }
        }
        for (int i=0;i<=count;i++) {
            for (int j=0;j<order.length;j++) {
                order[j] -= i * pattern[id][j];
            }
            dfs(id+1, order, pattern);
            for (int j=0;j<order.length;j++) {
                order[j] += i * pattern[id][j];
            }
        }
    }
}
