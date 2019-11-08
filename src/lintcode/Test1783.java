package lintcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Legend
 * @data by on 19-11-7.
 * @description binary-tree-postorder-traversal-null
 */
public class Test1783 {

    public List<Integer> postorderTraversal(TreeNode root) {
        // write your code here
        List<Integer> res = new ArrayList<>();
        postOrder(root, res);
        return res;
    }

    public void postOrder(TreeNode root, List<Integer> list) {
        if (root == null) return;
        postOrder(root.left, list);
        postOrder(root.right, list);
        list.add(root.val);
    }

}
