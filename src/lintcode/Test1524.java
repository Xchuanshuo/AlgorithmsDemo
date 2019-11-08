package lintcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Legend
 * @data by on 19-11-8.
 * @description search-in-a-binary-search-tree
 */
public class Test1524 {

    public TreeNode searchBST(TreeNode root, int val) {
        // Write your code here.
        if (root == null) return null;
        if (root.val == val) return root;
        else if (root.val < val) return searchBST(root.right, val);
        else return searchBST(root.left, val);
    }
}
