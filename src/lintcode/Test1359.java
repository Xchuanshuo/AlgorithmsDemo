package lintcode;

/**
 * @author Legend
 * @data by on 19-11-8.
 * @description convert-sorted-array-to-binary-search-tree
 */
public class Test1359 {

    public TreeNode convertSortedArraytoBinarySearchTree(int[] nums) {
        // Write your code here.
        return helper(nums, 0, nums.length - 1);
    }

    public TreeNode helper(int[] nums, int l, int r) {
        if (l > r) return null;
        int mid = l + (r - l) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums, l, mid - 1);
        root.right = helper(nums, mid + 1, r);
        return root;
    }
}
