package lintcode;

import java.util.*;

/**
 * @author Legend
 * @data by on 18-8-8.
 * @description subsets-ii
 */
public class Test18 {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // write your code here
        Set<List<Integer>> set = new HashSet<>();
        Arrays.sort(nums);
        helper(nums, 0, new ArrayList<>(), set);
        List<List<Integer>> result = new ArrayList<>(set);
        return result;
    }

    // 递归写法
    private void helper(int[] nums, int index, List<Integer> list, Set<List<Integer>> set) {
        set.add(new ArrayList<>(list));
        for (int i=index;i<nums.length;i++) {
            if (list.size()==0 || nums[i] >= list.get(list.size()-1)) {
                list.add(nums[i]);
                helper(nums, i+1, list, set);
                list.remove(list.size()-1);
            }
        }
    }

    // 非递归
    private void dfs(int[] nums, List<List<Integer>> result) {
        result.add(new ArrayList<>());
        int start = 0;
        for (int i=0;i<nums.length;i++) {
            int len = result.size();
            for (int j=start;j<len;j++) {
                List<Integer> list = result.get(j);
                list.add(nums[i]);
                result.add(list);
            }
            if (nums[i] == nums[i+1]) {
                start = len;
            } else {
                start = 0;
            }
        }
    }
}
