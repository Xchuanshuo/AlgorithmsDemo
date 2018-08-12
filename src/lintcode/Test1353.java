package lintcode;

/**
 * @author Legend
 * @data by on 18-8-12.
 * @description sum-root-to-leaf-numbers
 */
public class Test1353 {

    int result = 0;
    public int sumNumbers(TreeNode root) {
        // write your code here
        helper(root, 0);
        return result;
    }

    private void helper(TreeNode root, int val)  {
        val = val*10 + root.val;
        if (root.left==null && root.right==null) {
            result += val;
            return;
        }
        if (root.left != null) {
            helper(root.left, val);
        }
        if (root.right != null) {
            helper(root.right, val);
        }
    }
}
