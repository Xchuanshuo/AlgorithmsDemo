package lintcode;

import tree.heap.Array;

import java.util.Arrays;

/**
 * @author Legend
 * @data by on 19-11-9.
 * @description construct-binary-tree-from-inorder-and-postorder-traversal
 */
public class Test72 {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = postorder.length, size = 0;
        if (n == 0) return null;
        TreeNode root = new TreeNode(postorder[n-1]);
        if (n == 1) return root;
        for (int i = 0;i < inorder.length;i++) {
            if (inorder[i] == root.val) {
                size = i;
                break;
            }
        }
        root.left = buildTree(Arrays.copyOfRange(inorder, 0, size),
                Arrays.copyOfRange(postorder, 0, size));
        root.right = buildTree(Arrays.copyOfRange(inorder, size + 1, n),
                Arrays.copyOfRange(postorder, size, n - 1));
        return root;
    }
}
