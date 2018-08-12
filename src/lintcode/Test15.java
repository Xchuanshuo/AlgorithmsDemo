package lintcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Legend
 * @data by on 18-8-11.
 * @description permutations
 */
public class Test15 {

    private List<List<Integer>> result;
    public List<List<Integer>> permute(int[] nums) {
        // write your code here
        result = new ArrayList<>();
        if (nums==null || nums.length==0) {
            result.add(new ArrayList<>());
            return result;
        }
        helper(nums, new boolean[nums.length], new ArrayList<>());
        return result;
    }

    private void helper(int[] nums, boolean[] visited, List<Integer> list) {
        if (list.size() == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i=0;i<nums.length;i++) {
            if (!visited[i]) {
                visited[i] = true;
                list.add(nums[i]);
                helper(nums, visited, list);
                visited[i] = false;
                list.remove(list.size()-1);
            }
        }
    }
}
