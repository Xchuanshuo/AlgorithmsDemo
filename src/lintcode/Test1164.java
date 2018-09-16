package lintcode;

/**
 * @author Legend
 * @data by on 18-9-16.
 * @description wiggle-subsequence
 * idea:
 *      可以用动态规划 可以用贪心算法 遍历时需要维护两种情况 一种是当前值大于前一个值时
 *      那么所求序列的长度是前面一个序列最后一个是递减的情况+上当前递增的长度 即
 *      up=down+1; 同理，另一种情况就是down=up+1. 用dp也是一样的道理 只是当不满足大于
 *      或者小于的条件时 需要手动维护两种情况下的当前值
 */
public class Test1164 {

    public int wiggleMaxLength(int[] nums) {
        // Write your code here
        int up = 1, down = 1;
        for (int i=1;i<nums.length;i++) {
            if (nums[i] > nums[i-1]) {
                up = down + 1;
            } else if (nums[i] < nums[i-1]) {
                down = up + 1;
            }
        }
        return Math.max(up, down);
    }
}
