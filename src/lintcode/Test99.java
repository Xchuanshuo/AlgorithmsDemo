package lintcode;

/**
 * @author Legend
 * @data by on 19-3-23.
 * @description reorder-list
 * idea:
 *      1.使用快慢指针找中间节点 2.中间节点后开始翻转 3.拼接两段链表
 */
public class Test99 {

    public void reorderList(ListNode head) {
        // write your code here
        if (head == null || head.next == null) {
            return;
        }
        ListNode mid = findMid(head);
        ListNode pre = null;
        while (mid != null) {
            ListNode temp = mid.next;
            mid.next = pre;
            pre = mid;
            mid = temp;
        }
        while (head!=null && pre != null) {
            ListNode temp1 = head.next;
            ListNode temp2 = pre.next;
            head.next = pre;
            pre.next = temp1;
            head = temp1;
            pre = temp2;
        }
    }

    public ListNode findMid(ListNode head) {
        ListNode slowNode = head;
        ListNode quickNode = head.next;
        while (quickNode != null && quickNode.next != null) {
            slowNode = slowNode.next;
            quickNode = quickNode.next.next;
        }
        return slowNode;
    }
}
