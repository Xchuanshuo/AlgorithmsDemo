package lintcode;

/**
 * @author Legend
 * @data by on 18-8-8.
 * @description house-robber-iii
 */
public class Test535 {

    public int houseRobber3(TreeNode root) {
        // write your code here
        int[] result = helper(root);
        return Math.max(result[0], result[1]);
    }

    private int[] helper(TreeNode root) {
        if (root == null) return new int[2];
        int[] left = helper(root.left);
        int[] right = helper(root.right);
        int[] result = new int[2];
        // 不抢劫以root为根获得的最大利润
        result[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        // 抢劫以root为根时获得的最大利润
        result[1] = root.val + left[0] + right[0];
        return result;
    }
}
