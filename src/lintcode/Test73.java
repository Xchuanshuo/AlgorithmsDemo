package lintcode;

import tree.heap.Array;

import java.util.Arrays;

/**
 * @author Legend
 * @data by on 19-11-9.
 * @description construct-binary-tree-from-preorder-and-inorder-traversal
 */
public class Test73 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // write your code here
        int n = preorder.length, size = 0;
        if (n == 0) return null;
        TreeNode root = new TreeNode(preorder[0]);
        if (n == 1) return root;
        for (int i = 0;i < inorder.length;i++) {
            if (inorder[i] == root.val) {
                size = i;
                break;
            }
        }
        root.left = buildTree(Arrays.copyOfRange(preorder, 1, 1 + size),
                Arrays.copyOfRange(inorder, 0, size));
        root.right = buildTree(Arrays.copyOfRange(preorder, size + 1, n),
                Arrays.copyOfRange(inorder, size + 1, n));
        return root;
    }
}
