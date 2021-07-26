package leetcode;

/**
 * @author Legend
 * @data by on 21-5-9.
 * @description https://leetcode-cn.com/problems/minimum-number-of-days-to-make-m-bouquets/
 * idea:
 *      二分模拟 查找左边界
 */
public class Test1482 {

    public int minDays(int[] b, int m, int k) {
        int l = 1, r = (int)1e9;
        while (l <= r) {
            int mid = l + (r-l)/2;
            if (!canFinish(b, m, k, mid)) {
                l = mid + 1;
            } else {
                if (mid == l || !canFinish(b, m, k, mid - 1)) {
                    return mid;
                } else {
                    r = mid - 1;
                }
            }
        }
        return -1;
    }

    private boolean canFinish(int[] b, int m, int k, int cur) {
        int temp = 0, t = 0;
        for (int i = 0;i < b.length;i++) {
            if (b[i] <= cur) {
                temp++;
                if (temp == k) {
                    temp = 0;
                    t++;
                }
            } else {
                temp = 0;
            }
        }
        return t >= m;
    }
}
