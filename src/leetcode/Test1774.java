package leetcode;

import java.util.Arrays;

/**
 * @author Legend
 * @data by on 21-6-1.
 * @description https://leetcode-cn.com/problems/can-you-eat-your-favorite-candy-on-your-favorite-day/
 */
public class Test1774 {

    public boolean[] canEat1(int[] candies, int[][] queries) {
        int m = candies.length;
        int n = queries.length;
        long[] sums = new long[m+1];
        for (int i = 0;i < candies.length;i++) sums[i+1] = sums[i] + candies[i];
        boolean[] ans = new boolean[n];
        for (int i = 0;i < n;i++) {
            long type = queries[i][0] + 1, days = queries[i][1];
            long max = queries[i][2];
            int left = canEat(sums, days+1);
            int right = canEat(sums, (days+1)*max);
            if (days+1 <= sums[m]  && type >= left && type <= right) ans[i] = true;
        }
        return ans;
    }

    public boolean[] canEat(int[] candies, int[][] queries) {
        int m = candies.length;
        int n = queries.length;
        long[] sums = new long[m+1];
        for (int i = 0;i < candies.length;i++) sums[i+1] = sums[i] + candies[i];
        boolean[] ans = new boolean[n];
        for (int i = 0;i < n;i++) {
            int type = queries[i][0], days = queries[i][1];
            long max = queries[i][2];
            long lNo = days + 1;
            long rNo = (days + 1) * max;
            ans[i] = (rNo > sums[type] && lNo <= sums[type+1]);
        }
        return ans;
    }

    private int canEat(long[] sums, long target) {
        int l = 1, r = sums.length - 1;
        while (l <= r) {
            int mid = l + (r-l)/2;
            if (sums[mid] < target) {
                l = mid + 1;
            } else {
                if (mid == 0 || sums[mid-1] < target) return mid;
                r = mid - 1;
            }
        }
        return r;
    }
    public static void main(String[] args) {
        Test1774 test = new Test1774();
        int[] candies = {7,4,5,3,8};
        int[][] queries = {{0,2,2}, {4,2,4}, {2,13, 1000000000}};
        boolean[] res = test.canEat(candies, queries);
        System.out.println(Arrays.toString(res));
    }
}
