package lintcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Legend
 * @data by on 19-11-12.
 * @description path-sum-ii
 */
public class Test1357 {

    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        // Write your code here.
        helper(root, sum,  new ArrayList<>());
        return result;
    }

    private void helper(TreeNode root, int sum, List<Integer> list) {
        if (root == null || root.val > sum) return;
        list.add(root.val);
        if (sum == root.val) {
            if (isLeaf(root)) result.add(new ArrayList<>(list));
        } else {
            helper(root.left, sum - root.val, list);
            helper(root.right, sum - root.val, list);
        }
        list.remove(list.size() - 1);
    }

    private boolean isLeaf(TreeNode root) {
        return root.left == null && root.right == null;
    }
}
