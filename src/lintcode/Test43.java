package lintcode;

/**
 * @author Legend
 * @data by on 18-8-28.
 * @description maximum-subarray-iii
 * idea:
 *      dp 这道题比较偏 这里需要用两个数组来进行操作 分别表示不同的状态
 *     localMax[i][j] 表示i个元素分成k组 包含第i个数的最大子数组和是多少
 *     globalMax[i][j] 表示i个元素分成k组 可以不包含i的情况下 数组最大的和
 *     对于localMax[i][j] 有两种情况 因为是必须包含第i个数 所以 可以是localMax前面的
 *     i-1个数已经分成j组的情况 直接再把当前元素放进去即可 还一种情况是假设global前面
 *     第i-1个数丢掉一个组 把当前的数加进去变成新的组 所以得到状态转移方程
 *     localMax[i][j] = max(localMax[i-1][j], globalMax[i-1][j-1]]
 *     对于globalMax就是直接看如果取当前元素值是不是变大了，状态转移方程为
 *     globalMax[i][j] = max(localMax[i][j], globalMax[i-1][j])
 */
public class Test43 {

    public int maxSubArray(int[] nums, int k) {
        // write your code here
        int n = nums.length;
        int[][] localMax = new int[n+1][k+1];
        int[][] globalMax = new int[n+1][k+1];
        for (int j=1;j<=k;j++) {
            localMax[j-1][j] = Integer.MIN_VALUE;
            for (int i=j;i<=n;i++) {
                localMax[i][j] = Math.max(localMax[i-1][j], globalMax[i-1][j-1])+nums[i-1];
                if (i == j) {
                    globalMax[i][j] = localMax[i][j];
                } else {
                    globalMax[i][j] = Math.max(localMax[i][j], globalMax[i-1][j]);
                }
            }
        }
        return globalMax[n][k];
    }
}
