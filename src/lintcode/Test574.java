package lintcode;

/**
 * @author Legend
 * @data by on 19-5-11.
 * @description build-post-office
 * idea:
 *      这题直接用bfs会超时 有一个规律比较重要,题目是求曼哈顿距离 每个点 到每一行或每一列的距离是固定的
 *      假设 点(3,2)为0 那么到第2行所有点x的距离其实都是1(3-2), 因为它们横坐标都是2
 *      同理到第1行所有点距离都是2(3-1); 然后再看纵坐标，同理 到每一列的距离也是固定的.
 *      所以只需要 1.统计每行和每列1的个数
 *               2. 计算每个0位置到每行每列的距离和 也就是sum(|k-i|*row[k]) + sum(|o-j|*column[o]);
 *               3.最后每个距离比较 取最小值
 */
public class Test574 {

    public int shortestDistance(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] row = new int[m];
        int[] column = new int[n];
        for (int i = 0;i < m;i++) {
            for (int j = 0;j < n;j++) {
                if (grid[i][j] == 1) {
                    row[i]++;
                    column[j]++;
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0;i < m;i++) {
            for (int j = 0;j < n;j++) {
                if (grid[i][j] == 0) {
                    int sum = 0;
                    for (int k = 0;k < m;k++) {
                        sum += Math.abs(k-i) * row[k];
                    }
                    for (int o = 0;o < n;o++) {
                        sum += Math.abs(o-j) * column[o];
                    }
                    min = Math.min(min, sum);
                }
            }
        }
        return min;
    }
}
