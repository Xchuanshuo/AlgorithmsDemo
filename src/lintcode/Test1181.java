package lintcode;

/**
 * @author Legend
 * @data by on 19-11-10.
 * @description diameter-of-binary-tree
 */
public class Test1181 {

    public int diameterOfBinaryTree(TreeNode root) {
        return helper(root.left) + helper(root.right);
    }

    public int helper(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(helper(root.left), helper(root.right));
    }

    public static void main(String[] args) {
        System.out.println(Math.round(188.0/100.0));
    }
    
}
