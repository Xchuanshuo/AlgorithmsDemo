package lintcode;

/**
 * @author Legend
 * @data by on 19-3-25.
 * @description swap-two-nodes-in-linked-list
 * idea:
 *     需要注意有两种情况 一种是两个节点相连, 一种是不相连
 */
public class Test511 {

    public ListNode swapNodes(ListNode head, int v1, int v2) {
        // write your code here
        if (head == null) {
            return head;
        }
        ListNode node1Pre = null, node2Pre = null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        while (cur.next != null) {
            if (cur.next.val == v1) {
                node1Pre = cur;
            } else if (cur.next.val == v2){
                node2Pre = cur;
            }
            cur = cur.next;
        }
        if (node1Pre == null || node2Pre == null) {
            return head;
        }
        // 保证node1在node2的前面 方便后续的逻辑
        if (node2Pre.next == node1Pre) {
            ListNode temp = node1Pre;
            node1Pre = node2Pre;
            node2Pre = temp;
        }
        ListNode node1 = node1Pre.next;
        ListNode node2 = node2Pre.next;
        ListNode node2Next = node2.next;
        if (node1Pre.next == node2Pre) {
            node1Pre.next = node2;
            node2.next = node1;
            node1.next = node2Next;
        } else {
            node1Pre.next = node2;
            node2.next = node1.next;
            node2Pre.next = node1;
            node1.next = node2Next;
        }
        return dummy.next;
    }
}
