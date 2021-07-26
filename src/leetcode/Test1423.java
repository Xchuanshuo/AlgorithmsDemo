package leetcode;

/**
 * @author Legend
 * @data by on 21-5-21.
 * @description https://leetcode-cn.com/problems/maximum-points-you-can-obtain-from-cards/
 * idea:
 *      维护一个滑动窗口, 找出连续的最小和
 */
public class Test1423 {

    public int maxScore(int[] cardPoints, int k) {
        int temp = 0, min = (int)1e9;
        int total = 0;
        int cnt = 0, n = cardPoints.length - k;
        for (int i = 0;i < cardPoints.length;i++) {
            total += cardPoints[i];
            if (cnt == n) {
                temp -= cardPoints[i-n]; cnt--;
            }
            if (cnt < n) {
                temp += cardPoints[i]; cnt++;
            }
            if (n != 0 && cnt == n) min = Math.min(min, temp);
        }
        if (n == 0) min = 0;
        return total - min;
    }
}
