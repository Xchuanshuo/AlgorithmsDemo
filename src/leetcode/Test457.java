package leetcode;

/**
 * @author Legend
 * @data by on 21-8-7.
 * @description https://leetcode-cn.com/problems/circular-array-loop/
 */
public class Test457 {

    public boolean circularArrayLoop(int[] nums) {
        int n = nums.length;
        for (int i = 0;i < n;i++) {
            boolean res = dfs(i, new boolean[n], nums, nums[i] > 0);
            if (res) return true;
        }
        return false;
    }

    private boolean dfs(int s, boolean[] visited, int[] nums, boolean positive) {
        int n = nums.length, l = 0;
        int last = nums[s];
        while (!visited[s]) {
            int next = (s +last + n) % n;
            while (next < 0) next = (next + n)%n;
            if (next == s) return false;
            if (positive) {
                if (nums[next] < 0) return false;
            } else {
                if (nums[next] > 0) return false;
            }
            l++;
            visited[s] = true;
            s = next;
            last = nums[next];
        }
        return l >= 2;
    }
}
