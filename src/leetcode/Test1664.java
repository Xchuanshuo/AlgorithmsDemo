package leetcode;

/**
 * @author Legend
 * @data by on 21-5-28.
 * @description https://leetcode-cn.com/problems/ways-to-make-a-fair-array/
 */
public class Test1664 {

    public int waysToMakeFair(int[] nums) {
        int n = nums.length;
        if (n == 1) return 1;
        int[] odd = new int[n];
        int[] even = new int[n];
        for (int i = 1;i < n;i+=2) {
            if (i==1) odd[i] = nums[i];
            else odd[i] = odd[i-2] + nums[i];
        }
        for (int i = 0;i < n;i+=2) {
            if (i==0) even[i] = nums[i];
            else even[i] = even[i-2] + nums[i];
        }
        int res = 0;
        int r1 = (n%2==0 ? n-1 : n-2); // 奇数
        int r2 = (n%2==0 ? n-2 : n-1); // 偶数
        for (int i = 0;i  < n;i++) {
            if (i%2 == 0) {
                int preO = (i == 0 ? 0 : odd[i-1]);
                int preE = even[i] - nums[i];
                int o = preO + even[r2] - even[i];
                int e = preE + odd[r1] - (i == 0 ? 0 : odd[i-1]);
                if (o == e) res++;
            } else {
                int preO = odd[i] - nums[i];
                int preE = even[i-1];
                int o = preO + even[r2] - even[i-1];
                int e = preE + odd[r1] - odd[i];
                if (o == e) res++;
            }
        }
        return res;
    }
}
