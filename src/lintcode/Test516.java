package lintcode;

/**
 * @author Legend
 * @data by on 18-8-18.
 * @description paint-house-ii
 * idea:
 *      dp 在i的基础上　这里变成了颜色为ｋ种 很自然的 还是i的方法 但这里有k种颜色
 *      所以每遍历到一个房子都需要计算与前一个房子k种颜色的组合 这样的话时间复杂
 *      度就是O(n^3) 然而题目中说了挑战O(NK)的复杂度 这里就需要好好想想了
 *      观察一下题目可以发现 每次染色时只要与前面的颜色不相同 于是就可以来记录前一个
 *      房子染色所需花费最小的两个值 为什么需要两个值？因为后面那所房子可能会出现染色
 *      花费代价最小的与前一个最小的是同一种颜色 所以出现同一种颜色的情况下 就取次小的
 *      这里是颜色是按索引来的 所以记录前一个花费最小的索引. 这里实现时还有可以优化的
 *      实际改变的只有最小的两个值 与位置无关 因为遍历顺序就是按位置来的 所以只需要用几个
 *      常数来记录preMin, preSec, preIndex即可 最后时间复杂度O(NK) 空间复杂度O(1)
 */
public class Test516 {

    public int minCostII(int[][] costs) {
        // write your code here
        if (costs==null || costs.length==0) return 0;
        int n = costs.length, k = costs[0].length;
        int preMin = 0, preSec = 0, preIndex = -1;
        for (int i=0;i<n;i++) {
            int curSec=Integer.MAX_VALUE, curMin=Integer.MAX_VALUE;
            int curIndex = -1;
            for (int j=0;j<k;j++) {
                costs[i][j] = costs[i][j] + (preIndex!=j?preMin: preSec);
                if (costs[i][j]<curMin) {
                    curSec = curMin;
                    curMin = costs[i][j];
                    curIndex = j;
                } else if (costs[i][j]<curSec) {
                    curSec = costs[i][j];
                }
            }
            preSec = curSec;
            preMin = curMin;
            preIndex = curIndex;
        }
        return preMin;
    }
}
