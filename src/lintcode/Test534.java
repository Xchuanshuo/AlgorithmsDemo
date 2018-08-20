package lintcode;

/**
 * @author Legend
 * @data by on 18-8-20.
 * @description house-robber-ii
 * idea:
 *      与house-robber(Test392)相比 变成了环状的情况 所以这里有一个trick
 *      就是把0..n拆分成0..n-1和1..n 这样就不会出现取到首尾的情况 其它的没变
 */
public class Test534 {

    public int houseRobber2(int[] nums) {
        // write your code here
        if (nums==null || nums.length==0) return 0;
        if (nums.length==1) return nums[0];
        return Math.max(robber(nums, 0, nums.length-1), robber(nums, 1, nums.length));
    }

    private int robber(int[] nums, int lo, int hi) {
        int preMax=0, curMax=0;
        for (int i=lo;i<hi;i++) {
            int temp = curMax;
            curMax = Math.max(curMax, preMax+nums[i]);
            preMax = temp;
        }
        return curMax;
    }
}
