package lintcode;

/**
 * @author Legend
 * @data by on 19-3-23.
 * @description nth-to-last-node-in-list
 */
public class Test166 {

    public ListNode nthToLast(ListNode head, int n) {
        // write your code here
        if (head == null) return head;
        ListNode fast = head;
        ListNode slow = head;
        for (int i=0;i < n;i++) {
            fast = fast.next;
        }
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
