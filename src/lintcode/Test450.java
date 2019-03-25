package lintcode;

/**
 * @author Legend
 * @data by on 19-3-25.
 * @description reverse-nodes-in-k-group
 * idea:
 *      关键是拼接每次翻转后的块
 *      1.保存当前的头节点, 也就是翻转后的尾节点
 *      2.翻转 把前一部分的尾节点接上翻转后的头节点
 */
public class Test450 {

    public ListNode reverseKGroup(ListNode head, int k) {
        // write your code here
        if (head == null) {
            return head;
        }
        int count = 0;
        ListNode temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        while (count >= k) {
            head = reverse(head, k);
            count = count - k;
        }
        return dummy.next;
    }

    private ListNode reverse(ListNode head, int k) {
        ListNode newTail = head.next, pre = null;
        ListNode cur = newTail;
        while (cur != null && k > 0) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
            k--;
        }
        // 拼接后部分
        newTail.next = cur;
        // 拼接前一部分
        head.next = pre;
        // 返回新的尾节点 方便后续的翻转
        return newTail;
    }

    public void print(ListNode node) {
        ListNode p = node;
        while (node !=  null) {
            System.out.println(p.val);
            node = node.next;
        }
    }
}
