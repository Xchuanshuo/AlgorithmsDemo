package lintcode;

/**
 * @author Legend
 * @data by on 18-12-20.
 * @description remove-duplicates-from-sorted-list
 */
public class Test112 {

    public ListNode deleteDuplicates(ListNode head) {
        // write your code here
        ListNode node = new ListNode(1);
        node.next = new ListNode(1);
        return null;
    }

    private ListNode helper(ListNode head, ListNode headNext) {
        if (head == null || headNext == null) {
            return null;
        }
        ListNode node = helper(head, head.next);
        if (head.val == head.next.val) {
            return node;
        } else {
            head.next = node;
            return head;
        }
    }
}
