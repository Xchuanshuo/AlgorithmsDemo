package leetcode;

import lintcode.ListNode;
import lintcode.TreeNode;

/**
 * @author Legend
 * @data by on 21-5-21.
 * @description https://leetcode-cn.com/problems/linked-list-in-binary-tree/
 */
public class Test1367 {

    public boolean isSubPath(ListNode head, TreeNode root) {
        return dfs(head, root);
    }

    private boolean dfs(ListNode head, TreeNode root) {
        if (root == null) return false;
        boolean res = helper(head, root);
        if (res) {
            return true;
        } else {
            return dfs(head, root.left) || dfs(head, root.right);
        }
    }

    private boolean helper(ListNode head, TreeNode root) {
        if (head == null) return true;
        if (root == null) return false;
        boolean res = false;
        if (root.val == head.val) {
            res = helper(head.next, root.left);
            if (!res) res = helper(head.next, root.right);
        }
        return res;
    }
}
