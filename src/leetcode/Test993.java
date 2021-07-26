package leetcode;

import lintcode.TreeNode;

/**
 * @author Legend
 * @data by on 21-5-17.
 * @description https://leetcode-cn.com/problems/cousins-in-binary-tree/
 */
public class Test993 {

    int hx, hy;
    TreeNode px, py;
    public boolean isCousins(TreeNode root, int x, int y) {
        dfs(null, root, 0, x, y);
        return hx == hy && px != py;
    }

    private void dfs(TreeNode parent, TreeNode root, int h, int x, int y) {
        if (root == null) return;
        if (root.val == x) {
            hx = h; px = parent;
            return;
        }
        if (root.val == y) {
            hy = h; py = parent;
            return;
        }
        dfs(root, root.left, h + 1, x, y);
        dfs(root, root.right, h + 1, x, y);
    }
}
