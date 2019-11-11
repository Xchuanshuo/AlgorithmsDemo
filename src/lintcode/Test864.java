package lintcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Legend
 * @data by on 19-11-10.
 * @description equal-tree-partition
 */
public class Test864 {

    Set<Integer> set = new HashSet<>();
    public boolean checkEqualTree(TreeNode root) {
        // write your code here
        if (root == null) return false;
        int sum = sum(root);
        if (sum % 2 == 1) return false;
        return set.contains(sum / 2);
    }

    public int sum(TreeNode root) {
        if (root.left == null && root.right == null) return root.val;
        int sum = root.val;
        if (root.left != null) {
            int leftSum = sum(root.left);
            sum += leftSum;
            set.add(leftSum);
        }
        if (root.right != null) {
            int rightSum = sum(root.right);
            sum += rightSum;
            set.add(rightSum);
        }
        return sum;
    }
}
