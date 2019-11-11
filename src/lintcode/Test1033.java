package lintcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Legend
 * @data by on 19-11-10.
 * @description minimum-difference-between-bst-nodes
 */
public class Test1033 {

    int pre = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
    public int minDiffInBST(TreeNode root) {
        // Write your code here
        if (root == null) return 0;
        helper(root);
        return min;
    }

    public void helper(TreeNode root) {
        if (root == null) return;
        helper(root.left);
        min = Math.min(Math.abs(root.val - pre), min);
        pre = root.val;
        helper(root.right);
    }
}
