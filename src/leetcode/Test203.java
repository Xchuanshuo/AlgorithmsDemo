package leetcode;

import lintcode.ListNode;

/**
 * @author Legend
 * @data by on 21-6-5.
 * @description https://leetcode-cn.com/problems/remove-linked-list-elements/
 */
public class Test203 {

    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = dummy;
        while (cur != null && cur.next != null) {
            if (cur.next.val == val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return dummy.next;
    }
}
