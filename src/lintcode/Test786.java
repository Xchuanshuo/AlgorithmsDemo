package lintcode;

/**
 * @author Legend
 * @data by on 19-3-25.
 * @description linked-list-weighted-sum-in-reverse-order
 */
public class Test786 {

    public int weightedSumReverse(ListNode head) {
        // ListNode -> val: the value of node ,ListNode -> next: the next node of this node
        if (head == null) {
            return 0;
        }
        int result = 0, count = 0;
        ListNode cur = head;
        while (cur != null) {
            count++;
            cur = cur.next;
        }
        while (head != null){
            result += (count--) * head.val;
            head = head.next;
        }
        return result;
    }

}
