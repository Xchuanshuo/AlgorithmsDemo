package lintcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Legend
 * @data by on 19-11-8.
 * @description print-binary-tree
 * idea:
 *      1. 先计算高度h, m = h, n = 2^h - 1
 *      2. 难点在于确定要打印的点的位置 利用分治思想 递归处理左右子树
 */
public class Test1105 {

    List<List<String>> res = new ArrayList<>();
    public List<List<String>> printTree(TreeNode root) {
        // Write your code here
        int h = height(root);
        int n = (int)(Math.pow(2, h) - 1);
        for (int i = 0;i < h;i++) {
            List<String> cur = new ArrayList<>();
            int j = 0;
            while (j++ < n) cur.add("");
            res.add(cur);
        }
        helper(root, 0, 0, n, h);
        return res;
    }

    public void helper(TreeNode root, int h, int l, int r, int height) {
        if (h > height - 1 || root == null) return;
        int mid = l + (r - l) / 2;
        res.get(h).set(mid, root.val+"");
        helper(root.left, h + 1, l, mid - 1, height);
        helper(root.right, h + 1, mid  + 1, r, height);
    }

    public int height(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(height(root.left), height(root.right));
    }
}
