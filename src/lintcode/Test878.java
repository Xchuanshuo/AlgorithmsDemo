package lintcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Legend
 * @data by on 19-11-12.
 * @description boundary-of-binary-tree
 */
public class Test878 {

    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        // write your code here
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        res.add(root.val);
        TreeNode t = root.left;
        while (t != null && (t.left != null || t.right != null)) {
            res.add(t.val);
            t = t.left != null ? t.left : t.right;
        }
        List<Integer> right = new ArrayList<>();
        t = root.right;
        while (t != null && (t.left != null || t.right != null)) {
            right.add(t.val);
            t = t.right != null ? t.right : t.left;
        }
        dfs(root, res);
        Collections.reverse(right);
        res.addAll(right);
        List<Double> list = new ArrayList<>();
        list.stream().mapToDouble(Double::doubleValue).average();
        return res;
    }

    public void dfs(TreeNode root, List<Integer> res) {
        if (root == null) return;
        if (root.left == null && root.right == null) res.add(root.val);
        dfs(root.left, res);
        dfs(root.right, res);
    }

}
