package lintcode;

/**
 * @author Legend
 * @data by on 19-3-23.
 * @description add-two-numbers
 * idea:
 *      挺trick的一道题 模拟加法的进位, 因为刚好是逆序 所以进位是往后的
 *      发现这个规律问题基本也就解决了 实现时需要注意边界情况
 */
public class Test167 {

    public ListNode addLists(ListNode l1, ListNode l2) {
        // write your code here
        if (l1 == null || l2 == null) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        int sum = 0;
        // sum != 0表示可能链表节点都已经遍历完 但还有需要进的位
        while (l1 != null || l2 != null || sum != 0) {
            int val1 = 0,  val2 = 0;
            if (l1 != null) {
                val1 = l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                val2 = l2.val;
                l2 = l2.next;
            }
            sum = val1 + val2 + sum;
            cur.next = new ListNode(sum%10);
            sum = sum >= 10 ? sum/10  : 0;
            cur = cur.next;
        }
        return dummy.next;
    }
}
