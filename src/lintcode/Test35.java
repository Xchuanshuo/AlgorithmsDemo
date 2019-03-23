package lintcode;

import java.util.Date;

/**
 * @author Legend
 * @data by on 19-3-23.
 * @description reverse-linked-list
 */
public class Test35 {

    public ListNode reverse(ListNode head) {
        // write your code here
        ListNode pre = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = pre;
            pre = head;
            head = temp;
        }
        return pre;
    }
}
