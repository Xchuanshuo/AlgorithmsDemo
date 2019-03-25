package lintcode;


import java.util.HashSet;
import java.util.Set;

/**
 * @author Legend
 * @data by on 19-3-24.
 * @description remove-duplicates-from-unsorted-list
 */
public class Test217 {

    public ListNode removeDuplicates(ListNode head) {
        // write your code here
        if (head == null || head.next == null) {
            return head;
        }
        Set<Integer> set = new HashSet<>();
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode cur = dummyHead;
        while (cur != null && cur.next != null) {
            if (set.contains(cur.next.val)) {
                ListNode delNode = cur.next;
                cur.next = delNode.next;
                delNode.next = null;
            } else {
                set.add(cur.next.val);
                cur = cur.next;
            }
        }
        return dummyHead.next;
    }
}
