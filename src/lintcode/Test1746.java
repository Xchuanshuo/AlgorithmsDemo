package lintcode;

/**
 * @author Legend
 * @data by on 19-11-7.
 * @description minimum-distance-between-bst-nodes
 */
public class Test1746 {

    int pre = Integer.MIN_VALUE, cur, res = Integer.MAX_VALUE;
    public int minDiffInBST(TreeNode root) {
        // Write your code here.
        inOrder(root);
        return res;
    }

    public void inOrder(TreeNode root) {
        if (root == null) return;
        inOrder(root.left);
        cur = root.val;
        res = Math.min(Math.abs(cur - pre), res);
        pre = cur;
        inOrder(root.right);
    }
}
