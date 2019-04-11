package lintcode;

/**
 * @author Legend
 * @data by on 19-4-10.
 * @description closest-binary-search-tree-value
 */
public class Test900 {

    public int closestValue(TreeNode root, double target) {
        int cur = root.val;
        TreeNode kid = target < cur ? root.left : root.right;
        if (kid == null) return cur;
        int a = closestValue(kid, target);
        return Math.abs(target - cur) < Math.abs(target - a) ? cur : a;
    }
}
