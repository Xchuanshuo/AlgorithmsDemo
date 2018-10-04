package lintcode;

/**
 * @author Legend
 * @data by on 18-10-4.
 * @description minimum-sum-path
 */
public class Test1482 {

    public int minimumSum(TreeNode root) {
        // Write your code here
        if (root.left == null && root.right == null) {
            return root.val;
        }
        int value = Integer.MAX_VALUE;
        if (root.left != null) {
            value = Math.min(value, minimumSum(root.left));
        }
        if (root.right != null) {
            value = Math.min(value, minimumSum(root.right));
        }
        return root.val + value;
    }
}
