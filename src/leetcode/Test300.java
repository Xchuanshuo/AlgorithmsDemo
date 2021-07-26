package leetcode;

/**
 * @author Legend
 * @data by on 21-4-13.
 * @description https://leetcode-cn.com/problems/longest-increasing-subsequence/
 * idea:
 *      LIS二分查找解法
 */
public class Test300 {

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        int[] arr = new int[n+1];
        int len = 1;
        arr[0] = nums[0];
        for (int i = 1;i < n;i++) {
            if (nums[i] > arr[len-1]) {
                arr[len] = nums[i];
                len++;
            } else {
                // 查找第一个大于等于给定值的元素, 保证在满足最大递增的情况下
                // 使前面的元素更加小, 后面就有更大的几率将最长递增子序列变得更加长
                int pos = findRight(arr, len - 1, nums[i]);
                arr[pos] = nums[i];
            }
        }
        return len;
    }

    private int findRight(int[] arr, int end, int t) {
        int l = 0, r = end;
        while (l <= r) {
            int mid = l + (r-l)/2;
            if (arr[mid] < t) {
                l = mid + 1;
            } else {
                if (mid == l || arr[mid-1] < t) return mid;
                r = mid - 1;
            }
        }
        return end;
    }
}
