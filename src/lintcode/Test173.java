package lintcode;

/**
 * @author Legend
 * @data by on 19-3-23.
 * @description insertion-sort-list
 */
public class Test173 {

    public ListNode insertionSortList(ListNode head) {
        // write your code here
        // 固定头节点 用于每次扫描进行判断
        ListNode dummy = new ListNode(0);
        while (head != null) {
            ListNode node = dummy;
            while (node.next != null && node.next.val < head.val) {
                node = node.next;
            }
            ListNode temp = head.next;
            head.next = node.next;
            node.next = head;
            head = temp;
        }
        return dummy.next;
    }
}
