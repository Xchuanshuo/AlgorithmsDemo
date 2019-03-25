package lintcode;

/**
 * @author Legend
 * @data by on 19-3-24.
 * @description find-node-in-linked-list
 */
public class Test225 {

    public ListNode findNode(ListNode head, int val) {
        // write your code here
        if (head == null) {
            return head;
        }
        while (head != null) {
            if (head.val == val) {
                return head;
            }
            head = head.next;
        }
        return null;
    }
}
