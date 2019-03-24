package lintcode;

/**
 * @author Legend
 * @data by on 19-3-23.
 * @description odd-even-linked-list
 */
public class Test1292 {

    public ListNode oddEvenList(ListNode head) {
        // write your code here
        if (head == null || head.next == null) {
            return head;
        }
        ListNode node1 = new ListNode(0);
        ListNode dummy = node1;
        ListNode node2 = new ListNode(0);
        ListNode node2Head = node2;
        ListNode cur = head;
        while (cur != null) {
            node1.next = cur;
            node2.next = cur.next;
            node1 = node1.next;
            node2 = node2.next;
            if (cur.next == null) break;
            cur = cur.next.next;
        }
        node1.next = node2Head.next;
        return dummy.next;
    }
}
