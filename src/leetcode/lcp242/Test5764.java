package leetcode.lcp242;

/**
 * @author Legend
 * @data by on 21-5-23.
 * @description
 */
public class Test5764 {

    public int minSpeedOnTime(int[] dist, double hour) {
        int l = 1, r = (int) 1e7;
        while (l <= r) {
            int mid = l + (r-l)/2;
            if (!canFinish(dist, mid, hour)) {
                l = mid + 1;
            } else {
                if (mid == 1 || !canFinish(dist,mid - 1, hour)) {
                    return mid;
                } else {
                    r = mid - 1;
                }
            }
        }
        return -1;
    }

    private boolean canFinish(int[] dist, int speed, double hour) {
        double total = 0;
        for (int i = 0;i < dist.length;i++) {
            double cur = 1.0*dist[i]/speed;
            if (i != dist.length - 1) {
                total += Math.ceil(cur);
            } else {
                total += cur;
            }
        }
        return total <= hour;
    }

    public static void main(String[] args) {
        Test5764 test = new Test5764();
        int[] dist = {1,3,2};
        double hour = 1.9;
        int res = test.minSpeedOnTime(dist, hour);
        System.out.println(res);
    }
}
