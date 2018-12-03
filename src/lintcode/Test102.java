package lintcode;

/**
 * @author Legend
 * @data by on 18-12-3.
 * @description linked-list-cycle
 */
public class Test102 {

    public boolean hasCycle(ListNode head) {
        // write your code here
        if(head == null || head.next == null) {
            return false;
        }

        ListNode p = head.next, q = head;
        while(p != q) {
            if(p == null || p.next == null) {
                return false;
            }
            p = p.next.next;
            q = q.next;
        }
        return true;
    }
}
