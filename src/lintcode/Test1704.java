package lintcode;

/**
 * @author Legend
 * @data by on 19-11-8.
 * @description
 */
public class Test1704 {

    int sum = 0;
    public int rangeSumBST(TreeNode root, int L, int R) {
        // write your code here.
        inOrder(root, L, R);
        return sum;
    }

    public void inOrder(TreeNode root, int L, int R) {
        if (root == null) return;
        inOrder(root.left, L, R);
        if (root.val > R) return;
        if (root.val >= L) sum += root.val;
        inOrder(root.right, L, R);
    }
}
