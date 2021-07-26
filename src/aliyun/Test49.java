package aliyun;

/**
 * @author Legend
 * @data by on 21-4-5.
 * @description https://developer.aliyun.com/coding/49
 */
public class Test49 {

    public int solution(int n, int[] nums) {
        if (nums[n-1] <= 50000) return nums[n-1]-1;
        if (nums[0] > 50000) return 100000 - nums[0];
        int l = 0, r = n-1;
        while(l < r) {
            int mid = l + (r-l)/2;
            if (nums[mid] > 50000) {
                r = mid;
            } else if (nums[mid] < 50000) {
                l = mid + 1;
            } else {
                return 49999;
            }
        }
        return Math.max(nums[l-1] - 1, 100000 - nums[r] ) ;
    }
}
