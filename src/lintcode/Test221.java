package lintcode;

/**
 * @author Legend
 * @data by on 19-3-24.
 * @description add-two-numbers-ii
 * idea:
 *      1.先将两段链表翻转
 *      2.然后求和进位构造新的链表 最后翻转新的链表
 */
public class Test221 {

    public ListNode addLists2(ListNode l1, ListNode l2) {
        // write your code here
        if (l1 == null || l2 == null) {
            return null;
        }
        ListNode rl1 = reverse(l1);
        ListNode rl2 = reverse(l2);
        ListNode rHead = calculate(rl1, rl2);
        return reverse(rHead);
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

    public ListNode calculate(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode res = dummy;
        int sum = 0;
        while (l1 != null || l2 != null || sum != 0) {
            int val1 = 0, val2 = 0;
            if (l1 != null) {
                val1 = l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                val2 = l2.val;
                l2 = l2.next;
            }
            sum  = val1 + val2 + sum;
            res.next = new ListNode(sum % 10);
            sum = sum >= 10 ? sum / 10 : 0;
            res = res.next;
        }
        return dummy.next;
    }
}
