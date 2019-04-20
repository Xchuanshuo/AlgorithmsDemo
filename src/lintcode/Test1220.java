package lintcode;

/**
 * @author Legend
 * @data by on 19-4-20.
 * @description matchsticks-to-square
 */
public class Test1220 {

    public boolean makesquare(int[] nums) {
        // Write your code here
        if (nums == null || nums.length ==0) return false;
        int sum = 0;
        for (int n : nums) sum += n;
        if (sum % 4 != 0) return false;
        int target = sum / 4;
        return dfs(nums, 0, 0, target, 0, new boolean[nums.length]);
    }

    private boolean dfs(int nums[], int l, int cur,
                        int target, int count, boolean[] used) {
        if (count == 4) {
            for (boolean u : used) {
                if (!u) return false;
            }
            return true;
        } else if (cur == target) {
            return dfs(nums, 0, 0, target, count+1, used);
        } else if (cur > target){
            return false;
        } else {
            for (int i = l;i < nums.length;i++) {
                if (!used[i]) {
                    used[i] = true;
                    cur += nums[i];
                    if (dfs(nums, l+1, cur, target, count, used)) return true;
                    cur -= nums[i];
                    used[i] = false;
                }
            }
            return false;
        }
    }
}
