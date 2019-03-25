package lintcode;

/**
 * @author Legend
 * @data by on 19-3-25.
 * @description plus-one-linked-list
 */
public class Test904 {

    public ListNode plusOne(ListNode head) {
        // Write your code here
        if (head == null) {
            return head;
        }
        ListNode headReverse = reverse(head);
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        int sum = 1;
        while (headReverse != null || sum != 0) {
            int val = 0;
            if (headReverse != null) {
                val = headReverse.val;
                headReverse = headReverse.next;
            }
            sum = sum + val;
            cur.next = new ListNode(sum % 10);
            sum = sum >= 10 ? sum / 10 : 0;
            cur = cur.next;
        }
        return reverse(dummy.next);
    }

    public ListNode reverse(ListNode head) {
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
