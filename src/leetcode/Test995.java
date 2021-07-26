package leetcode;

/**
 * @author Legend
 * @data by on 21-7-11.
 * @description https://leetcode-cn.com/problems/minimum-number-of-k-consecutive-bit-flips/
 * idea:
 *      一个位置只有被操作奇数次时才会改变，所以只操作1次将会获得最小次数
 *      所以可以记录每个位置的操作次数, 使用差分数组
 */
public class Test995 {

    public int minKBitFlips(int[] nums, int k) {
        int n = nums.length;
        int[] dif = new int[n+1];
        int sum = 0,res = 0;
        for (int i = 0;i < n;i++) {
            sum += dif[i];
            if ((sum + nums[i])%2 == 0) {
                if (i + k > n) return -1;
                dif[i] += 1;
                res++;
                sum++;
                dif[i+k] -= 1;
            }
        }
        return res;
    }
}
