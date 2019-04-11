package lintcode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Legend
 * @data by on 19-4-10.
 * @description closest-binary-search-tree-value-ii
 */
public class Test901 {

    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        // write your code here
        List<Integer> result = new LinkedList<>();
        dfs(root, target, k, (LinkedList<Integer>) result);
        return result;
    }

    private void dfs(TreeNode root, double target, int k, LinkedList<Integer> result) {
        if (root == null) return;
        dfs(root.left, target, k, result);
        if (result.size() < k) {
            result.add(root.val);
        } else if (Math.abs(root.val - target) < Math.abs(result.getFirst() - target)) {
            result.removeFirst();
            result.add(root.val);
        }
        dfs(root.right, target, k, result);
    }
}
