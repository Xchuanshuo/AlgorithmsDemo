package lintcode;

/**
 * @author Legend
 * @data by on 19-4-15.
 * @description binary-tree-pruning
 */
public class Test1003 {

    public TreeNode pruneTree(TreeNode root) {
        helper(root);
        return root;
    }

    private boolean helper(TreeNode root) {
        if (root == null) return false;
        if (helper(root.left)) {
            root.left = null;
        }
        if (helper(root.right)) {
            root.right = null;
        }
        return root.left == null && root.right == null && root.val == 0;
    }
}
