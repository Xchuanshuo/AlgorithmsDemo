package leetcode.blicp57;

/**
 * @author Legend
 * @data by on 21-6-27.
 * @description https://leetcode-cn.com/problems/optimal-division/
 */
public class Test553 {

    public String optimalDivision(int[] nums) {
        int n = nums.length;
        if (n == 1) return String.valueOf(nums[0]);
        if (n == 2) return String.format("%d/%d", nums[0], nums[1]);
        StringBuilder sb = new StringBuilder();
        sb.append(nums[0]).append("/").append("(");
        for (int i = 1;i < n;i++) sb.append(nums[i]).append("/");
        sb.deleteCharAt(sb.toString().length() - 1);
        sb.append(")");
        return sb.toString();
    }
}
