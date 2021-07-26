package leetcode.twolcp52;

import java.util.*;

/**
 * @author Legend
 * @data by on 21-5-15.
 * @description https://leetcode-cn.com/contest/biweekly-contest-52/problems/sum-of-floored-pairs/
 * idea:
 *      排序 + 二分 + hash
 */
public class Test5212 {

    int M = (int)1e9 + 7;
    public int sumOfFlooredPairs(int[] nums) {
        int n = nums.length, res = 0;
        Arrays.sort(nums);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0;i < n;i++) {
            int cur = nums[i];
            int l = i;
            int cnt = 0;
            if (map.containsKey(cur)) {
                cnt = map.get(cur);
            } else {
                int t = 1;
                while (true) {
                    int left = findLeft(nums, l, cur*t);
                    if (left == -1) break;
                    int right = findRight(nums, l, cur*(t+1) - 1);
                    cnt = (cnt + (right - left + 1) * t)%M;
                    t++;
                    l = right;
                }
            }
            map.put(cur, cnt);
            res = (res + cnt)%M;
        }
        return res;
    }

    private int findLeft(int[] nums, int l,  int target) {
        int r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r-l)/2;
            if (nums[mid] < target) {
                l = mid + 1;
            } else {
                if (mid == 0 || nums[mid-1] < target) return mid;
                r = mid - 1;
            }
        }
        return -1;
    }

    private int findRight(int[] nums, int l, int target) {
        int r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r-l)/2;
            if (nums[mid] > target) {
                r = mid - 1;
            } else {
                if (mid == r || nums[mid+1] > target) return mid;
                l = mid + 1;
            }
        }
        return r;
    }
}
