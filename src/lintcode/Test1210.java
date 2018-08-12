package lintcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Legend
 * @data by on 18-8-8.
 * @description increasing-subsequences
 */
public class Test1210 {

    public List<List<Integer>> findSubsequences(int[] nums) {
        // Write your code here
        Set<List<Integer>> set = new HashSet<>();
        helper(nums, 0, new ArrayList<>(), set);
        List<List<Integer>> result = new ArrayList<>(set);
        return result;
    }

    private void helper(int nums[], int index, List<Integer> list,Set<List<Integer>> result) {
        if (list.size() >= 2) result.add(new ArrayList<>(list));
        for (int i=index;i<nums.length;i++) {
            if (list.size()==0 || nums[i]>=list.get(list.size()-1)) {
                list.add(nums[i]);
                helper(nums, i+1, list, result);
                list.remove(list.size()-1);
            }
        }
    }
}
