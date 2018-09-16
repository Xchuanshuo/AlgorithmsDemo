package lintcode;

/**
 * @author Legend
 * @data by on 18-9-16.
 * @description convert-sorted-list-to-binary-search-tree
 * idea:
 *      首先找出链表的中点 然后把中点作为树的根节点 接着在左、右子树去
 *      递归遍历链表的两边 最后得出的即是高度平衡的BST
 */
public class Test106 {

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return new TreeNode(head.val);
        ListNode pre = head;
        ListNode post = head.next;
        while (pre.next!=null && post.next!=null && post.next.next!=null) {
            pre = pre.next;
            post = post.next.next;
        }
        ListNode rootNode = pre.next;
        pre.next = null;
        TreeNode root = new TreeNode(rootNode.val);
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(rootNode.next);
        return root;
    }
}
