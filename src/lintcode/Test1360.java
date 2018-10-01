package lintcode;

/**
 * @author Legend
 * @data by on 18-10-1.
 * @description symmetric-tree
 * idea:
 *      对称有几种情况：1.左右节点都为空 2.不为空时需要满足左孩子的左节点与右孩子
 *      的右节点相等 or 左孩子的右节点与右孩子的左节点相等 所以只有一边为空时肯定
 *      不满足对称 递归去进行比较即可
 */
public class Test1360 {

    public boolean isSymmetric(TreeNode root) {
        // Write your code here
        if (root == null) return true;
        return helper(root.left, root.right);
    }

    private boolean helper(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        return helper(left.right, right.left) && helper(left.left, right.right);
    }
}
